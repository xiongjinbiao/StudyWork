package demo06.collectionClass;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionIterator {
	public static void main(String[] args) {

		ArrayList<Book> arrayList = new ArrayList<Book>();
		arrayList.add(new Book("sad","sad",12321));
		arrayList.add(new Book("asdas","dasd",11221));
		arrayList.add(new Book("vdf","vsf",2131));
		arrayList.add(new Book("vfv","mjyj",1232));

		Iterator<Book> iterator = arrayList.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		for (Book book : arrayList) {
			System.out.println(book);
		}
		
	}
}

class Book{
	
	private String name;
	private String author;
	private double price;
	
	
	
	public Book(String name, String author, double price) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
	
	
}