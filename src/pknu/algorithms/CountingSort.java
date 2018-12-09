package pknu.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * https://www.youtube.com/watch?v=XPzO3kG7kH8&feature=youtu.be&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l&t=59
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class CountingSort {

	static int MAX_RANGE = 8;
	static int[] DATA = new int[]{0, 2, 0, 3, 5, 7, 3};
	static int[] COUNT= new int[MAX_RANGE];
	static int[] AGG = new int[MAX_RANGE];
	static int[] RESULT = new int[DATA.length];
	
	public static void main(String args[]){
		//4. 이렇게 정렬하면 CoutingSort 종료
		countingSort(DATA);
	}
	
	public static void countingSort(int[] A){
		for(int i = 0; i < MAX_RANGE; i++){
			COUNT[i] = 0;
		}
		
		//1. 각 숫자별 갯수를 구한다(COUNT)	  COUNT[]
		for(int i = 0; i < A.length; i++){
			COUNT[A[i]]++;
		}
		
		System.out.println(Arrays.toString(COUNT));
		
		//2. 그리고 숫자별 갯수를 aggregation한다. AGG[]
		AGG[0] = COUNT[0];
		for(int i = 1; i <= A.length; i++){
			AGG[i] = AGG[i-1] + COUNT[i];
		}
		
		System.out.println(Arrays.toString(AGG));
		
		//3. 그리고 DATA[]의 값들을 끝에서부터 거꾸로 하나씩 가져와서, AGG[]가 가리키는 값에다가 집어넣고, AGG[]의 값은 1감소시킴
		for(int i = A.length-1; i > 0; i--){
			RESULT[AGG[A[i]]-1] = A[i];
			AGG[A[i]] = AGG[A[i]] - 1;
		}
		
		System.out.println(Arrays.toString(RESULT));
	}
}
