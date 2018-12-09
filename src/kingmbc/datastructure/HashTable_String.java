package kingmbc.datastructure;

public class HashTable_String {
	public static void main(String args[]) {
		HashTable_String tb = new HashTable_String(100);
		tb.put("Taehun", "I am a boy");
		tb.put("Taehun", "I am a boy2");
		tb.put("Taehun", "I am a boy3");
		tb.put("Okil", "I am a girl");
		System.out.println("Taehun ==> " + tb.get("Taehun"));
		System.out.println("Yuhyun ==> " + tb.get("Yuhyun"));
		tb.delete("Taehun");
		System.out.println("Taehun ==> " + tb.get("Taehun"));
	}
	/********************************************************
	 * IMPLEMENTATION
	 */
	LinkedHashEntry[] table;
	static int HASH_TABLE_SIZE;
	public HashTable_String(int size) {
		table = new LinkedHashEntry[size];
		HASH_TABLE_SIZE = size;
	}
	public void put(String key, String value) {
		int h = hashing(key);
		if(table[h] == null)
			table[h] = new LinkedHashEntry(key, value);
		else {
			LinkedHashEntry entry = table[h];
			while(entry.getNext() != null && entry.key != key) {
				entry = entry.getNext();
			}
			if(entry == null) {		//entry == null
				entry = new LinkedHashEntry(key, value);
			}else {					//entry.key == key
				entry.value = value;
			}
		}
	}
	public String get(String key) {
		String result = null;
		int h = hashing(key);
		if(table[h] == null) {
//			System.out.println("There is no entry");
			return null;
		}
		else {
			LinkedHashEntry entry = table[h];
			while(entry.getNext() != null && entry.key != key) {
				entry = entry.getNext();
			}
			if(entry == null) {		//entry == null
				System.out.println("There is no entry");
				result = null;
			}else {					//entry.key == key
				result = entry.value;
			}
		}
		return result;
	}
	public boolean delete(String key) {
		int h = hashing(key);
		if(table[h] == null) {
//			System.out.println("There is no entry");
			return false;
		}else {
			LinkedHashEntry entry = table[h];
			while(entry.getNext() != null && entry.key != key)
				entry.getNext();
			if(entry.key == key) {
				if(entry.prev == null)
					table[h] = entry.next;
				else {
					entry.prev.next = entry.next;
				}
			}
		}
		return true;
	}
	public int hashing(String key) {
		int h = 0;
		for(char c : key.toCharArray())
			h += c;
		h = h % HASH_TABLE_SIZE;
		return h;
	}
	
	class LinkedHashEntry{
		String  key;
		String  value;
		LinkedHashEntry prev;
		LinkedHashEntry next;
		public LinkedHashEntry(String key, String value) {
			this.key = key;
			this.value = value;
		}
		public LinkedHashEntry getNext() {
			return next;
		}
		public LinkedHashEntry getPrev() {
			return prev;
		}
	}
}
