package demo06.collectionClass;

import java.util.LinkedList;

@SuppressWarnings("all")
public class LinkedList01 {
	public static void main(String[] args) {

		Node jack = new Node("jack");
		Node tom = new Node("tom");
		Node hsp = new Node("hsp");

		// 连接三个结点，形成双向链表
		jack.next = tom;
		tom.next = hsp;

		hsp.pre = tom;
		tom.pre = jack;

		// 确定头和尾
		Node first = jack;
		Node last = hsp;

		System.out.println("头 -> 尾遍历");
		while (true) {
			if (first == null) {
				break;
			}
			System.out.println(first);
			first = first.next;
		}

		System.out.println("\n" + "尾 -> 头遍历");
		while (true) {
			if (last == null) {
				break;
			}
			System.out.println(last);
			last = last.pre;
		}

		System.out.println("\n" + "在tom和hsp之间添加一个smith");
		Node smith = new Node("smith");
		smith.next = hsp;
		smith.pre = tom;
		tom.next = smith;
		hsp.pre = smith;
		first = jack;
		last = hsp;
		System.out.println("新的linkedList");
		while (true) {
			if (first == null) {
				break;
			}
			System.out.println(first);
			first = first.next;
		}

	}
}

class Node {

	public Object item;
	public Node next;
	public Node pre;

	public Node(Object name) {
		this.item = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "node name = " + item;
	}

}