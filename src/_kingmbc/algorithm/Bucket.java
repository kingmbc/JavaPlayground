package _kingmbc.algorithm;

public class Bucket {
	//Bucket을 써서 탐색 범위를 앞과 뒤만 보도록
	Timestamp[] timestampIdx = new Timestamp[100];
	
	int[][] professor_relation = new int[1001][1001];
	
	class Paper{
		Paper next;
		int professorId;
		int paperId;
		int publish_timestamp;
		int citation; 
	}
	class Timestamp{
		int userId;
		int paperId;
		
		Paper head;
		void append_front(Paper p) {			
			p.next = head;
			head = p;
		}
	}
	
	public void init() {
		for(int i = 0; i < 100; ++i) {
			timestampIdx[i] = new Timestamp();
		}
	}
	public void hasInterest(int professorId1, int professorId2) {
		
	}
	public void citation(int paperId, int timestamp) {
		
	}	
	public void publish(int professorId, int paperId, int timestamp) {
		int idx = timestamp / 1000;
		Paper p = new Paper();
		p.professorId = professorId;
		p.paperId = paperId;
		p.publish_timestamp = timestamp;
		timestampIdx[idx].append_front(p);
	}
	public void getTop(int professorId, int timestamp, int[] result) {
		
	}
}
