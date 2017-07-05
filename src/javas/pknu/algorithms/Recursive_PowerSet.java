package javas.pknu.algorithms;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=nkeMRRIVW9s&index=7&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class Recursive_PowerSet {
	static char[] data = new char[]{'a', 'b', 'c'};
	static int N = data.length;
	static boolean[] include = new boolean[N];	//data배열에서 각 data를 포함시킬지 말지 여부를 결정
	static Stack<String> callStack = new Stack<String>();
	
	public static void powerSet(int k){
//		System.out.println("K = " + k);
		if(k == N){
			for(int i = 0; i < N; i++){
				if(include[i]){
					System.out.print(data[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		include[k] = true;
		powerSet(k+1);
//		callStack.add("include[k]=true || powerSet(k+1=(" + (k+1) + ")");
		include[k] = false;
		powerSet(k+1);
//		callStack.add("include[k]=false || powerSet(k+1=(" + (k+1) + ")");
		
		
	}
	public static void main(String args[]){
		powerSet(0);
	}
}
