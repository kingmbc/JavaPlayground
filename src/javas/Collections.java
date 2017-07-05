package javas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * ArrayList, LinkedList, Stack, Queue, HashMap, HashSet, PriorityQueue
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class Collections {
	public static void main(String args[]){
		ArrayList<Integer> intArr = new ArrayList<>();
		intArr.add(1);
		intArr.add(2);

		LinkedList<Integer> linkList = new LinkedList<>();
		linkList.add(1);
		linkList.add(2);

		Stack<Integer> intStack = new Stack<>();
		intStack.push(1);
		intStack.pop();



		Queue<Integer> intQueue = new LinkedList<Integer>();
		intQueue.add(1);
		intQueue.add(2);
		intQueue.poll();
		intQueue.offer(2);

		Queue<Integer> priorityQ = new PriorityQueue<>();
		priorityQ.add(2);
		priorityQ.add(3);
		priorityQ.add(4);
		priorityQ.add(1);
		System.out.println(priorityQ);

		HashMap<String, Integer> hashM = new HashMap<String, Integer>();
		hashM.put("1", 1);
		hashM.put("2", 2);
		hashM.put("2", 2);
		System.out.println(hashM);


		TreeMap<String, Integer> treeM = new TreeMap<String, Integer>();
		treeM.put("1", 1);
		treeM.put("2", 2);
		treeM.put("1", 1);
		System.out.println(treeM);

		HashSet<Integer> hashS = new HashSet<>();
		hashS.add(1);
		hashS.add(2);
		hashS.add(1);
		System.out.println(hashS);

		/**
		 * TreeSet은 이진탐색트리(BinarySearchTree)의 형태로 데이터를 저장하는 컬렉션입니다.
		 * 이진탐색트리 중에서도 성능을 향상시킨 '레드-블랙 트리(Red-Black Tree)로 구현되어 있습니다.
		 * 따라서 데이터의 추가, 삭제에는 시간이 걸리지만, 검색과 정렬이 뛰어나다는 장점이 있습니다.
		 * TreeSet은 마찬가지로 중복된 데이터의 저장을 허용하지 않으며 정렬된 위치에 저장하므로
		 * 저장순서를 유지하지 않습니다
		 * 출처: http://swalloow.tistory.com/36 [MyCloud]
		 */
		TreeSet<String> set = new TreeSet<String>();

		set.add("apple");
		set.add("airplane");
		set.add("alien");
		set.add("disc");
		set.add("dance");

		System.out.println(set.headSet("b"));
		System.out.println(set.subSet("a", "al"));
		System.out.println(set.tailSet("c"));


	}
}
