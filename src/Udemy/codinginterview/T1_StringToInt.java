package Udemy.codinginterview;

public class T1_StringToInt {
	public static int convert(String s) {
	    int result = 0;
		char[] arr = s.toCharArray();
		int size = arr.length;
		for(int i = 0; i < arr.length; i++){
		    int nChar = s.charAt(i) - '0';
		    result += nChar * Math.pow(10, --size);
		}
		
		return result;
	}
	
	public static int convert2(String s){
		char[] ca = s.toCharArray();
		int num = 0;
		for(char c : ca){
			num *= 10;
			num += c - '0';
		}
		return num;
	}
	
	public static void main(String args[]){
		System.out.println(convert("123"));
		System.out.println(convert2("123"));
	}
}