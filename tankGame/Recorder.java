package demo07.tankGame;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Recorder {

	private static int allEnemyTankNum = 0;
	private static BufferedWriter bw = null;
	private static BufferedReader br = null;
	private static String recordFile = "/Users/user/Documents/record.txt";
	private static Vector<EnemyTank> enemyTanks = new Vector<>();
	private static Vector<Node> nodes = new Vector<>();

	public static Vector<Node> getNodesAndTanks() {
		try {
			br = new BufferedReader(new FileReader(recordFile));
			allEnemyTankNum = Integer.parseInt(br.readLine());
			String data = "";
			while ((data = br.readLine()) != null) {
				String[] split = data.split(" ");
				if (split.length == 3) {
					Node node = new Node(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
							Integer.parseInt(split[2]));
					nodes.add(node);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if (br != null) {
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nodes;
	}

	/**
	 * 当游戏退出时，我们将摧毁的敌方坦克信息 保存到 recordFile
	 */
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

	public static String getRecordFile() {
		return recordFile;
	}
	

}
