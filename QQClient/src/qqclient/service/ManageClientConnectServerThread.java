package qqclient.service;

import java.util.HashMap;

public class ManageClientConnectServerThread {

	private static HashMap<String, ClientConnectServerThread> hm = new HashMap<>();

	public static void addClientConnectServerThread(String userId, ClientConnectServerThread ccst) {
		hm.put(userId, ccst);
	}

	public static ClientConnectServerThread getClientConnectServerThreadByUserId(String userId) {
		return hm.get(userId);
	}

	public static HashMap<String, ClientConnectServerThread> getHm() {
		return hm;
	}


}
