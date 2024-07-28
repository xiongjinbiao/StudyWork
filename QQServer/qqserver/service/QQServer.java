package qqserver.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import qqcommon.MessageType;
import qqcommon.Message;
import qqcommon.User;

public class QQServer {

	private ServerSocket ss = null;

	private static HashMap<String, User> validUsers = new HashMap<>();

	static { // 在静态代码块，初始化 validUsers

		validUsers.put("100", new User("100", "123456"));
		validUsers.put("200", new User("200", "123456"));
		validUsers.put("300", new User("300", "123456"));
		validUsers.put("至尊宝", new User("至尊宝", "123456"));
		validUsers.put("紫霞仙子", new User("紫霞仙子", "123456"));
		validUsers.put("菩提老祖", new User("菩提老祖", "123456"));

	}

	/**
	 * 验证用户是否有效的方法
	 * 
	 * @param userId
	 * @param passwd
	 * @return
	 */
	private boolean checkUser(String userId, String passwd) {
		User user = validUsers.get(userId);
		if (user == null) {
			return false;
		}
		if (!user.getPasswd().equals(passwd)) {
			return false;
		}
		return true;
	}

	public QQServer() {

		System.out.println("服务器在监听9999端口");
		new Thread(new SendNewsToAllService()).start();
		try {
			ss = new ServerSocket(9999);
			while (true) {
				Socket socket = ss.accept();
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				User u = (User) ois.readObject();
				Message message = new Message();

				if (checkUser(u.getUserId(), u.getPasswd())) {
					message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
					oos.writeObject(message);
					ServerConnectClientThread scct = new ServerConnectClientThread(socket, u.getUserId());
					scct.start();
					ManageServerConnectClientThread.addServerConnectClientThread(u.getUserId(), scct);
				} else {
					message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
					oos.writeObject(message);
					socket.close();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 如果服务器退出while，说明服务器不在监听，退出ServerSocket
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
