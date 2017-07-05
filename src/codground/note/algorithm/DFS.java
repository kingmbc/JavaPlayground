package codground.note.algorithm;

import java.util.Scanner;

/**
 * 
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 * 
 * 해당 알고리즘을 구현하기 위해서는 해당 정점이 방문되었는지 확인하는 boolean타입의 1차원 배열과 
 * 정점들의 집합 그리고 정점과 정점 사이의 연결을 확인할 수 있는 간선 집합들이 필요합니다.
 * 
 * 그리고 해당 알고리즘의 시간복잡도는 모든 정점을 방문하며 모든 간선을 검사하기 때문에 시간복잡도는 O(V+E)입니다. ( V: 정점의 개수, E: 간선의 개수)
 * 그래프의 구현은 그래프 챕터에서 다뤘듯이 인접행렬 방식과 인접 리스트 방식이 존재합니다. 
 * 위 문서에서는 C와 JAVA 코드는 인접행렬 방식, C++코드는 인접 리스트 방식을 이용하여 DFS를 구현하도록 하겠습니다.
 *
 */
public class DFS {
	static boolean edge[][];
	static boolean visited[];
	static int n;
	static int m;
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		m = scanner.nextInt();
		
		edge = new boolean[n+1][n+1];
		visited = new boolean[n+1];		
		
		for(int i = 0; i < m; i++){
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			edge[u][v] = true;
		}
		dfs(1);
		
	}
	
	public static void dfs(int here){
		visited[here] = true;
		System.out.print(String.valueOf(here) + ' ');
		
		for(int there = 1; there <= n; there++){
			if(visited[there] || !edge[here][there])	//already visited or not connected.
				continue;
			dfs(there);
		}
	}	
}
