package others;

import java.util.ArrayList;
import java.util.List;

import stdlib.Stopwatch;

class Item implements Cloneable {
	private int a;
	private int b;
	private int c;

	public Item() {
		this.a = 100;
		this.b = 120;
		this.c = 150;
	}

	@Override
	public Item clone() {
		Item item = null;
		try {
			item = (Item) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return item;
	}

}

public class Test1 {

	// public static void main(String[] args) throws InterruptedException {
	// Stopwatch stopwatch = new Stopwatch();
	// List<Item> list = new ArrayList<Item>();
	//
	//
	// for(int i = 0 ;i<1000000;i++){
	//
	// list.add(new Item());
	// }
	//
	// System.out.println(stopwatch.elapsedTime());
	// }

	public static void main(String[] args) throws InterruptedException {
		Stopwatch stopwatch = new Stopwatch();
		List<Item> list = new ArrayList<Item>();

		// Item item = new Item();
		// for(int i = 0 ;i<100000;i++){
		// list.add(item.clone());
		// }
		// System.out.println(stopwatch.elapsedTime());
		String str = "12abÁõ²©Óî";
		String test = "Á÷";

		System.out.println(test.getBytes().length);

		char[] charArray = str.toCharArray();
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < charArray.length; i++) {
			sbf.append(new Character(charArray[i]));
			sbf.append(" ");
		}
		System.out.println(sbf.toString());

		System.out.println(Integer.MAX_VALUE);

		int x = -1;
		x = x++;
		System.out.println(x);
		assert(x>2);
		
	}

}
