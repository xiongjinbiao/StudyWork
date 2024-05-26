package demo01;

public class Function {
	
	public void getGrade(char grade) {
		
		switch(grade) {
		case 'A' :
			System.out.println("优秀");
			break;
		case 'B' :
			System.out.println("良好");
			break;
		case 'C' :
			System.out.println("及格");
			break;
		case 'D' :
			System.out.println("不及格");
			break;
		default :
			System.out.println("等级不匹配，输入错误");
		}
		
	}
	
	public static void main(String[] args) {
//		getGrade('A');
	}
	
}
