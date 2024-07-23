package demo07.tankGame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Recorder {

	private static int allEnemyTankNum = 0;
	private static BufferedWriter bw = null;
	private static String recordFile = "/Users/user/Documents/record.txt";
	private static Vector<EnemyTank> enemyTanks = new Vector<>();

	public static void keepRecord() {
		try {
			bw = new BufferedWriter(new FileWriter(recordFile));
			bw.write(allEnemyTankNum + "\r\n");
			for (EnemyTank enemyTank : enemyTanks) {
				if (enemyTank.isLive()) {
					String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect() + "\r\n";
					bw.write(record);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (bw != null) {
				bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void addAllEnemyTankNum() {
		Recorder.allEnemyTankNum++;
	}

	public static int getAllEnemyTankNum() {
		return allEnemyTankNum;
	}

	public static void setAllEnemyTankNum(int allEnemyTankNum) {
		Recorder.allEnemyTankNum = allEnemyTankNum;
	}

	public static Vector<EnemyTank> getEnemyTanks() {
		return enemyTanks;
	}

	public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
		Recorder.enemyTanks = enemyTanks;
	}

}
