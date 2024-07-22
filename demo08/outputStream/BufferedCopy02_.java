package demo08.outputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedCopy02_ {
	public static void main(String[] args) {
		String srcFilePath = "/Users/user/StudyWork/tankGame/MyPanel.java";
		String destFilePath = "/Users/user/Documents/news3.txt";

		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		int readLen = 0;
		// 定义一个子节缓冲区
		byte[] buf = new byte[1024];

		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFilePath));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
			while ((readLen = bufferedInputStream.read(buf)) != -1) {
				bufferedOutputStream.write(buf, 0, readLen);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (bufferedInputStream != null) {
					bufferedInputStream.close();
				}
				if (bufferedOutputStream != null) {
					bufferedOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
