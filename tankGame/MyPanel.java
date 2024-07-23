package demo07.tankGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JPanel;

@SuppressWarnings("all")
public class MyPanel extends JPanel implements KeyListener, Runnable {

	Hero hero = null;
	Vector<EnemyTank> enemyTanks = new Vector<>();

	Vector<Bomb> bombs = new Vector<>();
	Image image1 = null;
	Image image2 = null;
	Image image3 = null;
	Vector<Node> nodes = new Vector<>();

	public MyPanel(String type) {

		Recorder.setEnemyTanks(enemyTanks);

		hero = new Hero(600, 600);
		hero.setSpeed(4);

		File file = new File(Recorder.getRecordFile());
		if (!file.exists()) {
			type = "1";
			System.out.println("文件不存在，只能重新开始游戏");
		} else {
			nodes = Recorder.getNodesAndTanks();
		}

		switch (type) {
		case "1":
			for (int i = 0; i < EnemyTank.enemyTankNums; i++) {
				EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
				enemyTank.setEnemyTanks(enemyTanks);
				enemyTank.setDirect(2);
				new Thread(enemyTank).start();
				Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
				enemyTank.shots.add(shot);
				new Thread(shot).start();
				enemyTanks.add(enemyTank);
			}
			break;
		case "2":
			for (int i = 0; i < nodes.size(); i++) {
				Node node = nodes.get(i);
				EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
				enemyTank.setEnemyTanks(enemyTanks);
				enemyTank.setDirect(node.getDirect());
				new Thread(enemyTank).start();
				Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
				enemyTank.shots.add(shot);
				new Thread(shot).start();
				enemyTanks.add(enemyTank);
			}
			break;
		default:
			System.out.println("输入有误");
		}

		// 初始化图片
//		try {
//			image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/bomb_1.gif"));
//			image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/bomb_2.gif"));
//			image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("src/bomb_3.gif"));
//		} catch (NullPointerException e) {
//			e.printStackTrace();
//		}

	}

