package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class Set6Test {
    @Test
    public void test() {
        int max = 0;
        max = Set6.maxContiguous(Arrays.asList(1,3), new HashMap<>());
        Assertions.assertEquals(3, max);

        max = Set6.maxContiguous(Arrays.asList(1,3,5,1), new HashMap<>());
        Assertions.assertEquals(6, max);
    }
}
