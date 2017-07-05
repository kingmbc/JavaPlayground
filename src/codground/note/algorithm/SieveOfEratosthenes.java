package codground.note.algorithm;

import java.util.Scanner;

/**
 * 에라토스테네스의 체는 특정 범위의 수들이 소수(Prime)인지 아닌지를 판별하는 알고리즘입니다. 에라토스테네스의 체의 원리는 간단합니다.
 * 1~50까지 모든 소수를 구하고자 한다면, 먼저 아래와 같은 배열이 필요합니다. 이 배열은 해당 인덱스의 숫자가 소수인지 아닌지를 나타냅니다.
 * 
 * 최적화 포인트
 *  - MAX까지 다 찾는 것이 아니라, sqrt(MAX)를 탐색해도 정확성은 유지하면서 빨라질 수 있는데,
 *  - 어떤 수의 제곱이 되면 이미 소수가 될 수 없고, sqrt(MAX)만 하면 약수를 통해 반값으로 전체 search space를 줄일 수 있다.
 *  - 따라서 MAX까지 하나하나 배수를 따져가지 않고, sqrt(MAX)까지만해도 같은 값을 구할 수 있다. 
 *  
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class SieveOfEratosthenes {

	private final static int MAX = 1000000;
	static boolean isPrime[] = new boolean[MAX+1];
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		
		for(int i = 2; i <= MAX; i++){
			isPrime[i] = true;			
		}
		
		//먼저 소수인지 아닌지 MAX값 이하의 숫자에 대해 판단
		int sqrtN = (int) Math.sqrt(MAX);
		for(int i = 2; i <= sqrtN; i++){
			if(!isPrime[i]) continue;
			for(int j = 2*i; j <= MAX; j += i){
				isPrime[j] = false;
			}
		}
		
		//그다음 Testcase별로 테스트
		int testcase = scanner.nextInt();
		int T = 0, N = 0;
		
		while(testcase != T){
			T++;
			N = scanner.nextInt();
			if(isPrime[N]){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
	
	
}
