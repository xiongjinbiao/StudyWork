package demo09.socker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP02Client {
	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

		OutputStream outputStream = socket.getOutputStream();
		// 使用字符流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
		bw.write("hello server 字符流");
		// 字符流需要手动刷新
		bw.newLine();
		bw.flush();
		socket.shutdownOutput();

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

		socket.close();
		bw.close();
		br.close();
	}
}
