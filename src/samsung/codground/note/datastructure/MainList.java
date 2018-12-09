package samsung.codground.note.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.codeground.org/common/popCodegroundNote#
 * List
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class MainList {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);

		int size = scanner.nextInt();
		List<Integer> list = new ArrayList<>();

		for(int i = 0; i < size; i++){
			String command = scanner.next();
			if(command.charAt(0) == 'p'){
				int value = scanner.nextInt();
				list.add(value);			
			}
			else if(command.charAt(0) == 'g'){
				int idx = scanner.nextInt();
				System.out.println(list.get(idx));
			}
			else if(command.charAt(0) == 's'){
				System.out.println(list.size());			
			}
			else if(command.charAt(1) == 'o'){				
				int compValue = scanner.nextInt();
				int count = 0;
				for(int j=0; j < list.size(); j++){
					if(list.get(j) == compValue){
						count ++;
					}
				}
				System.out.println(count);
							
			}
			else if(command.charAt(1) == 'l'){				
				list.clear();							
			}
		}
	}

}
