package demo07.threadUse;

public class CpuNum {
	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		
		// 获取当前电脑的cpu数量
		int cpuNums = runtime.availableProcessors();

		System.out.println("当前可用线程数 " + cpuNums);
		
	}
}
