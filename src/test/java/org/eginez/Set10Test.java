package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static org.eginez.Set10.*;

public class Set10Test {
    @Test
    public void testLq() {
        List<Integer> lst;
        lst = Set10.longestSubSeq(new int[]{1,4,1,2,3,5});
        Assertions.assertEquals(Arrays.asList(1,2,3,5), lst);

        lst = Set10.longestSubSeq(new int[]{5,1,7,2,9});
        Assertions.assertEquals(Arrays.asList(5, 7, 9), lst);
    }


    @Test
    public void targetSubSet() {
        boolean res;
        res = Set10.targetSubSet(new int[]{1,2,3}, 5, new HashMap<>());
        Assertions.assertTrue(res);
    }

    @Test
    public void treeTraversals() {
        Set10.Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        Node rr = new Node(4);
        Node ll = new Node(5);
        root.connectLeft(left);
        root.connectRight(right);
        left.connectRight(rr);
        right.connectLeft(ll);
        Tree t = new Tree(root);

        List<Integer> inOrder = t.inOrder(t.root);
        List<Integer> preOrder = t.preOrder(t.root);
        Node n = t.decode(inOrder, preOrder);

        List<Integer> dec = new Tree(n).inOrder(n);
        Assertions.assertEquals(inOrder, dec);
    }


}
