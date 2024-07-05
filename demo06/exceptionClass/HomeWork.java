package demo06.exceptionClass;

public class HomeWork {
	public static void main(String[] args) {

		String user = "xiong";
		String pwd = "123123123as";
		String email = "sadasd@qq.com";

		if (!(strIsEmpty(user) && strIsEmpty(pwd) && strIsEmpty(email))) {
			throw new RuntimeException("user and pwd and email all not be allowed to be null");
		}

		// 判断密码长度大于6位且必须包含两个以上的非数字字符
		if (pwd.length() >= 6) {
			char[] chars = pwd.toCharArray();
			int count = 0;
			for (char c : chars) {
				if (c > '9') {
					count++;
				}
			}
			if (count < 2) {
				throw new RuntimeException("pwd must contain more than 2 is not digital");
			}
		} else {
			throw new RuntimeException("pwd length must more than 6");
		}

		// 判断邮箱格式
		int n1 = email.indexOf("@");
		int n2 = email.indexOf(".");
		int n3 = email.indexOf("com");
		if (!(n1 > 0 && n1 < n2 && n2 < n3)) {
			throw new RuntimeException("email's format isn't correct");
		}

		System.out.println("email register coorectly");

	}

	public static boolean strIsEmpty(String str) {
		if (!(str != null)) {
			return false;
		} else {
			return true;
		}
	}

}
