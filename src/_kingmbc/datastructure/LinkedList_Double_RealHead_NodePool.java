package _kingmbc.datastructure;

public class LinkedList_Double_RealHead_NodePool {

	Node[] nodePool = new Node[1000000];
	int nodeCnt = 0;
	public Node newNode() {
		return nodePool[nodeCnt++];
	}
	class Node{		
		Node prev;
		Node next;
		int value;		
	}
	
	class List{
		Node head;
		Node tail;
		
		public List() {
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;
		}
		public void insertHead(int value) {
			Node n = new Node();
			n.value = value;
			
			n.next = head;
			head.prev = n;
			head = n;
		}
		public void insertTail(int value) {
			Node n = new Node();
			n.value = value;
			
			tail.next = n;
			n.prev = tail;
			n = tail;
		}
		public Node findNodeUsingFor(int value) {
			Node result = null;
			for(Node t = head; t != null; t = t.next) {
				if(t.value == value) {
					result = t;
					break;
				}	
			}
			return result;
		}
		public Node findNodeUsingWhile(int value) {
			Node result = null;
			Node t = head;
			while(t != null){
				if(t.value == value) {
					result = t;
					break;
				}
				t = t.next;
			}
			return result;
		}
		
	}
}
