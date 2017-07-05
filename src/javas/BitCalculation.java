package javas;

public class BitCalculation {
	public static void main(String args[]){
		System.out.println(getBit(128, 8));
		System.out.println(setBit(91, 5));
		System.out.println(clearBitsMSBThroughI(4, 2));
		
		System.out.println(Integer.toBinaryString(1-4));
		System.out.println(Integer.toBinaryString((1<<8)-1));
	}
	
	/**
	 * 10진법의 수를 2진법으로 변형하여, i번째 자리의 값(0 or 1)을 리턴
	 * @param num
	 * @param i
	 * @return 1 = true / 0 = false
	 */
	public static boolean getBit(int num, int i){
		return ((num & (1 << i)) != 0);
	}
	
	public static int setBit(int num, int i){
		return (num | (1 << i));
	}
	
	public static int clearBit(int num, int i){
		int mask = ~(1 <<i);
		return num & mask;
	}
	
	public static int clearBitsMSBThroughI(int num, int i){
		int mask = (1 << i) - 1;
		return num & mask;
	}
	
	//해당 위치만 0로 만들어서(11101111) 값을 지우고, 해당 위치의 값에 1을 넣은(00010000)을 OR시킨다
	public static int updateBit(int num, int i, int v){
		int mask = ~(1<<i);
		int value = (num & mask) | (v << i);
		return value;		
	}
	
}
