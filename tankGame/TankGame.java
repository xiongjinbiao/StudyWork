package demo07.tankGame;

import javax.swing.JFrame;

@SuppressWarnings("all")
public class TankGame extends JFrame {
	MyPanel mp = null;

	public static void main(String[] args) {
		new TankGame();
	}

	public TankGame() {
		mp = new MyPanel();
		Thread thread = new Thread(mp);
		this.add(mp);
		thread.start();
		this.setSize(1000, 750);
		this.addKeyListener(mp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
