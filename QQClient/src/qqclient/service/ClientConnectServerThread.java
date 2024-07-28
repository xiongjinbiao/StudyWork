package qqclient.service;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import qqcommon.Message;
import qqcommon.MessageType;

public class ClientConnectServerThread extends Thread {

	private Socket socket;

	public ClientConnectServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		while (true) {
			System.out.println("客户端线程，等待从读取服务器端发送的消息");

			try {

				// 接收服务器端的消息
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message message = (Message) ois.readObject();

				// 根据服务器端的消息类型作出不同操作
				if (message.getMesType().equals(MessageType.MESSAGE_RET_ONLINE_FRIEND)) {
					System.out.println("======当前在线用户列表======");
					String[] onlineUsers = message.getContent().split(" ");
					for (int i = 0; i < onlineUsers.length; i++) {
						System.out.println("用户：" + onlineUsers[i]);
					}

				} else if (message.getMesType().equals(MessageType.MESSAGE_SEND_TO_ALL)) {
					System.out.println("\n" + message.getSender() + "对大家说：" + message.getContent());

				} else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) {
					System.out.println(
							"\n" + message.getSender() + "对" + message.getGetter() + "说" + message.getContent());

				} else if (message.getMesType().equals(MessageType.MESSAGE_SEND_FILE)) {
					System.out.println("\n" + message.getSender() + "给" + message.getGetter() + "发送文件："
							+ message.getSrc() + " 到对方的电脑目录 " + message.getDest());
					FileOutputStream fos = new FileOutputStream(message.getDest());
					fos.write(message.getFileBytes());
					fos.close();
					System.out.println("\n保存文件成功");
				} else {
					System.out.println("其他消息类型，暂不处理");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public Socket getSocket() {
		return socket;
	}

}
