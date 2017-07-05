package javas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * http://gorakgarak.tistory.com/850
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class BinarySearchSortComparator {
	public static void main(String args[]){
		ArrayList<Car> list = new ArrayList<>();
		list.add(new Car(1000, "hi"));
		list.add(new Car(1230, "hi"));
		list.add(new Car(123000, "hi"));
		list.add(new Car(111000, "hi"));
		list.add(new Car(500, "hi"));
		list.add(new Car(130, "hi"));
		
		Collections.sort(list);
		Collections.sort(list, new Comp());
		
		int index = Collections.binarySearch(list,  new Car(500, "hi"), new Comp());
		System.out.println(list.toString());
		System.out.println("index = "+index);
		System.out.println(list.get(index));
	}

}

class Comp implements Comparator<Car>{
	@Override
	public int compare(Car o1, Car o2) {
		return o1.price-o2.price;
	}
}
class Car implements Comparable{
	int price;
	String name;
	
	public Car (int price, String name){
		super();
		this.price = price;
		this.name = name;
	}
	
	public String toString(){
		return "Car [price=" + price+ ", name = " + name + "]\n";
	}

	@Override
	public int compareTo(Object o) {		
		return this.price - ((Car)o).price;
	}

}