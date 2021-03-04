package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem4Test {
    @Test
    public void test2() {
        int sol = Problem4.coinsCount(31, Arrays.asList(1, 10, 25), new HashMap<>());
        Assertions.assertEquals(4, sol);

        sol = Problem4.coinsCount(33, Arrays.asList(1, 10, 25), new HashMap<>());
        Assertions.assertEquals(6, sol);
    }
}
