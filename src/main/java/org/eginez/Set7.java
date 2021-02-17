package org.eginez;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Set7 {
    static void findTarget(double target, Map<String, Double> items, List<String> picked) {
        if (target == 0) {
            System.out.println(picked);
        }

        if (target < 0) {
            return;
        }

        for (String item : items.keySet()){
            double price = items.get(item);
            Map<String, Double> newItems = new HashMap<>(items);
            newItems.remove(item);
            int times = 1;
            List<String> newList = new ArrayList<String>(picked);
            while(target - (price * times) >= 0){
                newList.add(item);
                findTarget(target - (price * times), newItems, newList);
                times++;
            }
        }

    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return wordBreakHelper(s, dict, new HashMap<String, Boolean>());
    }

    public static boolean wordBreakHelper(String rest, Set<String> dict, Map<String, Boolean> cache){

        if (cache.containsKey(rest)){
            return cache.get(rest);
        }

        if(rest.isEmpty()){
            return false;
        }

        boolean canBreak = false;
        for(int i = 0; i < rest.length(); i++) {
            String left = rest.substring(0, i);
            if (dict.contains(left) && wordBreakHelper(rest.substring(i), dict, cache)) {
                canBreak = true;
               break;
            }
        }

        cache.put(rest, canBreak);
        return canBreak;
    }

    public static int maxProduct(int[] nums){
        int max = 1;
        int min = 1;

        if (nums.length == 0) {
            return 0;
        }

        int res = IntStream.of(nums).max().getAsInt();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = 1;
                min = 1;
                continue;
            }

            int tempMax = max;
            max = Arrays.asList(max * nums[i], min * nums[i], nums[i] ).stream().max(Integer::compareTo).get();
            min = Arrays.asList(tempMax * nums[i], min * nums[i], nums[i]).stream().min(Integer::compareTo).get();

            res = Math.max(res, max);
        }
        return res;

    }

}

