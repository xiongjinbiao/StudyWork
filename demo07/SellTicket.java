package demo07.threadUse;

public class SellTicket {
	public static void main(String[] args) {

		SellTicket02 sellTicket02 = new SellTicket02();
		new Thread(sellTicket02).start();
		new Thread(sellTicket02).start();
		new Thread(sellTicket02).start();

	}
}

// 继承Thread类（存在线程插队现象）
// extends Thread加锁没有意义，还是无法解决插队现象
// 原因每次开启一个子线程时候都需要new SellTicket01() ，无法保证三个子线程共用一把锁
//class SellTicket01 extends Thread {
//	
//	private static int ticketNum = 20;
//	private boolean loop = true;
//	
//	public void sell() {
//		if (ticketNum <= 0) {
//			System.out.println("售票结束。。。");
//			loop = false;
//			return;
//		}
//		try {
//			Thread.sleep(50);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余" + (--ticketNum) + "张票");
//	}
//	
//	@Override
//	public void run() {
//		while (loop) {
//			sell();
//		}
//	}
//}

class SellTicket02 implements Runnable {

	private static int ticketNum = 20;
	private boolean loop = true;

	// 静态方法加锁
	 public synchronized static void m1() {
		 
	 }
	 
	 public static void m2() {
		 synchronized (SellTicket02.class) {
			 System.out.println();
		}
	 }
	
	//非静态方法(3种方法)
	 Object object = new Object();
	public /* synchronized */ void sell() {
		synchronized (/*this*/object) {
			if (ticketNum <= 0) {
				System.out.println("售票结束。。。");
				loop = false;
				return;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票，剩余" + (--ticketNum) + "张票");
		}
	}

	@Override
	public void run() {
		while (loop) {
			sell();
		}
	}

}