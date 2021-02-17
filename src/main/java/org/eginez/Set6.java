package org.eginez;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Set6 {
    public static int maxContiguous(List<Integer> nums, Map<List<Integer>, Integer> sols) {
        if (sols.containsKey(nums)) {
            return sols.get(nums);
        }

        if (nums.isEmpty()) {
            return 0;
        }

        Integer max = null;
        for (int i = 0; i < nums.size(); i++) {
            int current = nums.get(i);
            List<Integer> rest = nums.subList(i, nums.size());
            for(int j = 0; j < 2; j++) {
                if (rest.isEmpty()) {
                    break;
                }
                rest = rest.subList(1, rest.size());
            }

            int sum = current + maxContiguous(rest, sols);
            if (max == null || sum > max) {
                max = sum;
            }
        }
        sols.put(nums, max);
        return max;
    }

    public static boolean fullFilled(List<Integer> nums, Map<Integer,List<Integer>> deps) {;
        HashSet<Integer> cache = new HashSet<>();
        for(int n = 0; n < nums.size(); n++) {
           boolean doable = doable(n, new HashSet<>(), deps, cache);
           if (!doable) {
               return false;
           }
           cache.add(n);
        }
        return true;
    }

    public static boolean doable(int n, Set<Integer> seen, Map<Integer, List<Integer>> deps, Set<Integer> cache) {
        if( cache.contains(n)) {
            return true;
        }

        if (seen.contains(n)) {
            return false;
        }

        seen.add(n);
        if (!deps.containsKey(n))
            return true;

        for(Integer d : deps.get(n)) {
            boolean doable = doable(d, seen, deps, cache);
            if (!doable) {
                return false;
            }
        }
        return true;
    }

    public static int longestValidParentheses(String s) {

        Integer max = null;
        Map<String, Boolean> cache = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j <=s.length(); j++){
                String n = s.substring(i, j);
                if (isValid(n, cache) || max == null) {
                    max = n.length();
                }
            }
        }
        return max;

    }


    public static boolean isValid(String s, Map<String, Boolean> cache){
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        LinkedList<Character> l = new LinkedList();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                l.push('(');
            } else {
                l.pop();
            }
        }

        cache.put(s, l.isEmpty());
        return l.isEmpty();
    }


    public static int minPathSum(int[][] grid) {
        int [][]mins = new int[grid.length][grid[0].length];
        return helperPath(grid, grid[0].length-1, grid.length-1, mins);

    }

    public static int helperPath(int[][] grid, int row, int col, int[][] mins) {


        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (!isValidPos(row, col)) {
           return Integer.MAX_VALUE;
        }
        mins[row][col] = grid[row][col] + Math.min(
                helperPath(grid, row -1, col, mins),
                helperPath(grid, row, col-1,mins));

        return mins[row][col];

    }

    public static boolean isValidPos(int row, int col){
        return row >= 0 && col >= 0;
    }


    public static class Node {
        int val;
        int order;
        Node conn1;
        Node conn2;

        public Node(int val, int order) {
            this(val, order, null, null);
        }
        public Node(int val) {
            this(val, 0, null, null);
        }
        public Node(int val, int order, Node c1, Node c2) {
            this.val = val;
            this.order = order;
            this.conn1 = c1;
            this.conn2 = c2;
        }

        public int getVal() {
            return val;
        }

        public int getOrder() {
            return order;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    "order=" + order +
                    '}';
        }
    }

    public String printList(Node n, Set<Node> printed) {
        if (n == null) {
            return "";
        }
        if (printed.contains(n)) {
            return "";
        }

        return n.val +
                "->" +
                printList(n, printed) +
                printList(n, printed);
    }
    public Node copyList(Node head) {
        return copyListHelp(head, new HashMap<>());
    }

    public Node copyListHelp(Node node, Map<Node, Node> seen) {
        if (node == null) {
            return null;
        }

        if(seen.containsKey(node)) {
            return seen.get(node);
        }

        Node newNode = new Node(node.val);
        seen.put(node, newNode);
        newNode.conn1 = copyListHelp(node.conn1, seen);
        newNode.conn2 = copyListHelp(node.conn2, seen);
        return newNode;

    }

    public static void sortNodes(List<Node> nodes) {
        nodes.sort(Comparator.comparingInt(Node::getVal));
    }
}
