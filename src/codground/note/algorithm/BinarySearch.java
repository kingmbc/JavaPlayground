package codground.note.algorithm;

import java.util.Scanner;

/**
 * 배열에서 맨왼쪽 인덱스과 맨 오른쪽 인덱스, 그리고 중간 인덱스값을 이용하여 찾고자 하는 값을 찾아 나가는 탐색법  
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class BinarySearch {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int d[] = new int[5005];
		for(int i = 0; i < n; i++){
			d[i] = scanner.nextInt();
		}
		
		//bubble sorting
		for(int i=0; i < n; i++)
			for(int j=0; j < n-i-1; j++)
				if(d[i] > d[i+1]){
					int temp = d[j];
					d[j] = d[j+1];
					d[j+1] = temp;
				}
	
		//binary serach for each query
		int query = scanner.nextInt();
		for(int i =0; i < query; i++){
			int x = scanner.nextInt();
			int l = 0, r = n-1;
			boolean answer = false;
			
			while(l <= r){
				int mid = (l + r) / 2;
				if(x == d[mid]){
					answer = true;
					break;
				}
				else if(x > d[mid])
					l = mid + 1;
				else 
					r = mid - 1;
				
			}
			if(answer == true) 
				System.out.println("exit");
			else
				System.out.println("not exist");
		}
		
		
	}
	
	
	
}
