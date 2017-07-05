package codground.note.algorithm;

import java.util.Scanner;

/**
 * 배열 0번부터 시작.
 * 1에서는 0과 1을 비교해서, 작은숫자를 왼쪽으로 옮김
 * 2에서는 0~2를 비교해서, 작은 숫자를 왼쪽으로 옮김
 * 이렇게 오른쪽으로 가면서, 작은 숫자를 왼쪽으로 옮겨가며 최종 정렬 
 * 
 * 결론적으로, 왼쪽부터 정렬이 됨
 * 
 * 시간복잡도는 각 원소에 대해 적당한 위치를 찾아주어야 하므로 총 원소의 개수 O( N ), 순차적으로 삽입 위치를 찾는데 O( N )이 들므로
 * O(N ^ 2)으로 힙정렬이나 합병정렬에 비해 비효율적(O(N log N))으로 잘 쓰이지 않습니다.
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class InsertionSort {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int[] d = new int[5005];
		
		//입력받은 배열 저장
		for(int i = 0; i < n; i++)
			d[i] = scanner.nextInt();
		
		//배열의 왼쪽부터 시작..
		for(int i = 0; i < n; i++){
			int temp = d[i];
			
			int j = i-1;		
			for(;j >=0; j--){
				if(temp > d[j])
					break;
				d[j+1] = d[j];
			}
			d[j+1] = temp;
		}
		
		
		for (int i = 0; i < n; i++)
            System.out.print(d[i] + " ");
		
	}
}
