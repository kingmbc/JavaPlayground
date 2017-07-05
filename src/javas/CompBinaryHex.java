package javas;

public class CompBinaryHex {

	public static void main(String args[]){
		CompBinaryHex cbh = new CompBinaryHex();
		System.out.println(cbh.compareBinToHex("0010", "000F"));
	}
	
	public boolean compareBinToHex(String binary, String hex){
		int n1 = convertToBase(binary, 2);
		int n2 = convertToBase(hex, 16);
		if(n1 <0 || n2 < 0)
			return false;
		else
			return n1==n2;
	}

	/**
	 * 문자열의 값을 10진법의 수로 바꾸는 함수 
	 * @param number
	 * @param base
	 * @return
	 */
	private int convertToBase(String number, int base) {
		if(base < 2 || (base > 10 && base != 16)) return -1;
		
		int value = 0;
		
		for(int i = number.length()-1; i >=0; i--){
			int digit = digitToValue(number.charAt(i));
			if(digit < 0 || digit >= base)
				return -1;					
			int exp = number.length() - 1 - i;
			value += digit * Math.pow(base, exp);
		}
		return value;
	}

	/**
	 * 문자를 숫자로 바꾸는 함수
	 * @param c
	 * @return
	 * '0' = 0, '1' = 1, 'a' = 10, 'b' = 11
	 */
	private int digitToValue(char c) {
		if(c >= '0' && c<= '9') return c-'0';
		else if(c >= 'A' && c <= 'F') return 10 + c - 'A';
		else if(c >= 'a' && c <= 'f') return 10 + c - 'a';
		
		return -1;
	}
}
