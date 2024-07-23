package demo07.tankGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JFrame;

@SuppressWarnings("all")
public class TankGame extends JFrame {
	MyPanel mp = null;

	public static void main(String[] args) {
		new TankGame();
	}

	public TankGame() {
		
		System.out.println("请输入选择： 1 表示新游戏，2是继续上局");
		Scanner scanner = new Scanner(System.in);
		this.mp = new MyPanel(scanner.next());
		scanner.close();
		
		// 将panel放入到thread中
		new Thread(mp).start();
		// 设置绑定监听器
		this.addKeyListener(mp);
		this.add(mp);

		Thread thread = new Thread(mp);
		this.add(mp);
		thread.start();
		this.setSize(1300, 750);
		this.addKeyListener(mp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				Recorder.keepRecord();
				System.exit(0);
			}

		});

	}
}
