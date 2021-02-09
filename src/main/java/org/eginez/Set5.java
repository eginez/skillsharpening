package org.eginez;

import java.util.*;

public class Set5 {
    public static String longPalindrome(String s) {
        HashMap<String, String> cache = new HashMap<>();
        // The dynamic p = P(i,j)  P(i+1, j -1) and S[i] == S[j]
        Set<String> res = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            res.add(longPalHelp(s.substring(i), cache));
        }
        return res.stream().max(Comparator.comparing(String::length)).get();
    }

    public static String longPalHelp(String s, Map<String,String> cache) {
        if (cache.containsKey(s)) {
            System.out.println("hitting cache");
            return cache.get(s);
        }

        if (s.length() == 1){
            return s;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1))
                return s;
            else
                return "";
        }

        String pal = longPalHelp(s.substring(1, s.length() -1), cache);
        if (s.charAt(0) == s.charAt(s.length() - 1)){
             pal = s.charAt(0) + pal + s.charAt(0);
        }
        cache.put(s, pal);
        return pal;
    }


    public static void rotate(int[][] matrix) {
        int right;
        int left;
        right = matrix.length - 1;
        left = 0;

        while (left < right) {
            for (int i = 0; i < (right - left); i++) {
                int top = left;
                int bottom = right;

                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            left++;
            right--;
        }
    }

    public static List<List<String>> sortAnagrams(String[] words) {
        Map<String, List<String>> res = new HashMap<>();
        for(String w : words) {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (res.containsKey(sorted)) {
                res.get(sorted).add(w);
            } else {
                List<String> group = new ArrayList<>();
                group.add(w);
                res.put(sorted, group);
            }
        }
        return new ArrayList<>(res.values());
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = nums[0];
        for (int num: nums) {
            if (sum < 0) {
                sum = 0;
            }
            sum += num;
            max = Math.max(sum, max);

        }
        return max;
    }

    public static List<Integer> spiral(int[][] matrix) {
        return spiralHelper(matrix, 0,0, matrix[0].length, matrix.length);
    }

    public static List<Integer> spiralHelper(int[][] matrix, int start_row, int start_col, int width, int height) {
       //Add first col
        if (width <= 0 || height <= 0) {
            return Collections.emptyList();
        }
        if (width == 1 && height == 1) {
            return Collections.singletonList(matrix[start_row][start_col]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < width - 1; i++){
            res.add(matrix[start_row][start_col+i]);
        }
        for (int i = 0; i < height -1; i++){
            res.add(matrix[start_row+i][start_col+width-1]);
        }

        for(int i = width - 1; i >= 1; i--) {
            res.add(matrix[start_row+height - 1][start_col+i]);
        }

        for(int i = height - 1; i >= 1; i-- ){
            res.add(matrix[start_row+i][start_col]);
        }
        List<Integer> rest = spiralHelper(matrix, start_row + 1, start_col + 1, width - 2, height - 2);
        res.addAll(rest);

        return res;
    }


    public boolean findDups(int[] nums) {
        Set<Integer> all = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
           if (all.contains(i)){
               return true;
           }
           all.add(i);
        }
        return false;
    }


    static class Node {
        int val;
        List<Node> neighbors;

        public Node() {
            this(0, new ArrayList<>());
        }
        public Node(int val) {
            this(val, new ArrayList<>());
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    static Map<Node, Node> seen = new HashMap<>();
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (seen.containsKey(node)) {
            return seen.get(node);
        }

        Node newNode = new Node(node.val);
        seen.put(node, newNode);

        for(Node n : node.neighbors) {
            Node newNei = cloneGraph(n);
            newNode.neighbors.add(newNei);
        }

        return newNode;
    }

}
