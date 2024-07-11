package demo07.threadUse;

public class ThreadMethod03 {
	public static void main(String[] args) throws InterruptedException {

		T4 t4 = new T4();
		t4.setDaemon(true);// 设置子线程为守护线程，即主线程退出，子线程也会退出
		t4.start();

		for (int i = 0; i < 4; i++) {
			System.out.println("宝强还在幸苦工作");
			Thread.sleep(1000);
		}

		System.out.println("宝强工作结束了,马蓉不敢happy了");

	}
}

class T4 extends Thread {
	@Override
	public void run() {

		for (;;) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("马蓉还在happy");
		}

	}
}