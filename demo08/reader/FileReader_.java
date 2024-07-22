package demo08.reader;

import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileReader_ {
	public static void main(String[] args) {

	}

	/**
	 * 按照字符数组读取,效率高
	 */

	public void ReadFile01() {
		String filePath = "/Users/user/Documents/news1.txt";

		FileReader fileReader = null;
		char[] buf = new char[8];
		int readLen = 0;

		try {
			fileReader = new FileReader(filePath);
			while ((readLen = fileReader.read(buf)) != -1) {
				System.out.print(new String(buf, 0, readLen));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按照单个字符读取,效率低
	 */
	@Test
	public void ReadFile02() {
		String filePath = "/Users/user/Documents/news1.txt";

		FileReader fileReader = null;
		int data = 0;

		try {
			fileReader = new FileReader(filePath);
			while ((data = fileReader.read()) != -1) {
				System.out.print((char) data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
