package org.eginez;

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
}
