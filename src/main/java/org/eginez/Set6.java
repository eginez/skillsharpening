package org.eginez;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Set6 {
    public static int maxContiguous(List<Integer> nums, Map<List<Integer>, Integer> sols) {
        if (sols.containsKey(nums)) {
            return sols.get(nums);
        }

        if (nums.isEmpty()) {
            return 0;
        }

        Integer max = null;
        for (int i = 0; i < nums.size(); i++) {
            int current = nums.get(i);
            List<Integer> rest = nums.subList(i, nums.size());
            for(int j = 0; j < 2; j++) {
                if (rest.isEmpty()) {
                    break;
                }
                rest = rest.subList(1, rest.size());
            }

            int sum = current + maxContiguous(rest, sols);
            if (max == null || sum > max) {
                max = sum;
            }
        }
        sols.put(nums, max);
        return max;
    }

    public static boolean fullFilled(List<Integer> nums, Map<Integer,List<Integer>> deps) {;
        HashSet<Integer> cache = new HashSet<>();
        for(int n = 0; n < nums.size(); n++) {
           boolean doable = doable(n, new HashSet<>(), deps, cache);
           if (!doable) {
               return false;
           }
           cache.add(n);
        }
        return true;
    }

    public static boolean doable(int n, Set<Integer> seen, Map<Integer, List<Integer>> deps, Set<Integer> cache) {
        if( cache.contains(n)) {
            return true;
        }

        if (seen.contains(n)) {
            return false;
        }

        seen.add(n);
        if (!deps.containsKey(n))
            return true;

        for(Integer d : deps.get(n)) {
            boolean doable = doable(d, seen, deps, cache);
            if (!doable) {
                return false;
            }
        }
        return true;
    }


}
