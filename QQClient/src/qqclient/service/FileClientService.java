package qqclient.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import qqcommon.Message;
import qqcommon.MessageType;

public class FileClientService {

	/**
	 * 传文件
	 * 
	 * @param src
	 * @param dest
	 * @param sendId
	 * @param getterId
	 */
	public void sendFileToOne(String src, String dest, String senderId, String getterId) {

		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_SEND_FILE);
		message.setSrc(src);
		message.setDest(dest);
		message.setSender(senderId);
		message.setGetter(getterId);

		FileInputStream fis = null;
		byte[] fileBytes = new byte[(int) new File(src).length()];

		try {
			fis = new FileInputStream(src);
			fis.read(fileBytes);
			message.setFileBytes(fileBytes);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("\n" + senderId + "给" + getterId + "发送文件：" + src + " 到对方的电脑目录 " + dest);

		try {
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
					.getClientConnectServerThreadByUserId(senderId).getSocket().getOutputStream());
			oos.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
