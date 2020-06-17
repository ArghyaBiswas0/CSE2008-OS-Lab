import java.util.*;
  
public class bankers 
{ 
    static int P = 4; 
    static int R = 3; 
    static int total = 0; 
    static boolean is_available(final int process_id, final int allocated[][], final int max[][], final int need[][],
            final int available[]) {
        boolean flag = true;
        for (int i = 0; i < R; i++) {
            if (need[process_id][i] > available[i]) {
                flag = false;
            }
        }
        return flag;
    }
    static void safe_sequence(final boolean marked[], final int allocated[][], final int max[][], final int need[][],
            final int available[], final Vector<Integer> safe) {
        for (int i = 0; i < P; i++) {
            if (!marked[i] && is_available(i, allocated, max, need, available)) {
                marked[i] = true;
                for (int j = 0; j < R; j++) {
                    available[j] += allocated[i][j];
                }
                safe.add(i);
                safe_sequence(marked, allocated, max, need, available, safe);
                safe.removeElementAt(safe.size() - 1);
                marked[i] = false;
                for (int j = 0; j < R; j++) {
                    available[j] -= allocated[i][j];
                }
            }
        }
        if (safe.size() == P) {
            total++;
            for (int i = 0; i < P; i++) {
                System.out.print("P" + (safe.get(i) + 1));
                if (i != (P - 1)) {
                    System.out.print("--> ");
                }
            }
            System.out.println("");
            ;
        }
    }
    public static void main(final String[] args) {
 
        final int allocated[][] = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 }, { 2, 1, 1 } };
        final int max[][] = { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 } };
        final int resources[] = { 10, 5, 7 };
        final int[] available = new int[R];
        for (int i = 0; i < R; i++) {
            int sum = 0;
            for (int j = 0; j < P; j++) {
                sum += allocated[j][i];
            }
            available[i] = resources[i] - sum;
        }
        final Vector<Integer> safe = new Vector<Integer>();
        final boolean[] marked = new boolean[P];
        final int[][] need = new int[P][R];
        for (int i = 0; i < P; i++) 
        { 
            for (int j = 0; j < R; j++) 
            { 
                need[i][j] = max[i][j] - allocated[i][j]; 
            } 
        } 
        System.out.println("Safe sequences are:"); 
        safe_sequence(marked, allocated, max, need, available, safe); 
        System.out.println("\nThere are total " + total + " safe-sequences"); 
    } 
}
