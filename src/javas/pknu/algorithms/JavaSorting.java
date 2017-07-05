package javas.pknu.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * https://www.youtube.com/watch?v=ESwVlixFtak&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l&index=18
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class JavaSorting {
	
	static int[] data = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
	static String[] fruits = new String[]{"Pineapple", "Apple", "Orange", "Banana"};
	
	public static void main(String args[]){
		Arrays.sort(data);
		int size = 5;
		Arrays.sort(data, 0, 5);
		
		Arrays.sort(fruits);
		
		ArrayList<String> fruits2 = new ArrayList<String>();
		fruits2.add("Pineapple");
		fruits2.add("Apple");
		fruits2.add("Orange");
		fruits2.add("Banana");
		
		Collections.sort(fruits2);	
		
		Fruit[] fruits3 = new Fruit[4];
		fruits3[0] = new Fruit("Pineapple", 70);
		fruits3[1] = new Fruit("Apple", 100);
		fruits3[2] = new Fruit("Orange", 80);
		fruits3[3] = new Fruit("Banana", 90);
		
		Arrays.sort(fruits3);					//Comparable 적용
		Arrays.sort(fruits3, Fruit.nameComp);	//Comparator 적용
		Arrays.sort(fruits3, Fruit.quantComp);	//Comparator 적용
		
		
		
	}
	
}

class Fruit implements Comparable<Fruit>{
	public String name;
	public int quantity;
	
	public Fruit(String n, int q){
		this.name = n;
		this.quantity = q;
	}
	
	@Override
	public int compareTo(Fruit o) {
//		return this.name.compareTo(o.name);
		return this.quantity - o.quantity;
	}
	
	public static Comparator<Fruit> nameComp = new Comparator<Fruit>(){
		@Override
		public int compare(Fruit o1, Fruit o2) {
			return o1.name.compareTo(o2.name);
		}			
	};
	public static Comparator<Fruit> quantComp = new Comparator<Fruit>(){
		@Override
		public int compare(Fruit o1, Fruit o2) {
			return o1.quantity - o2.quantity;
		}			
	};
}

