package qqclient.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import qqcommon.Message;
import qqcommon.MessageType;
import qqcommon.User;

public class UserClientService {
	private User u = new User();
	private Socket socket;

	public boolean checkUser(String userId, String pwd) {

		boolean b = false;

		u.setUserId(userId);
		u.setPasswd(pwd);

		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(u);

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Message ms = (Message) ois.readObject();

			if (ms.getMesType() == MessageType.MESSAGE_LOGIN_SUCCEED) {
				ClientConnectServerThread ccst = new ClientConnectServerThread(socket);
				ccst.start();
				ManageClientConnectServerThread.addClientConnectServerThread(userId, ccst);
				b = true;
			} else {
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return b;
	}

	/**
	 * 获取好友列表
	 */
	public void onlineFriendList() {

		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
		message.setSender(u.getUserId());

		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
					.getClientConnectServerThreadByUserId(u.getUserId()).getSocket().getOutputStream());
			oos.writeObject(message);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 退出系统
	 */
	public void logout() {

		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
		message.setSender(u.getUserId());

		try {

			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
					.getClientConnectServerThreadByUserId(u.getUserId()).getSocket().getOutputStream());
			System.out.println(u.getUserId() + "退出系统");
			oos.writeObject(message);
			// 结束进程
			System.exit(0);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