	public void showInfo(Graphics g) {

		g.setColor(Color.BLACK);
		Font font = new Font("宋体", Font.BOLD, 25);
		g.setFont(font);

		g.drawString("你累积击毁敌方坦克", 1020, 30);
		drawTank(1020, 60, g, 0, 0);
		g.setColor(Color.BLACK);
		g.drawString(Recorder.getAllEnemyTankNum() + "", 1080, 100);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 1000, 750);
		showInfo(g);
		// 画出自己的坦克
		drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);

		// 画出射击的子弹
		for (int i = 0; i < hero.shots.size(); i++) {
			Shot shot = hero.shots.get(i);
			if (shot != null && shot.isLive) {
				g.draw3DRect(shot.x, shot.y, 2, 2, false);
			} else {
				hero.shots.remove(shot);
			}
		}

		// 敌方坦克
		for (int i = 0; i < enemyTanks.size(); i++) {
			// 取出敌方坦克
			EnemyTank enemyTank = enemyTanks.get(i);

			if (enemyTank.isLive()) {
				drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
				// 取出子弹
				for (int j = 0; j < enemyTank.shots.size(); j++) {
					Shot shot = enemyTank.shots.get(j);
					if (shot.isLive) {
						g.draw3DRect(shot.x, shot.y, 2, 2, false);
					} else {
						enemyTank.shots.remove(shot);
					}
				}
			}

		}

		// 如果bombs 集合中有对象，就画出
		for (int i = 0; i < bombs.size(); i++) {
			Bomb bomb = bombs.get(i);
			if (bomb.life > 6) {
				g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
			} else if (bomb.life > 3) {
				g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
			} else {
				g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
			}
			bomb.lifeDown();
			if (bomb.life == 0) {
				bombs.remove(bomb);
			}
		}

	}

	/**
	 * 
	 * @param x      横坐标
	 * @param y      纵坐标
	 * @param g      Graphics
	 * @param direct 坦克朝向 0-up,1-right,2-down,3-left
	 * @param type   类型 0-己方 1-敌方
	 */
	public void drawTank(int x, int y, Graphics g, int direct, int type) {

		switch (type) {
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}

		switch (direct) {
		case 0:
			g.fill3DRect(x, y, 10, 60, false);
			g.fill3DRect(x + 30, y, 10, 60, false);
			g.fill3DRect(x + 10, y + 10, 20, 40, false);
			g.fillOval(x + 10, y + 20, 20, 20);
			g.drawLine(x + 20, y + 30, x + 20, y);
			break;
		case 1:
			g.fill3DRect(x, y, 60, 10, false);
			g.fill3DRect(x, y + 30, 60, 10, false);
			g.fill3DRect(x + 10, y + 10, 40, 20, false);
			g.fillOval(x + 20, y + 10, 20, 20);
			g.drawLine(x + 30, y + 20, x + 60, y + 20);
			break;
		case 2:
			g.fill3DRect(x, y, 10, 60, false);
			g.fill3DRect(x + 30, y, 10, 60, false);
			g.fill3DRect(x + 10, y + 10, 20, 40, false);
			g.fillOval(x + 10, y + 20, 20, 20);
			g.drawLine(x + 20, y + 30, x + 20, y + 60);
			break;
		case 3:
			g.fill3DRect(x, y, 60, 10, false);
			g.fill3DRect(x, y + 30, 60, 10, false);
			g.fill3DRect(x + 10, y + 10, 40, 20, false);
			g.fillOval(x + 20, y + 10, 20, 20);
			g.drawLine(x + 30, y + 20, x, y + 20);
			break;
		}

	}

	/**
	 * 
	 * @param s    子弹
	 * @param tank 敌方坦克
	 * @describe 当子弹打到坦克身上（即坐标系范围）时候，坦克爆照
	 */
	public void hitTank(Shot s, Tank enemyTank) {
		switch (enemyTank.getDirect()) {
		case 0:
		case 2:
			if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 && s.y > enemyTank.getY()
					&& s.y < enemyTank.getY() + 60) {
				s.isLive = false;
				enemyTank.setLive(false);
				enemyTanks.remove(enemyTank);
				if (enemyTank instanceof EnemyTank) {
					Recorder.addAllEnemyTankNum();
				}
				Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
				bombs.add(bomb);
			}
			break;
		case 1:
		case 3:
			if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 && s.y > enemyTank.getY()
					&& s.y < enemyTank.getY() + 40) {
				s.isLive = false;
				enemyTank.setLive(false);
				enemyTanks.remove(enemyTank);
				Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
				bombs.add(bomb);
			}
		}
	}

	/**
	 * 判断是否我方所有子弹中其中一颗击中了敌人坦克
	 */
	public void hitEnemy() {
		for (int i = 0; i < hero.shots.size(); i++) {
			Shot shot = hero.shots.get(i);
			if (shot != null && shot.isLive) {
				// 遍历敌人所有坦克
				for (int j = 0; j < enemyTanks.size(); j++) {
					EnemyTank enemyTank = enemyTanks.get(j);
					hitTank(hero.shot, enemyTank);
				}
			}
		}
	}

	/**
	 * 判断是否我方坦克是否被子弹击中
	 */
	public void hitHero() {
		if (enemyTanks.size() > 0) {
			// 遍历敌人所有坦克
			for (int j = 0; j < enemyTanks.size(); j++) {
				EnemyTank enemyTank = enemyTanks.get(j);
				Vector<Shot> shots = enemyTank.shots;
				if (shots.size() > 0) {
					for (int i = 0; i < shots.size(); i++) {
						Shot shot = shots.get(i);
						if (hero.isLive() && shot.isLive) {
							hitTank(shot, hero);
						}
					}
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

		// 控制坦克移动
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
			hero.setDirect(0);
			if (hero.getY() > 0) {
				hero.moveUp();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			hero.setDirect(1);
			if (hero.getX() + 60 < 1000) {
				hero.moveRight();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
			hero.setDirect(2);
			if (hero.getY() + 60 < 750) {
				hero.moveDown();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			hero.setDirect(3);
			if (hero.getX() > 0) {
				hero.moveLeft();
			}
		}

		// 控制子弹发射
		if (e.getKeyCode() == KeyEvent.VK_J) {
			hero.shotEnemyTank();
		}

		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

		while (true) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			hitEnemy();

			hitHero();

			this.repaint();

		}
	}

}
