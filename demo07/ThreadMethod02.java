package demo07.threadUse;

public class ThreadMethod02 {
	public static void main(String[] args) throws InterruptedException {

		T3 t2 = new T3();
		t2.start();

		for (int i = 1; i <= 10; i++) {
			Thread.sleep(1000);
			System.out.println("主线程（小弟）吃了" + i + "个包子");
			if (i == 5) {
				System.out.println("主线程（小弟）让子线程（大哥）先吃");
				t2.join(); //插队一定成功
//				Thread.yield(); //插队不一定成功
				System.out.println("子线程（大哥）吃完了，主线程（大哥）接着吃。。。");
			}
		}

	}
}

class T3 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("子线程（大哥）吃了" + i + "个包子");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}