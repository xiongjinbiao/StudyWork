package demo08.outputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileOutputStream_ {
	public static void main(String[] args) {

	}

	@Test
	public void writeFile01() {
		String filePath = "/Users/user/Documents/news2.txt";
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filePath, true);
			String str = "hello world";
			fileOutputStream.write(str.getBytes(), 0, str.length());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
