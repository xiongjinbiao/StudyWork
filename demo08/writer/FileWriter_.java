package demo08.writer;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileWriter_ {
	public static void main(String[] args) {
		
	}

	@Test
	public void FileWrite01() {
		String filePath = "/Users/user/Documents/news2.txt";

		FileWriter fileWriter = null;
		char[] chars = { '2', '3' };
		try {
			fileWriter = new FileWriter(filePath, true);
			fileWriter.write('1');
			fileWriter.write(chars);
			fileWriter.write("xiongjinbiao");
			fileWriter.write("ni hao a", 0, 7);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
