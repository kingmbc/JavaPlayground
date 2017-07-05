package javas.pknu.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * https://www.youtube.com/watch?v=hq4dpyuX4Uw&index=10&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l
 * http://www.algolist.net/Algorithms/Sorting/Quicksort
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class QuickSort {

	static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	static void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
	
	/**
	 * Version 2
	 * @param A
	 * @param l
	 * @param r
	 */
	public static void sort(int[] A, int l, int r){
		int left = l, right = r;
		int pivot = A[(l+r) / 2];
		
		do{
			while(A[left] < pivot) left++;
			while(A[right] > pivot) right--;
			
			if(left <= right){
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
				
				left++;
				right--;
			}		
		}while(left <= right);
		
		if(l < right) sort(A, l, right);
		if(r > left) sort(A, left, r);
	}
	
	static int[] data = new int[]{31, 8, 48, 73, 11, 3, 20, 29, 65, 15};
	public static void main(String args[]){
//		partition2(DATA, 0, DATA.length);
//		sort(DATA, 0, DATA.length-1);
		quickSort(data, 0, data.length-1);
		
		System.out.println(Arrays.toString(data));
	}
}
