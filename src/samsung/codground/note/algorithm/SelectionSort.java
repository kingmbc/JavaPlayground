package samsung.codground.note.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 배열에서 왼쪽부터 시작(0번)
 * 모든 값들 중에서 가장 작은 값을 0번에 넣고,
 * 그다음 배열값들 중에서 다시 가장 작은 값을 그다음 1번에 넣고..
 * 이렇게 0번에서 끝까지 돌아가면서 작은값을 찾음
 * 
 * 결론적으로, 왼쪽부터 정렬이됨
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class SelectionSort {
	static void selection_sort(int arr[], int size){
		for(int i = 0; i < size; i++){
			int minidx = i;
			for(int j = i+1; j < size; j++){
				if(arr[minidx] > arr[j]){
					minidx = j;
				}
			}

//			Collections.swap(new ArrayList<>(Arrays.asList(arr)), minidx, i);
			int temp = arr[minidx];
			arr[minidx] = arr[i];
			arr[i] = temp;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] arr = new int[5005];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
		Collections.sort(list);
		System.out.println(list);

		selection_sort(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(String.valueOf(arr[i]) + ' ');
		}
		System.out.println("");
	}

}
