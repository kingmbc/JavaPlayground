package javas;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class FindRectangle {
	public static void main(String args[]){
		FindRectangle fr = new FindRectangle();
//		Scanner scanner = new Scanner(System.in);
		int[][] v = new int[3][2];
		v[0][0]=1;		v[0][1]=4;
		v[1][0]=3;		v[1][1]=4;
		v[2][0]=3;		v[2][1]=10;
		fr.solution(v);
	}

	public int[] solution(int[][] v) {
		int[] answer = new int[2];        
		int[] x = new int[3];
		int[] y = new int[3];
		for(int i=0; i < v.length; i++){
			x[i]=v[i][0];
			y[i]=v[i][1];
		}
		
		answer[0] = findDupValue(x);
		answer[1] = findDupValue(y);

		return answer;
	}

	public int findDupValue(int[] values){
		HashSet<Integer> hs = new HashSet();
		int dupIdx = -1;
		ArrayList<Integer> dupValues = new ArrayList<>();
		for(int i=0; i < values.length; i++){
			if(!hs.add(values[i])) {
				dupValues.add(values[i]);
			}
		}
		
		for(int i = 0; i < dupValues.size(); i++){
			hs.remove(dupValues.get(i));
		}
		
		return (int)hs.toArray()[0];
	}
	public static Integer[] removeDuplicates(Integer[] arr) {
		Integer[] is = new HashSet<Integer>(Arrays.asList(arr)).toArray(new Integer[0]);
		return is;
	}
	
	
	public void testArrays(int[] arr){
		java.util.
		Arrays.sort(arr);
		Arrays.fill(arr, 1);
		Arrays.equals(arr, Arrays.copyOf(arr, arr.length));
	}
}