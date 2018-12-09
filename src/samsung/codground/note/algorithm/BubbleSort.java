package samsung.codground.note.algorithm;

import java.util.Scanner;

/**
 * 배열의 이전값과 이후값을 비교해서, 작은것은 왼쪽, 큰것은 오른쪽으로 교환해감
 * 그래서, 맨왼쪽부터 시작해서, 오른쪽으로 옮겨가며 정렬함
 * 
 * 결론적으로 오른쪽부터 정렬이 됨
 * 
 * 거품정렬의 시간복잡도는 고려해야 할 루프가 (정렬해야 할 원소의 개수 - 1) * (최대 교환 수)이므로 총 O ( N ^ 2 ) 가 됩니다.
 * 힙 정렬, 퀵 정렬과 같은 정렬보다 상당히 비효율적이므로 자주 쓰이지 않습니다.
 * 
 * 매 차례마다 남은 원소들을 모두 확인하기 때문에 시간 복잡도는 최악의 연산 횟수나 평균 연산 횟수나 O(N^2)입니다.
 * 
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class BubbleSort {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		int size = scanner.nextInt();
		
		//배열값 입력
		int[] d = new int[5005];
		for(int i = 0; i < size; i++){
			d[i] = scanner.nextInt();
		}
		
		//Method1: 왼쪽부터 시작하면서, 전/후 2개씩 비교. 값이 작으면 왼쪽, 크면 오른쪽
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size-i-1; j++){
				if(d[j] > d[j+1]){
					int temp = d[j];
					d[j] = d[j+1];
					d[j+1] = temp;
				}
			}			
		}
		
		//Method2: 끝에서부터 정렬해오는 것
		for(int i = size; i > 1; i--){
			for(int j = 0; j < size-1; j++){
				if(d[j] > d[j+1]){
					int temp = d[j];
					d[j] = d[j+1];
					d[j+1] = temp;
				}
			}			
		}
		
		for(int i = 0; i < size; i++){
			System.out.print(d[i] + " ");
		}
	}

}
