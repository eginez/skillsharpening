package org.eginez;

import java.util.*;

public class Problem4 {

    static List<Integer> defaultCoins = Arrays.asList(1, 5, 10, 25);
    public static int coinNum(int num) {
        return coinsWithVals(num, defaultCoins);
    }
    public static int coinsWithVals(int target, List<Integer> coins) {
        coins.sort(Comparator.naturalOrder());
        int minNumCoins = Integer.MAX_VALUE;
        for (int start = coins.size() - 1; start >= 0; start--) {
            int i = start;
            int left = target;
            int numCoins = 0;
            boolean notFound = false;
            while (left > 0) {
                if (i < 0) {
                    notFound = true;
                    break;
                }
                Integer coin = coins.get(i);
                if (left >= coin) {
                    left = left - coin;
                    numCoins++;
                } else {
                    i--;
                }
            }
            if (numCoins < minNumCoins && !notFound) {
                minNumCoins = numCoins;
            }
        }
        return minNumCoins;

    }


    //
    public static List<Integer> coinsWithValsDP(int target, List<Integer> coins, Map<Integer, List<Integer>> cache) {

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        if (target == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> sols = new ArrayList<>();
        for (Integer c : coins) {
            if (target >= c) {
                List<Integer> l = new ArrayList<>(coinsWithValsDP(target - c, coins, cache));
                l.add(c);
                sols.add(l);
            }
        }

        List<Integer> min = sols.stream().min(Comparator.comparingInt(List::size)).get();
        cache.put(target, min);
        return min;

    }
    
}
