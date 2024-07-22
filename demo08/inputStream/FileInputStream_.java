package demo08.inputStream;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

@SuppressWarnings("all")
public class FileInputStream_ {
	public static void main(String[] args) {

	}

	// 出现中文乱码
	public void readFile01() {
		String filePath = "/Users/user/Documents/news1.txt";
		int readData = 0;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			while ((readData = fileInputStream.read()) != -1) {
				System.out.print((char) readData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void readFile02() {
		String filePath = "/Users/user/Documents/news3.txt";
		int readLength = 0;
		byte[] buf = new byte[1024];
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			while ((readLength = fileInputStream.read(buf)) != -1) {
				System.out.print(new String(buf, 0, readLength));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
