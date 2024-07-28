package qqserver.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import qqcommon.Message;
import qqcommon.MessageType;

public class ServerConnectClientThread extends Thread {

	private Socket socket;
	private String userId;

	public ServerConnectClientThread(Socket socket, String userId) {
		super();
		this.socket = socket;
		this.userId = userId;
	}

	public Socket getSocket() {
		return socket;
	}

	public void run() {
		while (true) {

			try {
				System.out.println("服务端和客户端" + userId + "保持通信，读取数据");

				// 接收客户端消息
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message message = (Message) ois.readObject();

				// 根据客户端消息类型作出不同的操作
				if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {

					System.out.println(message.getSender() + "要用户列表");
					String onlineUser = ManageServerConnectClientThread.getOnlineuser();

					Message message2 = new Message();
					message2.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
					message2.setContent(onlineUser);
					message2.setGetter(message.getSender());

					// 回message2给客户端
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					oos.writeObject(message2);

				} else if (message.getMesType().equals(MessageType.MESSAGE_SEND_FILE)) {
					ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClientThread
							.getServerConnectClientThreadByUserId(message.getGetter()).getSocket().getOutputStream());
					oos.writeObject(message);

				}else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
					ObjectOutputStream oos = new ObjectOutputStream(ManageServerConnectClientThread
							.getServerConnectClientThreadByUserId(message.getGetter()).getSocket().getOutputStream());
					oos.writeObject(message);

				} else if (message.getMesType().equals(MessageType.MESSAGE_SEND_TO_ALL)) {
					HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.getHm();
					Iterator<String> iterator = hm.keySet().iterator();
					while (iterator.hasNext()) {
						String onlineUserId = iterator.next().toString();
						if (!onlineUserId.equals(message.getSender())) {
							ObjectOutputStream oos = new ObjectOutputStream(
									hm.get(onlineUserId).getSocket().getOutputStream());
							oos.writeObject(message);
						}
					}
				}

				else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
					System.out.println(message.getSender() + " 退出");
					ManageServerConnectClientThread.removeServerConnectClientThreadByUserId(message.getSender());
					socket.close();
				}

				else {
					System.out.println("其他消息类型，暂不处理");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
