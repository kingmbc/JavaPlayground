package swexpert;

public class PackageRecommendation {
	public static final int MAX_USER = 1000;
	public static final int MAX_PACKAGE = 1000000000;
	public static final int PACK_DIV = 10000;
	public static final int MAX_AREA = 10;
	
	class User{
		int uid;
		int friend_num = 0;								//친구 수
		LinkedList friend_list = new LinkedList();	//친구 리스트
		LinkedList package_list = new LinkedList();	//사용자가 예약한 상품 상품 리스트
	}
	class Package{		
	//상품
		int pid;			//상품 ID
		int area_id;		//상품 장소
		int price = 0;	//상품 가격
		boolean is_booked = false;	//상품이 예약되어 있는지
		int booked_by = 0;			//상품 예약자
		public Package(int pid, int area, int price) {
			this.pid = pid;
			this.area_id = area;
			this.price = price;
			this.is_booked = false;
		}
	}
	class Area{
		int aid;
		int popluarity = 0;			//각 장소의 인기도 (그때 그때 다름)
		int package_num = 0;			//각 장소별 상품 갯수
		LinkedList package_list = new LinkedList();	//각 장소의 상품 리스트
	}
	User[] user_list;
	Area[] area_list;
	LinkedList[] pack_list;	//십억을 저장해야 하므로, 해쉬
	
	int[][] friend_relation = new int[MAX_USER][MAX_USER];
	int[][] visit_check = new int[MAX_USER][MAX_USER];
	
	
	public void init(int N, int M) {
		user_list = new User[N];
		for(int i = 0; i < N; i++) {
			user_list[i] = new User();
			for(int j = 0; j < N; j++) {
				friend_relation[i][j] = 0;
				visit_check[i][j] = 0;
			}
		}
		
		area_list = new Area[M];
		for(int i = 0; i < M; i++) {
			area_list[i] = new Area();
		}
	}
	public void be_friend(int uid1, int uid2) {		
		user_list[uid1].uid = uid1;
		user_list[uid2].uid = uid2;
		
		friend_relation[uid1][uid2] = 1;		
	}
	public void add_pack(int pid, int area, int price) {
		pack_list[pid/PACK_DIV].append(pid, new Package(pid, area, price));
		
		area_list[area].aid = area;
		area_list[area].package_list.append(pid, new Package(pid, area, price));
		area_list[area].package_num++;
	}
	public void reserve(int uid, int pid) {
		user_list[uid].package_list.append(pid);
		Package p = pack_list[pid/PACK_DIV].findValue(pid);
		p.is_booked = true;
		p.booked_by = uid;
	}
	
	//사용자와 그 친구들이 예약한 상품들의 지역들을 가져오고, 그 중에서 가장 많은 지역들을 고른다. (Popularity에 따라 Top1 Area, Top2 Area, Top3 Area)
	//만약 예약 상품이 없으면 모든 지역들을 탐색한다.
	//그 지역들이 갖고 있는 상품들 
	public void getRec(int uid) {
		
	}
	
	class Node{
		Node next;
		Node prev;
		int key;
		int value;
		Package pack;
	}
	class LinkedList{
		Node head;
		Node tail;
		public LinkedList() {
			head = new Node();
			tail = new Node();
			head.next = tail;
			tail.prev = head;			
		}
		public void append(int key) {
			Node n = new Node();
			n.key = key;
			
			tail.prev.next = n;
			n.prev = tail.prev;
			
			tail.prev = n;
			n.next = tail;			
		}
		public void append(int key, Package p) {
			Node n = new Node();
			n.key = key;
			n.pack = p;
			
			tail.prev.next = n;
			n.prev = tail.prev;
			
			tail.prev = n;
			n.next = tail;			
		}
		public void del(int key) {
			Node ptr = head.next;
			while(ptr != tail) {
				if(ptr.key == key) {
					ptr.prev.next = ptr.next;
					ptr.next.prev = ptr.prev;
					
					ptr = ptr.prev;
				}
				ptr = ptr.next;
			}
			
		}
		public Package findValue(int key) {
			Node ptr = head.next;
			while(ptr != tail) {
				if(ptr.key == key) {
					break;
				}
				ptr = ptr.next;
			}
			return ptr.pack;
		}
	}

}
