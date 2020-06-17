//first come first serve page replacement algorithm

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class fcfs 
{
    static int pageFaults(final int pages[], final int n, final int capacity) {
        final HashSet<Integer> s = new HashSet<>(capacity);

        final Queue<Integer> indexes = new LinkedList<>();

        int page_faults = 0;
        for (int i = 0; i < n; i++) {
            if (s.size() < capacity) {
                if (!s.contains(pages[i])) {
                    s.add(pages[i]);
                    page_faults++;
                    indexes.add(pages[i]);
                }
            } else {
                if (!s.contains(pages[i])) {
                    final int val = indexes.peek();
                    indexes.poll();
                    s.remove(val);
                    s.add(pages[i]);
                    indexes.add(pages[i]);
                    page_faults++;
                }
            }
        }

        return page_faults;
    }

    public static void main(final String args[]) {
        final int pages[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        final int capacity = 4;
        System.out.println(pageFaults(pages, pages.length, capacity)); 
    } 
}
