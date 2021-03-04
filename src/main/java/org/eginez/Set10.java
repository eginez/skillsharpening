package org.eginez;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Set10 {
    public static List<Integer> longestSubSeq(int[] numbers) {
        List<Integer> res = new ArrayList<>();
        List<Integer> seqLen = new ArrayList<>();
        longSubSeq(numbers, seqLen, res);
        int max = IntStream.range(0, seqLen.size())
                .boxed()
                .max(Comparator.comparingInt(seqLen::get)).get();
        List<Integer> s = new Stack<>();

        int pos = max;
        while (pos != -1) {
            s.add(numbers[pos]);
            pos = res.get(pos);
        }
        Collections.reverse(s);
        return s;
    }

    public static void longSubSeq(int[] numbers, List<Integer> partial, List<Integer> steps) {
        if (numbers.length == 0) {
            return;
        }

        if (numbers.length == 1) {
            steps.add(-1);
            partial.add(1);
            return;
        }

        int[] newNumbers = new int[numbers.length - 1];
        System.arraycopy(numbers, 0, newNumbers, 0, numbers.length - 1);
        longSubSeq(newNumbers, partial, steps);

        int current = numbers[numbers.length - 1];
        Integer max = IntStream.range(0, numbers.length)
                .boxed()
                .filter(i -> numbers[i] < current)
                .max(Comparator.comparingInt(partial::get)).orElse(null);


        int len;
        if (max == null) {
            len = 1;
            steps.add(-1);
        } else {
            len = partial.get(max) + 1;
            steps.add(max);
        }
        partial.add(len);
    }

    public static boolean targetSubSet(int[] numbers, int target, Map<int[], Boolean> cache) {
        if (cache.containsKey(numbers)) {
            return cache.get(numbers);
        }

        if (numbers.length == 0) {
            return target == 0;
        }

        List<Integer> lnumbers = IntStream.of(numbers).boxed().collect(Collectors.toList());
        int[] rest = lnumbers.subList(1, lnumbers.size()).stream().mapToInt(Integer::intValue).toArray();
        int head = lnumbers.get(0);
        boolean res;
        if (head < target) {
            res = targetSubSet(rest, target, cache);
        } else {
            res = targetSubSet(rest, target - head, cache) || targetSubSet(rest, target, cache);
        }
        cache.put(numbers, res);
        return res;
    }


    public static class Node {
        final int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }

        public void connectLeft(Node n) {
            this.left = n;
        }

        public void connectRight(Node n) {
            this.right = n;
        }
    }

    public static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        //Left, Root, Right
        public List<Integer> inOrder(Node n) {
            if (n == null) {
                return new ArrayList<Integer>();
            }

            List<Integer> all = inOrder(n.left);
            all.add(n.val);
            all.addAll(inOrder(n.right));
            return all;
        }

        public List<Integer> preOrder(Node n) {
            if (n == null) {
                return Collections.emptyList();
            }

            List<Integer> all = new ArrayList<>();
            all.add(n.val);
            all.addAll(preOrder(n.left));
            all.addAll(preOrder(n.right));

            return all;
        }

        public int findPosOf(int val, List<Integer> list) {
            return IntStream.range(0, list.size())
                    .filter(i -> val == list.get(i))
                    .findFirst()
                    .orElse(-1);
        }

        public Node decode(List<Integer> inOrderList, List<Integer> preOrderList) {
            //validate input indoer, preoder;
            if (preOrderList.size() == 0) {
                return null;
            }

            int rootVal = preOrderList.get(0);
            Node root = new Node(rootVal);


            int posRootVal = findPosOf(rootVal, inOrderList);

            if (posRootVal == -1) {
                return decode(inOrderList, preOrderList.subList(1, preOrderList.size()));
            }


            List<Integer> leftOf = inOrderList.subList(0, posRootVal);
            List<Integer> rightOf = inOrderList.subList(Math.min(posRootVal + 1, inOrderList.size()), inOrderList.size());
            List<Integer> restPreOrder = preOrderList.subList(1, preOrderList.size());

            root.left = decode(leftOf, restPreOrder);
            root.right = decode(rightOf, restPreOrder);

            return root;
        }

    }

}
