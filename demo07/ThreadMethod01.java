package demo07.threadUse;

public class ThreadMethod01 {
	public static void main(String[] args) throws InterruptedException {
		
		T t = new T();
		t.setName("lao xiong");
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();

		for (int i = 0; i < 5; i++) {
			Thread.sleep(500);
			System.out.println("hi " + i);
		}

		t.interrupt();

	}
}

class T extends Thread {

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < 4; i++) {
				System.out.println(Thread.currentThread().getName() + " eat " + i + " ge baozi");
			}

			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + "be to interrupted");
			}
		}
	}

}