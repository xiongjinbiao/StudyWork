package qqserver.service;

import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class ManageServerConnectClientThread {

	private Socket socket;
	
	public ManageServerConnectClientThread(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public Socket getSocket() {
		return socket;
	}

	private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();
	
	public static HashMap<String, ServerConnectClientThread> getHm() {
		return hm;
	}

	public static void addServerConnectClientThread(String usreId, ServerConnectClientThread scct) {
		hm.put(usreId, scct);
	}

	public static ServerConnectClientThread getServerConnectClientThreadByUserId(String userId) {
		return hm.get(userId);
	}

	public static void removeServerConnectClientThreadByUserId(String userId) {
		hm.remove(userId);
	}

	public static String getOnlineuser() {

		Iterator<String> iterator = hm.keySet().iterator();
		String sb = "";

		while (iterator.hasNext()) {
			sb += iterator.next() + " ";
		}

		return sb;
	}


}
