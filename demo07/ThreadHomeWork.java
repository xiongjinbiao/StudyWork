package demo07.threadUse;

import java.util.Scanner;

public class ThreadHomeWork {
	public static void main(String[] args) {

		A a = new A();
		B b = new B(a);
		new Thread(a).start();
		new Thread(b).start();

	}
}

class A implements Runnable {

	private boolean loop = true;

	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	@Override
	public void run() {
		
		while (loop) {
			System.out.println(((int) (Math.random() * 100)) + 1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("a线程退出");
		
	}
}

class B implements Runnable {

	private A a;
	Scanner sc = new Scanner(System.in);

	public B(A a) {
		this.a = a;
	}

	@SuppressWarnings("all")
	@Override
	public void run() {
		
		while (true) {
			System.out.println("请输入Q表示退出");
			char key = sc.next().toUpperCase().charAt(0);
			if (key == 'Q') {
				a.setLoop(false);
				System.out.println("b线程退出");
				break;
			}
		}
		
	}
}