package demo07.threadUse;

public class ThreadExit_ {
	public static void main(String[] args) throws InterruptedException {

		TExit tExit = new TExit();
		tExit.start();

		// 主线程休眠十秒，再通知子线程退出
		Thread.sleep(4 * 1000);
		tExit.setLoop(false);

	}
}

class TExit extends Thread {
	private int times = 0;
	private boolean loop = true;

	@Override
	public void run() {
		while (loop) {
			System.out.println("喵喵 我是小猫 " + (++times) + "线程名 " + Thread.currentThread().getName());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

}