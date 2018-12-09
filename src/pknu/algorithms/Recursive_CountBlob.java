package pknu.algorithms;

/**
 * https://www.youtube.com/watch?v=HHJFlVT1tBw&index=5&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class Recursive_CountBlob {
	private static int N=8;
	private static int[][] grid = {
			{0, 0, 0, 0, 	0, 0, 0, 1},
			{0, 1, 1, 0, 	1, 1, 0, 1},
			{0, 0, 0, 1, 	0, 0, 0, 1},
			{0, 1, 0, 0, 	1, 1, 0, 0},
			{0, 1, 1, 1, 	0, 0, 1, 1},
			{0, 1, 0, 0, 	0, 1, 0, 1},
			{0, 0, 0, 1, 	0, 0, 0, 1},
			{0, 1, 1, 1, 	0, 1, 0, 0}			
	};
	
	private static final int PATHWAY_COLOUR = 0;	//white
	private static final int IMAGE_COLOUR = 1;		//blue
	private static final int ALREADY_COUNTED = 2;	//red: Visited but no path
	
	public static int countBlob(int x, int y){
		if(x<0 || y <0 || x >= N || y >= N)
			return 0;
		else if(grid[x][y] != IMAGE_COLOUR)
			return 0;
		else{
			grid[x][y] = ALREADY_COUNTED;
			return 1+ 
					countBlob(x-1, y+1) +countBlob(x, y+1) + 
					countBlob(x+1, y+1) + countBlob(x+1, y) + 
					countBlob(x+1, y+1) + countBlob(x, y+1) + 
					countBlob(x-1, y-1) + countBlob(x-1, y);
		}
	}
	
	public static void main(String args[]){
		countBlob(5, 3);
	}

}
