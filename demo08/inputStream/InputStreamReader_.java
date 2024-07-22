package demo08.inputStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_  {
	public static void main(String[] args) throws IOException{
		
		String filePath = "/Users/user/StudyWork/tankGame/MyPanel.java";

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
			
			String read;
					while((read = bufferedReader.readLine()) != null) {
						System.out.println(read);
					}
	
			bufferedReader.close();
		
	}
}
