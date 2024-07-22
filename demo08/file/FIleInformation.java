package demo08.file;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FIleInformation {
	public static void main(String[] args) {

	}

	public void info() {
		File file = new File("/Users/user/Documents/news1.txt");
		System.out.println("文件名字 " + file.getName() + "\n" + "文件绝对路径 " + file.getAbsolutePath() + "\n" + "文件父级目录 "
				+ file.getParent() + "\n" + "文件大小（字节） " + file.length() + "\n" + "文件是否存在 " + file.exists());
	}

	@Test
	public void delete() {
		File file = new File("/Users/user/Documents/demoStudy");
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("文件或者目录删除成功");
			}
		} else {
			System.out.println("文件或者目录不存在");
		}
	}

	public void createDirectory() {
		File directionaryPath = new File("/Users/user/Documents/demoStudy");
		if (directionaryPath.exists()) {
			System.out.println("目录已存在");
		} else {
			if (directionaryPath.mkdirs()) {
				System.out.println("目录创建成功");
			}
		}
	}

}
