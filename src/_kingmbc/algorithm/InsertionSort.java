package _kingmbc.algorithm;
import java.util.Scanner;

class InsertionSort {

	static int input[];
	static int num = 7;
	
	//Practice
	public static void insertion_desc(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int compValue = arr[i];
			int compIdx = i - 1;
			
			while(compIdx >= 0 && compValue > arr[compIdx]) {
				arr[compIdx + 1] = arr[compIdx];
				compIdx--;
			}
			arr[compIdx + 1] = compValue;
		}
	}
	
	
	public static void insertion2_desc(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int standard = arr[i];  // 기준
			int aux = i - 1;   // 비교할 대상

			while (aux >= 0 && standard > arr[aux]) {
				arr[aux + 1] = arr[aux];   // 비교대상이 큰 경우 오른쪽으로 밀어냄
				aux--;
			}
			arr[aux + 1] = standard;  // 기준값 저장
		}
	}
	static void insertion3_desc()
	{
		for (int i = 1; i < num; i++)
		{
			int temp = input[i];
			int j = i - 1;

			//
			//while ((j >= 0) && (intput[i] > input[j]))
			while ((j >= 0) && (temp > input[j]))
			{
				input[j + 1] = input[j];
				j = j - 1;
			}
			input[j + 1] = temp;
		}
	}
	static void insertion3_asc()
	{
		for (int i = 1; i < num; i++)
		{
			int temp = input[i];
			int j = i - 1;

			//while ((j >= 0) && (input[i] < input[j]))
			while ((j >= 0) && (temp < input[j]))
			{
				input[j + 1] = input[j];
				j = j - 1;
			}
			input[j + 1] = temp;
		}
	}
	public static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}


	public static void main(String arg[]) throws Exception {
		int [] arr;
		
		arr = new int[]{10, 2, 6, 4, 3, 7, 5};
		insertion_desc(arr);
		System.out.print("[1]");
		printArr(arr);
		
		arr = new int[]{10, 2, 6, 4, 3, 7, 5};
		insertion2_desc(arr);
		System.out.print("[2]");
		printArr(arr);
		
		input = new int[]{10, 2, 6, 4, 3, 7, 5};
		insertion3_desc();
		System.out.print("[3]");
		printArr(input);

		input = new int[]{10, 2, 6, 4, 3, 7, 5};		
		insertion3_asc();
		System.out.print("[4]");
		printArr(input);

	}
}