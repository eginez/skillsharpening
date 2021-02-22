package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Set8Test {
    @Test
    public void testOne() {
        List<Set8.Range> inp = new ArrayList<>();
        List<Set8.Range> sol = null;
        inp = Arrays.asList(new Set8.Range(2, 3), new Set8.Range(1, 3), new Set8.Range(1,4), new Set8.Range(4,6));
        sol = Set8.rangeWorkout(inp);
        System.out.println(sol);
    }

    @Test
    public void testShuffle() {
        List<Integer> shuffled = null;
        for(int i = 0; i < 4; i++) {
            shuffled = Set8.shuffle(Arrays.asList(1, 2, 3, 4));
            System.out.println(shuffled);
        }
    }

    @Test
    public void testCache() {
        Set8.Cache cache = new Set8.Cache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assertions.assertTrue(cache.containsKey(1));
        cache.put(3, 3);
        Assertions.assertFalse(cache.containsKey(1));
        cache.put(4, 4);
        Assertions.assertFalse(cache.containsKey(2));
        cache.get(3);
        Assertions.assertTrue(cache.containsKey(4));
        cache.put(5, 5);
        Assertions.assertFalse(cache.containsKey(4));
        System.out.println(cache);
    }
}
