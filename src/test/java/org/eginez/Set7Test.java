package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class Set7Test {
    @Test
    public void minMul() {
        int prod = 0;
        prod = Set7.maxProduct(new int[]{2,3,-2,4});
        Assertions.assertEquals(6,prod);

        prod = Set7.maxProduct(new int[]{7,-2,-4});
        Assertions.assertEquals(56,prod);

    }
}
