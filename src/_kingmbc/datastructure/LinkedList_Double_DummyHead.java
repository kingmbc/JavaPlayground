package _kingmbc.datastructure;

public class LinkedList_Double_DummyHead {	
	class Node{
		Node prev;
		Node next;
		int value;		
	}
	class LinkedList{
		Node dummyHead = new Node();
		Node dummyTail = new Node();
		
		public LinkedList() {
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
		}
		public void insertInHead(int v) {
			Node n = new Node();
			n.value = v;
			
			n.next = dummyHead.next;
			dummyHead.next.prev = n;
			dummyHead.next = n;
		}
		public void insertInTail(int v) {
			Node n = new Node();
			n.value = v;
			
			Node tail = dummyTail.prev;
			
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
	}
	
}
