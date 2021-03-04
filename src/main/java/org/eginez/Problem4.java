package org.eginez;

import java.util.*;

public class Problem4 {
    public static int coinsCount(int target, List<Integer> denomination, Map<Integer, Integer> table) {
        table.put(0, 0);
        denomination.sort(Collections.reverseOrder());
        int count;
        for(int i = 1; i <= target; i++) {
            List<Integer> counts = new ArrayList<>();
            for (Integer dem : denomination) {
                if ( i >= dem) {
                    count = i / dem;
                    int res = i % dem;
                    count += table.get(res);
                    counts.add(count);
                }
            }
            int min = counts.stream().min(Comparator.naturalOrder()).get();
            table.put(i, min);
        }
        return table.get(target);
    }
    
}
