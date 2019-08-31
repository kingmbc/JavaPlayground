
public class DoublyLinkedList {
	public static void main(String[] args) {
		DoublyLinkedList a = new DoublyLinkedList();
		int TEST_N = 10;
		for (int i = 0; i < TEST_N; i++) {
			int val = i;
			//insert val to list
			a.append(val);
		}

		Node ptr = a.head.next;
		while (ptr != a.tail) {
			System.out.println(ptr.val);
			ptr = ptr.next;
		}

		System.out.println("\n\n\n");

		for (int i = 0; i < TEST_N; i += 2) {
			int val = i;
			//delete val from list
			a.del(val);
		}


		//print all elements in list
		ptr = a.head.next;
		while (ptr != a.tail) {
			System.out.println(ptr.val);
			ptr = ptr.next;
		}
	}
	class Node{
		Node next;
		Node prev;
		int val;
		public Node() {			
		}
	}


	//implement nodePool and nodeCnt here
	Node nodePool[] = new Node[10001];
	int nodeCnt;
	Node newNode() {
		return nodePool[nodeCnt++]; 
	}


	//implement here
	Node head;
	Node tail;
	DoublyLinkedList() {
		for(int i = 0; i < 10001; i++)
			nodePool[i] = new Node();
		
		head = newNode();	//dummy head
		tail = newNode();	//dummy tail

		head.next = tail;
		tail.prev = head;
		System.out.println();
	}

	void append(int val) {
		Node n = newNode();
		n.val = val;

		tail.prev.next = n;
		n.prev = tail.prev;

		tail.prev = n;
		n.next = tail;
	}
	
	void del(int val) {
		Node ptr = head.next;
		
		while(ptr != tail) {
			if(ptr.val == val) {
				ptr.next.prev = ptr.prev;
				ptr.prev.next = ptr.next;
				
				ptr = ptr.prev;
			}
			ptr = ptr.next;
		}
	}
}

