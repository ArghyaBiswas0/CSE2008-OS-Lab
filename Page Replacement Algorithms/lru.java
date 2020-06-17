//least recently used page replacement algorithm

import java.util.ArrayList; 

public class lru{ 
    public static void main(final String[] args) {
        final int capacity = 4;
        final int arr[] = { 7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2 };
        final ArrayList<Integer> s = new ArrayList<>(capacity);
        int count = 0;
        int page_faults = 0;
        for (final int i : arr) 
        {
            if(!s.contains(i)) 
            {      
                if(s.size()==capacity) 
                { 
                    s.remove(0); 
                    s.add(capacity-1,i); 
                } 
                else
                    s.add(count,i); 
                    page_faults++; 
                    ++count; 
            
                } 
            else
            {
                s.remove((Object)i); 
                s.add(s.size(),i);          
            } 
        } 
        System.out.println(page_faults); 
    } 
}

