package demo03.extend;

public class Computer {

	private String cpu;
	private int memory;
	private int disk;

	public Computer() {
		super();
	}

	public Computer(String cpu, int memory, int disk) {
		super();
		this.cpu = cpu;
		this.memory = memory;
		this.disk = disk;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getDisk() {
		return disk;
	}

	public void setDisk(int disk) {
		this.disk = disk;
	}

	public String getDetails() {
		return "cpu=" + cpu + ", memory=" + memory + ", disk=" + disk;
	}

}