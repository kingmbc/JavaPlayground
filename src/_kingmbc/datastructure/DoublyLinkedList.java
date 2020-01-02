package _kingmbc.datastructure;

public class DoublyLinkedList {
	public static void main(String[] args) {
		DoublyLinkedList a = new DoublyLinkedList();
		DoublyLinkedList b = new DoublyLinkedList();
		int TEST_N = 10;
		for (int i = 0; i < TEST_N; i++) {
			int val = i;
			//insert val to list
			a.append_in_tail(val);
			b.append_in_head(val);
		}

		a.print();
		b.print();

		System.out.println("\n\n\n");

		for (int i = 0; i < TEST_N; i += 2) {
			int val = i;
			//delete val from list
			a.del(val);
			b.del(val);
		}


		//print all elements in list
		a.print();
		b.print();
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
	
	void append_in_head(int val) {
		Node n = newNode();
		n.val = val;
		
		head.next.prev = n;
		n.next = head.next;
		
		head.next = n;
		n.prev = head;
	}

	void append_in_tail(int val) {
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
	void print(){
		for(Node ptr = head.next; ptr != tail; ptr = ptr.next){
			System.out.print(ptr.val);
			System.out.print("-");
		}
	}
}

