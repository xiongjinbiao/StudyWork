package demo08.writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCopy_ {
	public static void main(String[] args) {
		String srcFilePath = "/Users/use/Documents/news1.txt";
		String destFilePath = "/Users/user/Documents/news3.txt";
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		String line;

		try {
			bufferedReader = new BufferedReader(new FileReader(srcFilePath));
			bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));
			while ((line = bufferedReader.readLine()) != null) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
