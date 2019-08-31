package _kingmbc.datastructure;

/**
 * @description Hashtable implementation based on Close-addressing (i.e., chaining)
 * @author kingmbc
 * @date 2018-12-18
 * 
 *  @see http://www.algolist.net/Data_structures/Hash_table/Chaining
 */
public class HashTable_Int {
	public static void main(String args[]) {
		int HASH_TABLE_SIZE = 10007;	//소수
		HashTable_Int tb = new HashTable_Int(HASH_TABLE_SIZE);
		tb.putValueByKey(1, 1);
		tb.putValueByKey(1, 2);
		tb.putValueByKey(1, 3);
		tb.putValueByKey(2, 2);
		tb.putValueByKey(3, 3);
		tb.removeByKey(4);
		System.out.println(tb.getValue(1));
	}
	
	
	/****************************************************************
	 * IMPLEMENTATION
	 ****************************************************************/
	static int hash = 5387;
	int hashTableSize = 0;
	Node[] hashTable = null;
	
	public HashTable_Int(int size) {
		hashTableSize = size;
		hashTable = new Node[size];
	}
	/**
	 * 그냥 막짬
	 * @param key
	 * @return
	 */
	public int hashing(int key) {
		int h;
		h = key;
		h = h % hashTableSize;
		return h;
	}
	/**
	 * hash값을 받아와서 Table의 Entry를 가져오고, 
	 * Entry가 없다면, 새로 생성해서 Key/Value를 넣어줌
	 * Entry가 있다면, 해당되는 Key가 있는지 탐색
	 * 					Key가 있다면 덮어쓰기
	 * 					Key가 없다면 새로 생성해서 만들어 줌
	 * @param key
	 * @param value
	 */
	public void putValueByKey(int key, int value) {
		int hash = hashing(key);
		if(hashTable[hash] == null) {
			hashTable[hash] = new Node(key, value);
		}else {
			Node entry = hashTable[hash];
			//entry의 Next가 있고, 그리고 찾고자 하는 key가 아니면 다음으로 계속 넘김
			//즉, entry가 null이거나, getKey가 있으면 멈춤
			while(entry.getNext() != null && entry.getKey() != key) {
				entry = entry.getNext();
			}
			if(entry.getKey() == key)
				entry.setValue(value);
			else 	//마지막 배열에 붙임
				entry.setNext(new Node(key, value));
		}
	}
	public int getValue(int key) {
		int result = 0;
		
		int hash = hashing(key);
		Node entry = hashTable[hash];
		if(entry == null)
			return Integer.MIN_VALUE;
		else {
			while(entry.getNext() != null && entry.getKey() != key)
				entry = entry.getNext();
			if(entry == null)
				result = Integer.MIN_VALUE;
			else
				result = entry.getValue();
		}
		return result;
	}
	public boolean removeByKey(int key) {
		int h = hashing(key);
		if(hashTable[h] == null) {
			System.out.println("[1]There is no entry for the key");
			return false;
		}else {
			Node entry = hashTable[h];
			Node prevEntry = null;
			while(entry.getNext() != null && entry.getKey() != key) {
				prevEntry = entry;
				entry = entry.getNext();
			}
			if(entry.getKey() == key) {
				if(prevEntry == null)
					hashTable[hash] = entry.getNext();
				else
					prevEntry.setNext(entry.getNext());
			}else {
				System.out.println("[2]There is no entry for the key");
				return false;
			}
		}
		return true;
	}
	
	class Node{
		int key;
		int value;
		Node next;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
		public int getKey() {
			return key;
		}
		public int getValue() {
			return value;
		}
		public void setKey(int key) {
			this.key = key;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getNext() {
			return next;
		}
		
	}
}
