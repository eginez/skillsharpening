package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Problem4Test {
    @Test
    public void testWithCoins() {
        Assertions.assertEquals(2, Problem4.coinNum(6));
        Assertions.assertEquals(3, Problem4.coinNum(27));
        Assertions.assertEquals(3, Problem4.coinNum(31));
    }
    @Test
    public void testWithValues() {
//        Assertions.assertEquals(2, Problem4.coinsWithVals(6, Arrays.asList(
//                1, 5
//        )));
//        Assertions.assertEquals(4, Problem4.coinsWithVals(13, Arrays.asList(
//                1, 5, 10
//        )));
//
        Assertions.assertEquals(4, Problem4.coinsWithVals(31, Arrays.asList(
                1, 10, 25
        )));
        Assertions.assertEquals(4, Problem4.coinsWithVals(70, Arrays.asList(
                1, 10, 25
        )));
//
//        Assertions.assertThrows(RuntimeException.class, () -> {
//            Problem4.coinsWithVals(11, Arrays.asList(
//                    5, 10
//            ));
//        });
    }
}
