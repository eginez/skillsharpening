package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Set10Test {
    @Test
    public void testLq() {
        List<Integer> lst;
        lst = Set10.longestSubSeq(new int[]{1,4,1,2,3,5});
        Assertions.assertEquals(Arrays.asList(1,2,3,5), lst);

        lst = Set10.longestSubSeq(new int[]{5,1,7,2,9});
        Assertions.assertEquals(Arrays.asList(5, 7, 9), lst);
    }
}
