package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Set5Test {
    @Test
    public void testPalindromeString() {
        //Assertions.assertEquals("aba", Set5.longPalindrome("aba"));
        Assertions.assertEquals("aba", Set5.longPalindrome("11aba22"));
        Assertions.assertEquals("2002", Set5.longPalindrome("11aba2002332"));
    }
}
