package _kingmbc;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaTest {
	
	public static void main(String[] args) {
		
		
		new Thread(() -> {
			System.out.println("Hello World");
		}).start();
		
		
		
		/********************************************************* 
		 * Example 1
		 *********************************************************/
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		LambdaTest lt = new LambdaTest();
		System.out.println("##### 사용예 1.1");
		lt.listTest(numbers);
		System.out.println("##### 사용예 1.2");
		lt.listTest2(numbers);
		System.out.println("##### 사용예 1.3");
		lt.listTest3(numbers);
		
		/********************************************************* 
		 * Example 2
		 *********************************************************/
		Resource resource = new Resource();
		System.out.println("##### 사용예 2.1");
		resource.operate();
		resource.dispose();
		
		System.out.println("##### 사용예 2.2");
		Resource resource2 = new Resource();
		try {
		    resource2.operate();
		} finally {
		    resource2.dispose();
		}
		
		/**
		 * 1. withResource 함수에 람다식을 넘긴다.
		 * 2. 넘길때 어떤 operation이 선제되어야 하는지 작성
		 * 3. withResource 함수 내부에서 Consumer를 통해 
		 */
		System.out.println("##### 사용예 2.3");		
		Resource.withResource(resource3 -> resource3.operate());
	}
	
	/**
	 * 우리가 늘(?) 짜던 방식 
	 * @param numbers
	 */
	public void listTest(List<Integer> numbers){		
		for (int number : numbers) {
		    if (number % 2 == 0) {
		        int n2 = number * 2;
		        if (n2 > 5) {
		            System.out.println(n2);
		            break;
		        }
		    }
		}
	}
	
	/**
	 * 간결화 2
	 * @param numbers
	 */
	public static boolean isEven(int number) {
		System.out.println("isEven: " + number);
	    return number % 2 == 0;
	}
	 
	public static int doubleIt(int number) {
		System.out.println("doubleIt: " + number);
	    return number * 2;
	}
	 
	public static boolean isGreaterThan5(int number) {
		System.out.println("isGreaterThan5: " + number);
	    return number > 5;
	}
	public void listTest2(List<Integer> numbers){
		List<Integer> l1 = new ArrayList<Integer>();
		for (int n : numbers) {
		    if (isEven(n)) l1.add(n);
		}
		 
		List<Integer> l2 = new ArrayList<Integer>();
		for (int n : l1) {
		    l2.add(doubleIt(n));
		}
		 
		List<Integer> l3 = new ArrayList<Integer>();
		for (int n : l2) {
		    if (isGreaterThan5(n)) l3.add(n);
		}
		 
		System.out.println(l3.get(0));

	}
	
	public void listTest3(List<Integer> numbers){
		System.out.println(
			    numbers.stream()
			            .filter(LambdaTest::isEven)
			            .map(LambdaTest::doubleIt)
			            .filter(LambdaTest::isGreaterThan5)
			            .findFirst()
			);

	}
	
	
		

}
