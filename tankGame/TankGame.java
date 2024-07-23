package demo07.tankGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
