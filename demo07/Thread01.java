package demo07.threadUse;

public class Thread01 {
	public static void main(String[] args) throws InterruptedException {

		Cat cat = new Cat();
		cat.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("主线程 i " + i);
			Thread.sleep(100);
		}

	}
}

class Cat extends Thread {
	@Override
	public void run() {
		int times = 0;

		while (true) {
			System.out.println("喵喵 我是小猫 " + (++times) + "线程名 " + Thread.currentThread().getName());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (times == 4) {
				break;
			}
		}

	}
}