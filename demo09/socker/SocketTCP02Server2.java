package demo09.socker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP02Server2 {
	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(9999);
		Socket socket = serverSocket.accept();

		InputStream inputStream = socket.getInputStream();
		// 使用字符流
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		String s = null;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}

//		byte[] buf = new byte[1024];
//		int readLen = 0;
//		while ((readLen = inputStream.read(buf)) != -1) {
//			System.out.println(new String(buf, 0, readLen));
//		}

		OutputStream outputStream = socket.getOutputStream();
		// 使用字符流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
		bw.write("hello client 字符流");
		bw.newLine();
		bw.flush();
		
//		outputStream.write("hello client".getBytes());
//		socket.shutdownOutput();

		serverSocket.close();
		socket.close();
		br.close();
		bw.close();

	}
}
