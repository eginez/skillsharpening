package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Set5Test {
    @Test
    public void testPalindromeString() {
        //Assertions.assertEquals("aba", Set5.longPalindrome("aba"));
        Assertions.assertEquals("aba", Set5.longPalindrome("11aba22"));
        Assertions.assertEquals("2002", Set5.longPalindrome("11aba2002332"));
    }


    @Test
    public void testRotation() {
        int[][] matrix = {{1, 2}, {3, 4}};
        int[][] res = {{3, 1}, {4, 2}};
        Set5.rotate(matrix);
        Assertions.assertArrayEquals(res, matrix);

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        res = new int[][]{{7,4,1},{8,5,2},{9,6,3}};
        Set5.rotate(matrix);
        Assertions.assertArrayEquals(res, matrix);


        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9,10,11,12}, {13,14,15,16,17}};
        Set5.rotate(matrix);
        Assertions.assertArrayEquals(new int[]{14,10,6,2}, matrix[1]);
    }

    @Test
    public void testGrouping() {
        List<List<String>> res = Set5.sortAnagrams(new String[]{"tea", "ate"});
        Assertions.assertEquals(res.size(), 1);

        res = Set5.sortAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        Assertions.assertEquals(3, res.size());
        System.out.println(res);
    }

    @Test
    public void testmaxSubArray() {
        int sum = Set5.maxSubArray(new int[]{-2, 1, -3});
        Assertions.assertEquals(1, sum);

        sum = Set5.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        Assertions.assertEquals(6, sum);

        sum = Set5.maxSubArray(new int[]{8,-19,5,-4,20});
        Assertions.assertEquals(21, sum);
    }

    @Test
    public void testSpiral() {
        List<Integer> res = null;
        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        //List<Integer> res = Set5.spiral(mat);
        //Assertions.assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]", res.toString());

        mat = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //res = Set5.spiral(mat);
        //Assertions.assertEquals("[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]", res.toString());

        mat = new int[][]{{1,2,3}};
        res = Set5.spiral(mat);
        Assertions.assertEquals("[1,2,3]", res.toString());
        System.out.println(res);

    }
}
