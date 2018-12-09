package samsung.codground.note.algorithm;

import java.util.Scanner;

/**
 * Coin Change Problem
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class DP0 {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		int[] coin = new int[n];
		for(int i = 0; i < n; i++){
			coin[i] = scanner.nextInt();
		}
		
		int d[] = new int[k+1];
		for (int i = 1; i <= k; i++){
			d[i] = -1;
			for(int j = 0; j < n; j++){
				System.out.println("coin[j] = " + coin[j]);
				System.out.println("i = "+ i);
				System.out.println("j = "+ j);
//				System.out.println("d[i] = " + d[i]);
				if(coin[j] <= i){
					if(d[i - coin[j]] < 0)
						continue;
					if(d[i] < 0){
						System.out.println("d[i - coin[j]] = " + d[i - coin[j]]);
						d[i] = d[i - coin[j]] + 1;
					}
					else if(d[i - coin[j]] + 1 < d[i]){
						System.out.println("d[i - coin[j]] = " + d[i - coin[j]]);
						d[i] = d[i - coin[j]] + 1;
					}
						
				}
				System.out.println("--------------");
			}
			System.out.println("##########################################");
		}
		
		System.out.println(d[k]);
	}
}
