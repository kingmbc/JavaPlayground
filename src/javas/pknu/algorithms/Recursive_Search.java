package javas.pknu.algorithms;

/**
 * https://www.youtube.com/watch?v=Vwfo_hrxuzg&index=3&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class Recursive_Search {

	public static int search(int[] data, int n, int target){
		for(int i = 0; i < n; i++){
			if(data[i] == target)
				return i;
		}
		return -1;
	}
	
	public static int search_recursive(int[] data, int begin, int end, int target){
		if(begin > end)
			return -1;
		
		else if(target == data[begin])
			return begin;
		else
			return search_recursive(data, begin+1, end, target);
	}
	
	public static int search_rec_2(int[] data, int begin, int end, int target){
		if(begin > end)
			return -1;
		else{
			int middle = (begin + end) / 2;
			if(target == data[middle])
				return middle;
			else{
				int idx = search_rec_2(data, begin, middle-1, target);
				if(idx != -1)
					return idx;
				else
					return search_rec_2(data, middle, end, target);
					
			}
		}
	}
	
	public static int findMax(int[] data, int begin, int end){
		if(begin == end)
			return data[begin];
		else
			return Math.max(data[begin], findMax(data, begin+1, end));
	}
	
	public static int findMax_middle(int[] data, int begin, int end){
		if(begin == end)
			return data[begin];
		else{
			int middle = (begin + end) / 2;
			int max1 = findMax_middle(data, begin, middle);
			int max2 = findMax_middle(data, middle+1, end);
			return Math.max(max1, max2);
		}
	}
	
	public static int binarySearch(String[] items, String target, int begin, int end){
		if(begin > end)
			return -1;
		else{
			int middle = (begin + end) / 2;
			int compResult = target.compareTo(items[middle]);
			if(compResult == 0)
				return middle;
			else if(compResult < 0)
				return binarySearch(items, target, begin, middle-1);
			else
				return binarySearch(items, target, middle+1, end);
		}
	}
	
	public static void main(String args[]){
		int[] data = new int[]{1, 2, 3, 4, 5};
		
		System.out.println(search(data, data.length, 3));
		System.out.println(search_recursive(data, 0, data.length, 3));
	}
}
