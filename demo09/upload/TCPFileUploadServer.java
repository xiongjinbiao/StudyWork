package demo09.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileUploadServer {
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(8888);
		Socket socket = serverSocket.accept();

		// 读取client端socket中bos
		BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
		byte[] bytes = StreamUtils.streamToByteArray(bis);

		String destFilePath = "";
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
		bos.write(bytes);
		bos.close();

		// 向client端发送消息，拷贝完成
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bw.write("拷贝完成");
		bw.flush();
		bw.close();
		// 写完结束标记
		socket.shutdownOutput();

		bis.close();
		socket.close();
		serverSocket.close();

	}
}
