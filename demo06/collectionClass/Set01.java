package demo06.collectionClass;

import java.util.HashSet;
import java.util.Iterator;

@SuppressWarnings("unused")
public class Set01 {
	public static void main(String[] args) {

		// 自动去重，无序，因此无法使用for循环遍历
		HashSet<Object> set = new HashSet<Object>();
		set.add("jack");
		set.add("mike");
		set.add("smith");
		set.add("jhon");
		set.add("jack");

		System.out.println(set);

		Iterator<Object> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println();
		for (Object object : set) {
			System.out.print(object + " ");
		}

	}
}
