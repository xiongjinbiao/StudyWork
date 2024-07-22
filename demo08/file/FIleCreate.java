package demo08.file;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FIleCreate {
	public static void main(String[] args) {

	}

	@Test
	public void create01() {
		String filePath = "/Users/user/Documents/news1.txt";
		File file = new File(filePath);
		try {
			file.createNewFile();
			System.out.println("file created successed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void create02() {
		File parentFile = new File("/Users/user/Documents/");
		String fileName = "news2.txt";
		File file = new File(parentFile, fileName);
		try {
			file.createNewFile();
			System.out.println("file created successed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void create03() {
		String parentFile = "/Users/user/Documents/";
		String fileName = "news3.txt";
		File file = new File(parentFile, fileName);
		try {
			file.createNewFile();
			System.out.println("file created successed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
