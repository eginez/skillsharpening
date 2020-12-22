package org.eginez;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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


    // Try this again with Dynamic Programming.
    
}
