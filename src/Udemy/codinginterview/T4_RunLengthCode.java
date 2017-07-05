package Udemy.codinginterview;

/**
 * https://www.udemy.com/codinginterview/learn/v4/t/lecture/5957776?start=0
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class T4_RunLengthCode {
	//0부터 시작
	public static String coding(String s) {
		if(s == null)
			return null;
		
		char prev = ' ';
		String result = "";
		int count = 1;
		char ca[] = s.toCharArray();
		for(int i = 0; i < s.length(); i++){
			char c = ca[i];
			if(prev == c){
				count++;
			}
			else{
				if(count > 1){
					result += count +""+c;
				}else{
					result += c;
				}
				count = 1;
			}
			prev = c;
		}
		if(count > 1){
			result += count;
		}
		return result;
	}
	
	//1부터 시작
	public static String coding2(String s) {
		if(s == null)
			return null;
		
		char prev = ' ', curr = ' ';
		String result = "";
		int count = 1;
		char ca[] = s.toCharArray();
		prev = ca[0];
		
		for(int i = 1; i < ca.length; i++){
			if(prev == ca[i]){
				count ++;
			}
			else{
				result += prev + "" + count;
				count = 1;
				prev = ca[i];
			}
		}
		result += prev + "" + count;
		
		return result;
	}
	
	public static void main(String args[]){
		System.out.println("a3".equals(coding("aaa")));
		System.out.println("a3b3c3deg3".equals(coding("aaabbbcccdeggg")));
		System.out.println("abcd3efg3".equals(coding("abcdddefggg")));
		
		System.out.println("a3".equals(coding2("aaa")));
		System.out.println("a3b3c3deg3".equals(coding2("aaabbbcccdeggg")));
		System.out.println("abcd3efg3".equals(coding2("abcdddefggg")));
	}
}
