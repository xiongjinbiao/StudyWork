package demo09.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPFileUploadClient {
	public static void main(String[] args) throws Exception {

		Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
		String filePath = "";
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

		byte[] bytes = StreamUtils.streamToByteArray(bis);

		// 将读到的bis再写到socket的bos中，让server端的socket的bis读取
		BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		bos.write(bytes);
		bis.close();
		// 写完结束标记
		socket.shutdownOutput();
		
		

		bos.close();
		socket.close();

	}
}
