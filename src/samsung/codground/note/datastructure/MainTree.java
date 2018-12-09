package samsung.codground.note.datastructure;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * https://www.codeground.org/common/popCodegroundNote#
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class MainTree {
	static final int EMPTY = -1;
	static final int TREE_MAX_SIZE = 10000;
	static int child[][];
	static int root = 0, N, P;
	static void insert(int parent_idx, int child_idx){
		//
		if(parent_idx == -1)
			root = child_idx;
		else if(child[parent_idx][0] == EMPTY){
			child[parent_idx][0] = child_idx;
		}
		else if(child[parent_idx][1] == EMPTY){
			child[parent_idx][1] = child_idx;
		}
		else{
			//tree_node has left, right only
		}
	}
	
	//전위 순회 Pre-order Traversal
	static void pre_order(int cur){
		int left = child[cur][0];
		int right = child[cur][1];
		
		System.out.print(String.valueOf(cur) + ' ');
		if(left != EMPTY){
			pre_order(left);
		}
		if(right != EMPTY){
			pre_order(right);
		}
	}
	//중위 순회 In-order Traversal
	static void in_order(int cur){
		int left = child[cur][0];
		int right = child[cur][1];
		
		if(left != EMPTY){
			in_order(left);
		}
		System.out.print(String.valueOf(cur) + ' ');
		if(right != EMPTY){
			in_order(right);
		}
	}
	//후위 순회 Post-order Traversal
	static void post_order(int cur){
		int left = child[cur][0];
		int right = child[cur][1];
		
		if(left != EMPTY){
			post_order(left);
		}
		if(right != EMPTY){
			post_order(right);
		}
		System.out.print(String.valueOf(cur) + ' ');
	}
	
    public static void main(String args[]) {
    	//8, -1, 0, 0, 1, 1, 2, 2, 3
    	Scanner scanner = new Scanner(System.in);
    	
    	//Tree 생성 및 초기화
    	child = new int[TREE_MAX_SIZE][2];
    	for(int i = 0; i < TREE_MAX_SIZE; i++){
    		for(int j = 0; j < 2; j++){
    			child[i][j] = EMPTY;
    		}
    	}
    	N = scanner.nextInt();
    
    	//입력 값에 따라 부모/자식 값 입력
    	for(int child = 0; child < N; child++){
    		P = scanner.nextInt();
    		if(P == -1){
    			root = child;
    		}
    		else{
    			insert(P, child);
    		}
    	}
    	
    	pre_order(root);
    	System.out.println();
    	in_order(root);
    	System.out.println();
    	post_order(root);
    	System.out.println();
    }
}
	