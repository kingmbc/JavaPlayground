package pknu.algorithms;

/**
 * https://www.youtube.com/watch?v=xKGbWC-DPT4&index=6&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class Recursive_NQueens {
	public static int N = 8;
	static int[] cols = new int[N+1];
	public static boolean queens(int level){
		if(!promising(level))
			return false;
		else if(level == N){
			for(int i =1; i <= N; i++){
				System.out.println("(" + i + ", " + cols[i] + ")");
			}
			return true;
		}
		for(int i = 1; i <= N; i++){
			cols[level+1] = i;
			if(queens(level+1))
				return true;
		}
		return false;
	}
	
	private static boolean promising(int level) {
		for(int i = 1; i < level; i++){
			if(cols[i] == cols[level])
				return false;
			else if((level-i) == Math.abs(cols[i] - cols[level]))
				return false;
		}
		return true;
	}

	public static void main(String args[]){
		queens(0);
	}

}
