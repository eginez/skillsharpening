package org.eginez;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Set10 {
    public static List<Integer> longestSubSeq(int[] numbers) {
        List<Integer> res = new ArrayList<>();
        List<Integer> seqLen = new ArrayList<>();
        longSubSeq(numbers, seqLen, res);
        int max = IntStream.range(0, seqLen.size())
                .boxed()
                .max(Comparator.comparingInt(seqLen::get)).get();
        List<Integer> s = new Stack<>();

        int pos = max;
        while(pos != -1) {
            s.add(numbers[pos]);
            pos = res.get(pos);
        }
        Collections.reverse(s);
        return s;
    }

    public static void longSubSeq(int[] numbers, List<Integer> partial, List<Integer> steps) {
        if(numbers.length == 0) {
            return;
        }

        if (numbers.length == 1) {
            steps.add(-1);
            partial.add(1);
            return;
        }

        int[] newNumbers = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length - 1);
        longSubSeq(newNumbers, partial, steps);

        int current = numbers[numbers.length - 1];
        Integer max  = IntStream.range(0, numbers.length)
                .boxed()
                .filter(i -> numbers[i] < current)
                .max(Comparator.comparingInt(partial::get)).orElse(null);


        int len;
        if (max == null) {
            len = 1;
            steps.add(-1);
        } else {
            len = partial.get(max) + 1;
            steps.add(max);
        }
        partial.add(len);
    }
}
