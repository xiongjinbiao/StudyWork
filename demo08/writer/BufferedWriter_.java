package demo08.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
	public static void main(String[] args) throws IOException {
		String filePath = "/Users/user/Documents/news1.txt";
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));

		bufferedWriter.write("hello man");
		bufferedWriter.newLine();
		bufferedWriter.write("hello xiong jin biao");

		bufferedWriter.close();
	}
}
