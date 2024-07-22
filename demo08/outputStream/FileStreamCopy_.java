package demo08.outputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileStreamCopy_ {
	public static void main(String[] args) {

	}

	@Test
	public void copyFile() {

		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		String srcFilePath = "/Users/user/Documents/news1.txt";
		String destFilePath = "/Users/user/Documents/news3.txt";

		byte[] buf = new byte[1024];
		int readLen = 0;

		try {
			fileInputStream = new FileInputStream(srcFilePath);
			fileOutputStream = new FileOutputStream(destFilePath, true);

			while ((readLen = fileInputStream.read(buf)) != -1) {
				fileOutputStream.write(buf, 0, readLen);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
