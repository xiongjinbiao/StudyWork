package demo06.collectionClass;

public class HashSetStructure {
	@SuppressWarnings("all")
	public static void main(String[] args) {

		// Node[] 数组也称为表
		Node01[] table = new Node01[16];
		Node01 john = new Node01("john",null);
		table[2] = john ;
		Node01 jack = new Node01("jack",null);
		john.next = jack;
		Node01 rose = new Node01("rose",null);
		jack.next = rose;

		
	}
}


class Node01 {

	public Object item;
	public Node01 next;

	public Node01(Object item, Node01 next) {
		super();
		this.item = item;
		this.next = next;
	}
	

}