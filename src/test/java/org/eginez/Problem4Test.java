package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem4Test {
    @Test
    public void testWithCoins() {
        Assertions.assertEquals(2, Problem4.coinNum(6));
        Assertions.assertEquals(3, Problem4.coinNum(27));
        Assertions.assertEquals(3, Problem4.coinNum(31));
    }
    @Test
    public void testWithValues() {
        List<Integer> sol = Problem4.coinsWithValsDP(31, Arrays.asList(1, 10, 25), new HashMap<>());
        Assertions.assertEquals(Arrays.asList(10, 10, 10, 1), sol);

        sol = Problem4.coinsWithValsDP(33, Arrays.asList(1, 10, 25), new HashMap<>());
        Assertions.assertEquals(Arrays.asList(10, 10, 10, 1, 1, 1), sol);
    }
}
