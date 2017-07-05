package Udemy.codinginterview;

import java.util.HashMap;

public class T3_Anagram {
	public static boolean isAnagram2(String s1, String s2) {
		if(s1.length() != s2.length())
    		return false;
		
		int[] countArr = new int[256];
		for(int i = 0; i < 256; i++)
			countArr[i] = 0;
		
		for(char c : s1.toCharArray()){
			int idx = (int) c;
    		countArr[idx]++;
    	}
		for(char c : s2.toCharArray()){
			int idx = (int) c;
			if(countArr[idx] == 0)
				return false;
    		countArr[idx]--;    		
    	}
		
		return true;
		
	}
    public static boolean isAnagram(String s1, String s2) {
    	if(s1.length() != s2.length())
    		return false;
    	
    	HashMap<Character, Integer> hm = new HashMap<>();
    	for(char c : s1.toCharArray()){
    		if(hm.containsKey(c)){
    			int v = hm.get(c);
    			hm.replace(c, v++);
    		}else{
    			hm.put(c, 1);
    		}
    	}
    	
    	for(char c : s2.toCharArray()){
    		if(!hm.containsKey(c))
    			return false;
    		
    		if(hm.get(c) == 0)
    			return false;
    		
    		if(hm.containsKey(c)){
    			hm.put(c, hm.get(c) - 1);
    		}
    	}
    	
        return true;
    }
    
    public static void main(String args[]){
    	System.out.println(isAnagram("car", "rac"));
    	System.out.println(isAnagram("car●", "●rac●"));		//Exception 안남
    	System.out.println(isAnagram2("carc●", "●racc"));	//Exception남
    }
}