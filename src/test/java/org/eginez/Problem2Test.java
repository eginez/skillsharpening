package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Problem2Test {
    @Test
    public void testSimple() {
        Problem2.WordGraph g = new Problem2.WordGraph(Arrays.asList("dot", "hat", "hot"));
        Assertions.assertTrue(g.canXform("dog", "dot"));
        Assertions.assertTrue(g.canXform("dog", "hat"));
        Assertions.assertFalse(g.canXform("dog", "nn"));
        Assertions.assertFalse(g.canXform("dog", "nnn"));
        Assertions.assertTrue(g.canXform("dog", "pot"));
    }
}
