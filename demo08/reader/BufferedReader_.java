package demo08.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_ {
	public static void main(String[] args) throws IOException {
		
		String filePath = "/Users/user/StudyWork/tankGame/MyPanel.java";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}

		bufferedReader.close();
	}
}
