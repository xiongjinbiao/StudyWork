package demo07.tankGame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {

	Vector<Shot> shots = new Vector<>();
	boolean isLive = true;
	Shot shot = null;
	public static int enemyTankNums = 4;

	public EnemyTank(int x, int y) {
		super(x, y);
	}

	@Override
	public void run() {

		while (true) {
			
			if(isLive && shots.size() < 1) {
				switch(getDirect()) {
				case 0:
					shot = new Shot(getX() + 20, getY(), 0);
					break;
				case 1:
					shot = new Shot(getX() + 60, getY() + 20, 1);
					break;
				case 2:
					shot = new Shot(getX() + 20, getY() + 60, 2);
					break;
				case 3:
					shot = new Shot(getX(), getY() + 20, 3);
					break;
				}
				shots.add(shot);
				new Thread(shot).start();
				}
			
			
			switch (getDirect()) {
			case 0:
				for (int i = 0; i < 30; i++) {
					if(getY() > 0) {
						moveUp();
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			case 1:
				for (int i = 0; i < 30; i++) {
					if(getX() + 60 < 1000) {
						moveRight();
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			case 2:
				for (int i = 0; i < 30; i++) {
					if(getY() + 60 < 750) {
						moveDown();
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			case 3:
				for (int i = 0; i < 30; i++) {
					if(getX() > 0) {
						moveLeft();
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			}

			setDirect((int) (Math.random() * 4));

			if (!isLive) {
				break;
			}

		}
	}

}
