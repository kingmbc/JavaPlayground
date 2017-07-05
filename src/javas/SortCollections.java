package javas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class SortCollections {
	public static void main(String args[]){
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(9);
		arrayList.add(2);
		arrayList.add(4);
		arrayList.add(1);
		arrayList.add(6);		
		arrayList.add(8);
		
		int[] arr = {9, 2, 4, 1, 6, 8};
		
		System.out.println(arrayList);
		Collections.sort(arrayList, new Descending ());
		System.out.println(arrayList);
		Collections.sort(arrayList, new Ascending ());
		System.out.println(arrayList);		
		
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
}

class Descending implements Comparator<Integer>{
	public int compare(Integer o1, Integer o2){
		return o1.compareTo(o2);
	}
}
class Ascending implements Comparator<Integer>{
	public int compare(Integer o1, Integer o2){
		return o2.compareTo(o1);
	}
}