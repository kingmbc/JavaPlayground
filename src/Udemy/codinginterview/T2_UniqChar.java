package Udemy.codinginterview;

import java.util.HashSet;

public class T2_UniqChar {
	public static boolean isUniqChar(String s) {
        HashSet<Character> hs = new HashSet<>();
        for(char c : s.toCharArray()){
        	if(hs.contains(c))
        		return false;
        	hs.add(c);
        }
		return true;
	}
	public static boolean isUniqChar2(String s){
		boolean[] ba = new boolean[128];
		for(int i = 0; i < 128; i++)
			ba[i] = false;
		
		for(char c : s.toCharArray()){
			int idx = (int)c;
			if(!ba[idx])
				ba[idx] = true;
			else
				return false;
		}
		
		return true;		
	}
	public static void main(String args[]){
		System.out.println(isUniqChar("abcd"));
		System.out.println(isUniqChar2("abcb"));
		System.out.println(isUniqChar2("abcd"));
	}
}
