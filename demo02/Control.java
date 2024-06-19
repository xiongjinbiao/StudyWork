package demo02;

public class Control {
	public static void main(String[] args) {
		
		// break
		int count = 0;
		while(true) {
			if ((int)(Math.random()*100)+1 != 97) {
				count++;
			} else break;
		}
//		System.out.println(count);
		
		int sum = 0;
		int i = 1;
		for (; i <= 100; i++) {
			sum += i;
			if (sum >= 20) {
				break;
			}
		}
//		System.out.println(sum);
		
		//continue
		label1:
		for (int j = 1; j < 3; j++) {
			label2:
			for (int j2 = 1; j2 < 4; j2++) {
				if (j2 == 2) {
					continue label1;
				}
				System.out.print(j2);
			}
			System.out.println();
		}
		
	}
}