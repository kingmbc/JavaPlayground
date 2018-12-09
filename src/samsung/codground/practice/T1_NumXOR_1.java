package samsung.codground.practice;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;

/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
public class T1_NumXOR_1 {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> odds = new ArrayList<>();
		
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input DATA in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read DATA.
		 */
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			// Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
			/////////////////////////////////////////////////////////////////////////////////////////////
			int n = sc.nextInt();
			
			HashSet<Integer> hs = new HashSet<>();
			for(int i = 0; i < n; i++){
				int value = sc.nextInt();
				arr.add(value);
				hs.add(value);
			}
			
			Integer[] keys = hs.toArray(new Integer[0]);
//			Collections.sort(arr);
			for(int i = 0; i < keys.length; i++){
				int frequency = Collections.frequency(arr, keys[i]);
				if(!isEven(frequency))
					odds.add(keys[i]);
			}

			for(int i = 0; i < odds.size(); i++){
				Answer += odds.get(i);
			}
			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
	
	public static boolean isEven(int a){
		return (a%2 == 0);
	}
}