package _kingmbc.datastructure;

public class SingleLinkedList_DummyHead_Object {
	class Node{
		Object data;
		Node next;
		public Node(Object d) {
			data = d;
		}
	}
	
	Node dummy_head = new Node(null);
	
	
	public void addFirst(Object o) {
		Node newNode = new Node(o);
		
		newNode.next = dummy_head.next;
		dummy_head.next = newNode;
	}
	public void addLast(Object o) {
		Node newNode = new Node(o);
		
		Node lastNode = dummy_head.next;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}
		lastNode.next = newNode;
		newNode.next = null;
	}
	public void printList() {
		Node tmp = dummy_head.next;
		while(tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	public static void main(String args[]) {
		SingleLinkedList_DummyHead_Object ldh = new SingleLinkedList_DummyHead_Object();
		ldh.addFirst(new Integer(1));
		ldh.addFirst(new Integer(2));
		ldh.addFirst(new Integer(3));
		ldh.printList();
		ldh.addLast(new Integer(6));
		ldh.addLast(new Integer(5));
		ldh.addLast(new Integer(4));
		ldh.printList();
		
	}
}
