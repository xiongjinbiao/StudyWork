package demo06.collectionClass;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap01 {
	public static void main(String[] args) {

		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2) {
				// 按照key大小比较方法，从小到大排序
				return n1 - n2;
			}

		});

		treeMap.put(4, "asda");
		treeMap.put(6, "sjksl");
		treeMap.put(1, "asdasd");
		treeMap.put(7, "asdasd");
		
		Set<Integer> keySet = treeMap.keySet();
		
		for (Integer i : keySet) {
			System.out.println(i + " -> " + treeMap.get(i));
		}
		
		System.out.println("根据entryset进行遍历");
		Set<Entry<Integer,String>> entrySet = treeMap.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			
			System.out.println(entry.getKey() + " -> " + entry.getValue());
			
		}

	}
}
