package javas.pknu.algorithms;

import java.util.Arrays;

/**
 * [알고리즘] 제4강 합병정렬(merge sort)
 * https://www.youtube.com/watch?v=2YvFRAC8UTM&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l&index=9
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class MergeSort {
	public static void mergeSort(int[] A, int p, int r){ //A[p..r]
		if(p < r){
			int q = (p + r) / 2;
			
			mergeSort(A, p, q);
			mergeSort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	
	public static void merge(int[] A, int p, int q, int r){
		int[] result = new int[A.length];
		int i = p, j = q+1, k = p;
		while(i <= q && j <= r){
			if(A[i] <= A[j]){
				result[k++] = A[i++];
			}
			else if(A[i] > A[j]){
				result[k++] = A[j++];
			}				
		}
		
		while(i <= q)
			result[k++] = A[i++];
		while(j <= r)
			result[k++] = A[j++];
		for(i = p; i <=r; i++){
			A[i] = result[i]; 
		}
	}
	
	static int[] data = new int[]{4, 2, 5, 3, 1};
	public static void main(String args[]){
		mergeSort(data, 0, 4);
		
		System.out.println(Arrays.toString(data));
	}
}
