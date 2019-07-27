package _kingmbc.algorithm;

public class Compress {
	//각 셀의 값을 보고 탐색공간을 (2*2 or 3*3)를 Bit연산으로 하나의 값으로 만들어서, 비교함
	// val = [0, 16) (2^4)
	// val = [0, 256) (2^8)
	// val = [0, 512) (2^9)
	// val = [0, 1024) (2^10)
	
	
	////////////////////////////////// 4칸의 값을 16bit로 만들기 위함
	//원래 4칸의 값
	int a1 = 15;
	int a2 = 15;
	int b1 = 16;
	int b2 = 16;
	
	//각 값을 16bit로 만든 값
	int value_16bit = a1 << 12 + a2 << 8 + a1 << 4 + a1 << 0;
	
	
}
