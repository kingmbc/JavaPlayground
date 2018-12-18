package _kingmbc.algorithm;

public class DFS {
	int MAX_NODE = 10;
	int Graph[][];
	int Top;
	int Stack[];
	
	public void dfs(int node) {
		boolean visited[] = {false};
		Top = -1;
		Stack[++Top] = node;
		
		while(Top != -1) {
			int cur = Stack[Top--];
			if(!visited[cur]) {
				visited[cur] = true;
				
				for(int i = 0; i < MAX_NODE; ++i) {
					if(!visited[i] && Graph[cur][i] == 1)
						Stack[++Top] = i;
				}
			}
		}
	}
}
