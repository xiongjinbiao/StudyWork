package qqclient.view;

import qqclient.service.FileClientService;
import qqclient.service.MessageClientService;
import qqclient.service.UserClientService;
import qqclient.utils.Utility;

public class QQView {

	public static void main(String[] args) {
		new QQView().mainView();
	}

	private boolean loop = true;
	private String key = "";

	private UserClientService userClientService = new UserClientService();
	private MessageClientService messageClientService = new MessageClientService();
	private FileClientService fileClientService = new FileClientService();

	/**
	 * 显示主菜单
	 */
	public void mainView() {
		while (loop) {

			System.out.println("====欢迎登录网络通信系统====");
			System.out.println("\t\t 1 登录系统");
			System.out.println("\t\t 9 退出系统");

			key = Utility.readString(1);

			switch (key) {
			case "1":
				System.out.println("请输入用户名：");
				String userId = Utility.readString(50);
				System.out.println("请输入密码：");
				String passwd = Utility.readString(50);
				if (userClientService.checkUser(userId, passwd)) {
					System.out.println("====欢迎（用户" + userId + "）====");
					while (loop) {
						System.out.println("====网络通信系统二级菜单（用户" + userId + "）====");
						System.out.println("\t\t 1 显示在线用户列表");
						System.out.println("\t\t 2 群发消息");
						System.out.println("\t\t 3 私聊消息");
						System.out.println("\t\t 4 发送文件");
						System.out.println("\t\t 9 退出系统");
						key = Utility.readString(1);
						switch (key) {
						case "1":
							System.out.println("显示在线用户列表");
							userClientService.onlineFriendList();
							break;
						case "2":
							System.out.println("请输入想对大家说的话");
							String contentAll = Utility.readString(50);
							messageClientService.sendMessageToAll(contentAll, userId);
							break;
						case "3":
							System.out.println("请输入想聊天的用户(在线)：");
							String getterId = Utility.readString(50);
							System.out.println("请输入你想说的话：");
							String contentOne = Utility.readString(100);
							messageClientService.sendMessageToOne(contentOne, userId, getterId);
							break;
						case "4":
							System.out.println("输入你要发送文件的用户(在线)：");
							getterId = Utility.readString(50);
							System.out.println("输入你要发送文件的路径：");
							String src = Utility.readString(100);
							System.out.println("输入你要接收文件的路径：");
							String dest = Utility.readString(100);
							fileClientService.sendFileToOne(src, dest, userId, getterId);
							break;
						case "9":
							userClientService.logout();
							loop = false;
							break;
						}
					}
				} else {
					System.out.println("登录失败");
				}
				break;
			case "9":
				loop = false;
				break;
			}

		}
	}

}
