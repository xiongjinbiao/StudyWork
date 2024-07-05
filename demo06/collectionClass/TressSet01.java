package demo06.collectionClass;

import java.util.Comparator;
import java.util.TreeSet;

public class TressSet01 {
	public static void main(String[] args) {

		TreeSet<String> treeSet = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// 按照字符串大小比较方法，从小到大排序
				return s1.compareTo(s2);
			}

		});

		treeSet.add("jack");
		treeSet.add("tom");
		treeSet.add("xjb");
		treeSet.add("mike");
		
		for (String s : treeSet) {
			System.out.println(s);
		}


	}
}
