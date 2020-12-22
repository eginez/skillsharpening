package org.eginez;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Problem3Test {
    @Test
    public void testLongest() {
        Assertions.assertEquals("GTAB", Problem3.longestSubSeq("AGGTAB", "GTAB"));
        Assertions.assertEquals("AB", Problem3.longestSubSeq("ADDDDDB", "AB"));
        Assertions.assertEquals("aa", Problem3.longestSubSeq("aaaa", "aa"));
        Assertions.assertEquals("ABBA", Problem3.longestSubSeq("ABBA", "ABCABA"));
    }
}
