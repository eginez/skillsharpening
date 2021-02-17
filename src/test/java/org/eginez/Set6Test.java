package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Set6Test {
    @Test
    public void test() {
        int max = 0;
        max = Set6.maxContiguous(Arrays.asList(1,3), new HashMap<>());
        Assertions.assertEquals(3, max);

        max = Set6.maxContiguous(Arrays.asList(1,3,5,1), new HashMap<>());
        Assertions.assertEquals(6, max);
    }

    @Test
    public void testminPath() {
        int res;
        res = Set6.minPathSum(new int[][]{{1,0},{1,2}});
    }

    @Test
    public void testSort() {
        List<Set6.Node> nodes = Arrays.asList(
                new Set6.Node(2, 2),
                new Set6.Node(2, 1));
        System.out.println(nodes);
        nodes.sort(Comparator.comparingInt(Set6.Node::getVal)
                .thenComparingInt(Set6.Node::getOrder));
        System.out.println(nodes);
    }

}
