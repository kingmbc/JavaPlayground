package javas.pknu.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=TdakkF5Xh6o&index=19&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 * https://stackoverflow.com/questions/3522454/java-tree-data-structure
 *
 */
public class Tree<T> {
	private TreeNode<T> root;
	
	public Tree(T rootData){
		root = new TreeNode<T>();
		root.data = rootData;
		root.children = new ArrayList<TreeNode<T>>();
	}
	static class TreeNode<T>{
		private T data;
		private TreeNode<T> parent;
		private List<TreeNode<T>> children;		
	}

}
