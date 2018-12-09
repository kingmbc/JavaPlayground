package samsung.codground.note.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.codeground.org/common/popCodegroundNote#
 * @author Taehun Kim (iDBLab, kingmbc@gmail.com)
 *
 */
public class MainHeap {
    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer> heap = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        heap.add(0); // for 1-based tree

        for (int i = 1; i <= n; i++) {
            heap.add(scanner.nextInt());
            for (int j = i; j > 1; j /= 2) {
                if (heap.get(j) < heap.get(j / 2)) {
                	
                	Collections.swap(heap, j, j/2);
//                    int temp = heap.get(j);
//                    heap.set(j, heap.get(j / 2));
//                    heap.set(j / 2, temp);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            ans.add(heap.get(1));
            heap.set(1, heap.get(n - i + 1));
            for (int j = 1; ; ) {
                int k = j * 2;
                if (k > n - i) break;
                if (k + 1 <= n - i && heap.get(k) > heap.get(k + 1)) k++;
                if (heap.get(j) > heap.get(k)) {
                	Collections.swap(heap, j, k);
                	
//                    int temp = heap.get(j);
//                    heap.set(j, heap.get(k));
//                    heap.set(k, temp);
                    j = k;
                }
                else break;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(ans.get(i) + " ");

    }
    
}
	