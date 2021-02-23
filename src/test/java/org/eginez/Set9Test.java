package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

public class Set9Test {
    @Test
    public void testRate() throws Exception {
        Set9.RateLimiter rateLimiter = new Set9.RateLimiter(1);
        boolean check = true;
        int i;
        for (i = 0; i < 3; i++) {
           check = check && rateLimiter.addAndCheckCall("1");
           Thread.sleep(1000);
        }

        Assertions.assertEquals(3, i);
        Assertions.assertTrue(check);
    }

    @Test
    public void testRateFails() throws Exception {
        Set9.RateLimiter rateLimiter = new Set9.RateLimiter(1);
        boolean check = true;
        int i;
        for (i = 0; i < 3; i++) {
            check = check && rateLimiter.addAndCheckCall("1");
            if(!check) {
                break;
            }
            Thread.sleep(100);
        }
        Assertions.assertEquals(1, i);
        Assertions.assertFalse(check);
    }

    @Test
    public void testRateMix() throws  Exception {
        Set9.RateLimiter rateLimiter = new Set9.RateLimiter(1);
        int sleepTime = 500;
        List<Integer> success, failure;
        success = new ArrayList<>();
        failure = new ArrayList<>();
        for (int i =0 ; i < 3; i++) {
            if (rateLimiter.addAndCheckCall("1")){
                success.add(i);
            } else {
                sleepTime += 1000;
                failure.add(i);
            }
            Thread.sleep(sleepTime);
        }

        Assertions.assertEquals(Arrays.asList(0,2), success);
        Assertions.assertEquals(Arrays.asList(1), failure);
    }
}
