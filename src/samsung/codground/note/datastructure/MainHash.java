package samsung.codground.note.datastructure;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.codeground.org/common/popCodegroundNote#
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */

public class MainHash {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashSet<String> hash = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int command = sc.nextInt();
            String key = sc.next();

            if (command == 1) {
                hash.add(key);
            }
            else if (command == 2) {
                hash.remove(key);
            }
            else {
                if (hash.contains(key)) {
                    System.out.println("1");
                }
                else {
                    System.out.println("0");
                }
            }
        }
        System.out.println(hash.toArray());
    }
}
