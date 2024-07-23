package demo07.tankGame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {

	Vector<Shot> shots = new Vector<>();
	Shot shot = null;
	public static int enemyTankNums = 4;
	private Vector<EnemyTank> enemyTanks = new Vector<>();

	public EnemyTank(int x, int y) {
		super(x, y);
	}

	public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
		this.enemyTanks = enemyTanks;
	}

	/**
	 * 编写方法，判断当前的敌人坦克，是否和 enemyTanks 中2的 其他坦克发生了重叠 或者是碰撞
	 * 
	 * @return
	 */
	public boolean isTouchEnemyTank() {
		// 判断当前敌人坦克(this) 方向
		switch (this.getDirect()) {
		case 0: // 上
			// 让当前的this 敌人坦克 和 其他所有的敌人坦克比较
			for (int i = 0; i < enemyTanks.size(); i++) {
				// 从vector中取出一辆敌人的坦克
				EnemyTank enemyTank = enemyTanks.get(i);
				// 不和自己比较
				if (this != enemyTank) {
					/*
					 * 1.如果敌人坦克是上/下方向 x的范围是什么【enemyTank.getX() ,enemyTank.getX() + 40】
					 * y的范围是什么【enemyTank.getY() ,enemyTank.getY() + 60】
					 */
					if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
						// 2.当前坦克的左上角坐标【this.getX(),this.getY()】
						if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
								&& this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
							return true;
						}
						// 3.当前坦克的右上角坐标【this.getX() + 40,this.getY()】
						if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 60
								&& this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
					}
					/*
					 * 1.如果敌人坦克是左/右方向 x的范围是什么【enemyTank.getX() ,enemyTank.getX() + 60】
					 * y的范围是什么【enemyTank.getY() ,enemyTank.getY() + 40】
					 */
					// 如果敌人坦克是左/右方向
					if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
						// 2.当前坦克的左上角坐标【this.getX(),this.getY()】
						if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
								&& this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
						// 3.当前坦克的右上角坐标【this.getX() + 40,this.getY()】
						if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 60
								&& this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
					}
				}
			}
			break;
		case 1: // 右
			// 让当前的this 敌人坦克 和 其他所有的敌人坦克比较
			for (int i = 0; i < enemyTanks.size(); i++) {
				// 从vector中取出一辆敌人的坦克
				EnemyTank enemyTank = enemyTanks.get(i);
				// 不和自己比较
				if (this != enemyTank) {
					/*
					 * 1.如果敌人坦克是上/下方向 x的范围是什么【enemyTank.getX() ,enemyTank.getX() + 40】
					 * y的范围是什么【enemyTank.getY(),enemyTank.getY() + 40】
					 */
					if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
						// 2.当前坦克的右上角坐标【this.getX() + 60,this.getY()】
						if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 40
								&& this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
							return true;
						}
						// 3.当前坦克的右下角坐标【this.getX() + 60,this.getY() + 40】
						if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 40
								&& this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 60) {
							return true;
						}
					}
					/*
					 * 1.如果敌人坦克是左/右方向 x的范围是什么【enemyTank.getX(),enemyTank.getX() + 60】
					 * y的范围是什么【enemyTank.getY(),enemyTank.getX() + 40】
					 */
					// 如果敌人坦克是左/右方向
					if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
						// 2.当前坦克的右上角坐标【this.getX() + 60,this.getY()】
						if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 60
								&& this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
						// 3.当前坦克的右下角坐标【this.getX() + 60,this.getY() + 40】
						if (this.getX() + 60 >= enemyTank.getX() && this.getX() + 60 <= enemyTank.getX() + 60
								&& this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 40) {
							return true;
						}
					}
				}
			}
			break;
		case 2: // 下
			// 让当前的this 敌人坦克 和 其他所有的敌人坦克比较
			for (int i = 0; i < enemyTanks.size(); i++) {
				// 从vector中取出一辆敌人的坦克
				EnemyTank enemyTank = enemyTanks.get(i);
				// 不和自己比较
				if (this != enemyTank) {
					/*
					 * 1.如果敌人坦克是上/下方向 x的范围是什么【enemyTank.getX() ,enemyTank.getX() + 40】
					 * y的范围是什么【enemyTank.getY(),enemyTank.getY() + 60】
					 */
					if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
						// 2.当前坦克的左下角坐标【this.getX(),this.getY() + 60】
						if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
								&& this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 60) {
							return true;
						}
						// 3.当前坦克的右下角坐标【this.getX() + 40,this.getY() + 60】
						if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 40
								&& this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 60) {
							return true;
						}
					}
					/*
					 * 1.如果敌人坦克是左/右方向 x的范围是什么【enemyTank.getX(),enemyTank.getX() + 60】
					 * y的范围是什么【enemyTank.getY(),enemyTank.getX() + 40】
					 */
					// 如果敌人坦克是左/右方向
					if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
						// 2.当前坦克的左下角坐标【this.getX(),this.getY() + 60】
						if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
								&& this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 40) {
							return true;
						}
						// 3.当前坦克的右下角坐标【this.getX() + 40,this.getY() + 60】
						if (this.getX() + 40 >= enemyTank.getX() && this.getX() + 40 <= enemyTank.getX() + 60
								&& this.getY() + 60 >= enemyTank.getY() && this.getY() + 60 <= enemyTank.getY() + 40) {
							return true;
						}
					}
				}
			}
			break;
		case 3: // 左
			// 让当前的this 敌人坦克 和 其他所有的敌人坦克比较
			for (int i = 0; i < enemyTanks.size(); i++) {
				// 从vector中取出一辆敌人的坦克
				EnemyTank enemyTank = enemyTanks.get(i);
				// 不和自己比较
				if (this != enemyTank) {
					/*
					 * 1.如果敌人坦克是上/下方向 x的范围是什么【enemyTank.getX() ,enemyTank.getX() + 40】
					 * y的范围是什么【enemyTank.getY(),enemyTank.getY() + 60】
					 */
					if (enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2) {
						// 2.当前坦克的左上角坐标【this.getX(),this.getY()】
						if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
								&& this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 60) {
							return true;
						}
						// 3.当前坦克的左下角坐标【this.getX(),this.getY() + 40】
						if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 40
								&& this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 60) {
							return true;
						}
					}
					/*
					 * 1.如果敌人坦克是左/右方向 x的范围是什么【enemyTank.getX(),enemyTank.getX() + 60】
					 * y的范围是什么【enemyTank.getY(),enemyTank.getX() + 40】
					 */
					// 如果敌人坦克是左/右方向
					if (enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3) {
						// 2.当前坦克的左上角坐标【this.getX(),this.getY()】
						if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
								&& this.getY() >= enemyTank.getY() && this.getY() <= enemyTank.getY() + 40) {
							return true;
						}
						// 3.当前坦克的左下角坐标【this.getX(),this.getY() + 40】
						if (this.getX() >= enemyTank.getX() && this.getX() <= enemyTank.getX() + 60
								&& this.getY() + 40 >= enemyTank.getY() && this.getY() + 40 <= enemyTank.getY() + 40) {
							return true;
						}
					}
				}
			}
			break;
		}
		return false;
	}

	@Override
	public void run() {

		while (true) {

			if (isLive() && shots.size() < 1) {
				switch (getDirect()) {
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
					if (getY() > 0 && !isTouchEnemyTank()) {
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
					if (getX() + 60 < 1000 && !isTouchEnemyTank()) {
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
					if (getY() + 60 < 750 && !isTouchEnemyTank()) {
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
					if (getX() > 0 && !isTouchEnemyTank()) {
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

			if (!isLive()) {
				break;
			}

		}
	}

}
