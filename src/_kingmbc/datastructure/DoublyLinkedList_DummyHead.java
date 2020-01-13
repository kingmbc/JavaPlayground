package _kingmbc.datastructure;

public class DoublyLinkedList_DummyHead {
	public static void main(String[] args) {
		DoublyLinkedList_DummyHead a = new DoublyLinkedList_DummyHead();
		DoublyLinkedList_DummyHead b = new DoublyLinkedList_DummyHead();
		int TEST_N = 10;
		for (int i = 0; i < TEST_N; i++) {
			//insert val to list
			a.appendInTail(i);
			b.appendInHead(i);
		}

		a.print();
		System.out.println();
		b.print();
		System.out.println();

		for (int i = 0; i < TEST_N; i += 2) {
			//delete val from list
			a.delUsingWhile(i);
			b.delUsingWhile(i);
		}

		//print all elements in list
		a.print();
		System.out.println();
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
	DoublyLinkedList_DummyHead() {
		for(int i = 0; i < 10001; i++)
			nodePool[i] = new Node();
		
		head = newNode();	//dummy head
		tail = newNode();	//dummy tail

		head.next = tail;
		tail.prev = head;
		System.out.println();
	}
	
	void appendInHead(int v) {
		Node n = newNode();
		n.val = v;

		head.next.prev = n;
		n.next = head.next;

		head.next = n;
		n.prev = head;
	}

	void appendInTail(int v) {
		Node n = newNode();
		n.val = v;

		tail.prev.next = n;
		n.prev = tail.prev;

		tail.prev = n;
		n.next = tail;
	}
	
	void delUsingWhile(int v) {
		Node ptr = head.next;
		
		while(ptr != tail) {
			if(ptr.val == v) {
				ptr.next.prev = ptr.prev;
				ptr.prev.next = ptr.next;
				
				ptr = ptr.prev;
			}
			ptr = ptr.next;
		}
	}
	void delUsingFor(int v){
		for(Node ptr = head.next; ptr != tail; ptr = ptr.next){
			if(ptr.val == v){
				ptr.prev.next = ptr.next;
				ptr.next.prev = ptr.prev;

				ptr = ptr.prev;
			}
		}
	}
	void print(){
		for(Node ptr = head.next; ptr != tail; ptr = ptr.next){
			System.out.print(ptr.val);
			System.out.print("-");
		}
	}
}

