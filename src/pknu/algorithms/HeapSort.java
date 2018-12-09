package pknu.algorithms;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=ihyg2OR8IR0&feature=youtu.be&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l&t=958 
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 * https://stackoverflow.com/questions/11528591/creating-a-max-heap-using-java 참조함
 * 
 * 유투브 동영상에서는 1부터 배열 idx가 시작하지만, 코드상에서는 0부터 시작한다.
 * 따라서 leftChild = 2*i + 1, rightChild = 2*i + 2가 된다.
 */
public class HeapSort {
	public static boolean isNull(int[] A, int idx){
		if(heapSize < idx)
			return true;
		return false;
	}
	
	public static int bigChild(int[] A, int i){
		if(isNull(A, 2*i + 1))
			return -1;
		int leftChild = -1, rightChild = -1;
		if(!isNull(A, 2*i + 1))
			leftChild = A[2*i + 1];
		if(!isNull(A, 2*i + 2))
			rightChild = A[2*i + 2];
		
		return leftChild > rightChild ? 2*i+1 : 2*i+2;
		
	}
	public static void maxheapify_recursive(int[] A, int i){
		if(isNull(A, 2*i + 1))
			return;
		
		int idxOfBig = bigChild(A, i);
		if(A[i] >= A[idxOfBig])
			return;
		swap(A, i, idxOfBig);
		maxheapify_recursive(A, idxOfBig);		
	}
	
	public static void maxheapify_iter(int[] A, int i){
		while(!isNull(A, 2*i + 1)){
			int idxOfBig = bigChild(A, i);
			if(A[i] >= A[idxOfBig])
				return;
			swap(A, i, idxOfBig);
			i = idxOfBig;			
		}
	}
	
	public static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static void buildMaxHeap(int[] A){
		for(int i = heapSize / 2; i >= 0; i--){
//			maxheapify_recursive(A, i);
			maxheapify_iter(A, i);
		}
	}
	public static int heapExtractMax(int[] A){
		if(heapSize < 1){
			System.out.println("heap underflow");
			return -1;
		}
		buildMaxHeap(A);
		int max = A[0];
		A[0] = A[heapSize];
		heapSize--;
		maxheapify_iter(A, 0);
		
		return max;		
	}
	
//	public static maxHeapInsert(int[] A, int key){
//		heapSize++;
//		A[heapSize] = key;
//		i = heapSize;
//		
//		while(i > 0 && A[getParent(i)]){
//			
//		}
//	}
	
	/**
	 * 1. 먼저 배열을 가지고 Heap을 만든다.
	 * 2. 그리고 HeapSize만큼 돌면서, 배열의 가장 Top과 Last를 Swap하고, 
	 * 3. Last를 제외한 나머지 Heap에 대해 Root를 기준으로 maxheapify 연산을 수행한다. 
	 * @param A
	 */
	public static void heapSort(int[] A){
		buildMaxHeap(A);
		for(int i = heapSize; i >= 1; i--){
			swap(A, 0, i);
			heapSize--;
			maxheapify_iter(A, 0);
		}
	}
	
	static int[] orgData = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
	static int heapSize = orgData.length-1;
	public static void main(String args[]){
		System.out.println(heapExtractMax(orgData));
		
		buildMaxHeap(orgData);
		System.out.println(Arrays.toString(orgData));
		
		heapSort(orgData);
		System.out.println(Arrays.toString(orgData));
	}
}
