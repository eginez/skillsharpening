package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import static org.eginez.Set11.*;

import static org.eginez.Set11.matches;

public class Set11Test {
    @Test
    public void testRegex() {
        Assertions.assertTrue(matches("ab", "ab"));
        Assertions.assertTrue(matches("?", ""));
        Assertions.assertTrue(matches("ab?", "ab"));
        Assertions.assertTrue(matches("a?", ""));
        Assertions.assertTrue(matches("a?b?c", "c"));
    }


    @Test
    public void testSkyLine() {
        List<Set11.Rectangle> rs = Arrays.asList(
                new Set11.Rectangle(new Set11.Point(0,0), 2,2),
                new Set11.Rectangle(new Set11.Point(1,0), 2,2)
        );

        System.out.println(Set11.skyline(rs));

        rs = Arrays.asList(
                new Rectangle(new Point(0,0), 2,2),
                new Rectangle(new Point(1,0), 3,3)
        );

        System.out.println(skyline(rs));
    }
}
