package pknu.algorithms;

/**
 * 동적 프로그래밍 예제) 이항계수(Binomial Coefficient)
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class DP_BinomialCoefficient {
	public static final int MAX_N = 100;
	public static final int MAX_K = 100;
	
	int[][] bino_memo = new int[MAX_N][MAX_K];
	public DP_BinomialCoefficient(){
		for(int i =0; i < MAX_N; i++){
			for(int j =0; j < MAX_K; j++){
				bino_memo[i][j] = -1;
			}
		}
	}
	public int binomial_Traditional(int n, int k){
		if(n == k || k == 0)
			return 1;
		else
			return binomial_Traditional(n-1, k) + binomial_Traditional(n-1, k-1);
	}
	
	/**
	 * Memoization은 TOP-DOWN 방식, 실제로 필요한 sub-problem만을 푼다.
	 * (Recursive
	 * @param n
	 * @param k
	 * @return
	 */
	public int binomial_TopDown(int n, int k){
		if(n == k || k == 0)
			return 1;
		else if(bino_memo[n][k] != -1){
			return bino_memo[n][k];
		}
		else{
			bino_memo[n][k] = binomial_TopDown(n-1, k) + binomial_TopDown(n-1, k-1);
			return bino_memo[n][k];
		}
	}
	
	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public int binomial_BottomUp(int n, int k){
		for(int i = 0; i<= n; i++){
			for(int j = 0; j <= i && j <= k; j++){
				if(i == j || j == 0)
					bino_memo[i][j] = 1;
				else
					bino_memo[i][j] = bino_memo[i-1][j] + bino_memo[i-1][j-1]; 
			}
		}
		
		return bino_memo[n][k];
	}
	
	public static void main(String args[]){
		DP_BinomialCoefficient bc = new DP_BinomialCoefficient();
		System.out.println(bc.binomial_TopDown(98, 50));
		System.out.println(bc.binomial_BottomUp(98, 50));
//		System.out.println(bc.binomial(100, 50));
	}
}
