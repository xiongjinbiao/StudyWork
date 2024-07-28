package qqclient.service;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import qqcommon.Message;
import qqcommon.MessageType;

public class MessageClientService {

	/**
	 * 私聊消息
	 * @param content
	 * @param senderId
	 * @param getterId
	 */
	public void sendMessageToOne(String content, String senderId, String getterId) {

		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_COMM_MES);
		message.setSender(senderId);
		message.setGetter(getterId);
		message.setContent(content);
		message.setSendTime(new Date().toString());

		System.out.println(senderId + "对" + getterId + "说" + content);

		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
					.getClientConnectServerThreadByUserId(senderId).getSocket().getOutputStream());
			oos.writeObject(message);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 群发消息
	 * @param content
	 * @param senderId
	 */
	public void sendMessageToAll(String content,String senderId) {
		Message message = new Message();
		message.setMesType(MessageType.MESSAGE_COMM_MES);
		message.setSender(senderId);
		message.setContent(content);
		message.setSendTime(new Date().toString());

		System.out.println(senderId + "对大家说" + content);
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(ManageClientConnectServerThread
					.getClientConnectServerThreadByUserId(senderId).getSocket().getOutputStream());
			oos.writeObject(message);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
