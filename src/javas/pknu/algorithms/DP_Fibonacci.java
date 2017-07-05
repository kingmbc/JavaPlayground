package javas.pknu.algorithms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 동적 프로그래밍 예제) 피보나치 수열
 * Top-Down: 재귀함수를 통해 구현되므로 함수 호출에 대한 오버헤드가 발생. Memoization 기법 사용
 *           큰 문제를 해결하기 위해 필요한 sub-problem만을 호출하므로 필요한 부분만 계산하게 되어 특정한 경우에는 Bottom-Up방식보다 빠르게 동작
 * Bottom-Up: 반복문을 통해 구현되므로 이러한 자원에 비교적 자유로워 시간 및 메모리의 최적화가 쉽습니다.
 *            큰 문제를 해결하기까지 어떠한 sub-problem이 요구되는지 알 수 없으므로 전체 문제를 계산하기 위해 모든 부분문제를 해결해야 합니다
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class DP_Fibonacci {
	int[] f_memo = new int[100];
	public DP_Fibonacci(){
		for(int i=0; i < 100; i++){
			f_memo[i] = -1;
		}		
	}

	public int fib_Traditional(int n){
		if(n==1 || n == 2){
			return 1;
		}
		else{
			return fib_Traditional(n-2) + fib_Traditional(n-1);
		}
	}
	
	public long fib_BottomUp(int n){
		ArrayList<Long> progression = new ArrayList<>();
		progression.add(1l);
		progression.add(1l);
		for(int i=2; i<n; i++){
			progression.add((Long)progression.get(i-2)+(Long)progression.get(i-1));
		}
		return (Long)progression.get(n-1);
	}
	
	public int fib_BottomUp2(int n){
		f_memo[1] = f_memo[2] = 1;
		for(int i = 3; i <= n; i++){
			f_memo[i] = f_memo[i-2] + f_memo[i-1];
		}
		return f_memo[n];			
	}
	
	public int fib_TopDown(int n){
		if(n == 1 || n == 2){
			return 1;
		}
		else if(f_memo[n] != -1){
			return f_memo[n];
		}else{
			f_memo[n] = fib_TopDown(n-2) + fib_TopDown(n-1);
			return f_memo[n];
		}
	}

	public static void main(String args[]){
		DP_Fibonacci f = new DP_Fibonacci();
		
		Scanner s = new Scanner(System.in);
		int d = s.nextInt();
		
		long start = System.currentTimeMillis();//수행시간을 알아보기위한 로직
		long n = f.fib_BottomUp(d);
		System.out.println(n+" is the "+d+"th fibonacci number");
		float performtime = (System.currentTimeMillis()-start)/1000F;//수행시간을 알아보기 위한 로직
		System.out.println("프로그램 동작 시간:"+performtime+"초");//수행시간을 알아보기 위한 로직
		long n2 = f.fib_BottomUp(d);
		System.out.println(n2);
		long n3 = f.fib_TopDown(d);
		System.out.println(n3);
		int n4 = f.fib_BottomUp2(d);
		System.out.println(n4);

	}

}


