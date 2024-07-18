package demo07.threadUse;

public class ThreadHomeWork02 {
	public static void main(String[] args) {

		T5 t5 = new T5();
		Thread men1 = new Thread(t5);
		men1.setName("men1");
		Thread men2 = new Thread(t5);
		men2.setName("men2");

		men1.start();
		men2.start();

	}
}

class T5 implements Runnable {

	private int money = 10000;

	@Override
	public void run() {

		synchronized (this) {
			while (true) {
				if (money <= 0) {
					System.out.println("没钱了");
					break;
				}
				money -= 1000;
				System.out.println(Thread.currentThread().getName() + "取了1000，剩余" + money);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	}
}