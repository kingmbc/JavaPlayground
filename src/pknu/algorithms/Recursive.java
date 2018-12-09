package pknu.algorithms;

/**
 * https://www.youtube.com/watch?v=tuzf1yLPgRI&list=PL52K_8WQO5oUuH06MLOrah4h05TZ4n38l&index=2
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class Recursive {
	public static void main(String args[]){
		int result = func(4);
		System.out.print(result);
		System.out.println("abc".substring(1));
		printInBinary(10);
	}
	
	public static int func(int n){
		if (n <= 0)
			return 0;
		else{
			return n + func(n-1);
		}
	}
	
	public static int factorial(int n){
		if (n == 0)
			return 1;
		else
			return n * factorial(n-1);
	}
	
	public static double power(double x, int n){
		if (x == 0)
			return 1;
		else
			return x * power(x, n-1); 
	}
	
	public static int gcd(int m, int n){
		if(m < n){
			int tmp = m;
			m = n;
			n = tmp;
		}
		
		if(m%n == 0){
			return n;
		}
		else{
			return gcd(n, m%n);
		}
	}
	
	public static int length(String str){
		if(str.equals(""))
			return 0;
		else
			return 1 + length(str.substring(1));
	}
	public static void printChars(String str){
		if(str.length() == 0)
			return;
		else{
			System.out.println(str.charAt(0));
			printChars(str.substring(1));
		}
	}
	public static void printCharsReverse(String str){
		if(str.length() == 0)
			return;
		else{
			printCharsReverse(str.substring(1));
			System.out.println(str.charAt(0));
		}
	}
	public static void printInBinary(int n){
		if(n < 2)
			System.out.print(n);
		else{
			printInBinary(n / 2);
			System.out.print(n % 2);
		}
	}

	public static int sum(int n, int[] data){
		if(n <= 0)
			return 0;
		else
			return sum(n-1, data) + data[n-1];
	}
	
}
