package codground.note.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.codeground.org/common/popCodegroundNote#
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class MainGraph {
    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
    	int n = scanner.nextInt();
    	
    	int[][] adj_matrix = new int[n+1][n+1];
    	ArrayList<Integer>[] adj_list = new ArrayList[n+1];
    	for (int i=1; i <= n; i++){
    		adj_list[i] = new ArrayList<>();
    	}
    	
    	//입력으로부터 adj_matrix를 입력하고,
    	//만약 adj_matrix값이 1이면, 해당 adj_list[i]에 값을 넣어줌
    	for(int i=1; i <= n; i++){
    		for(int j=1; j <= n; j++){
    			adj_matrix[i][j] = scanner.nextInt();
    			if(adj_matrix[i][j] == 1){
    				adj_list[i].add(j);
    			}
    		}
    	}
    	
    	//Print
    	for (int i = 1; i <= n; i++){
    		System.out.print(i + ":");
    		for(int j=0; j < adj_list[i].size(); j++){
    			System.out.print(adj_list[i].get(j) + " ");
    		}
    		System.out.println();
    	}
    }
}
	