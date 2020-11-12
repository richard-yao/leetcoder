package com.richard.algorithm.test.leetcode;

import com.richard.algorithm.leetcode.Leetcode1218;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode1218Test {

    @Test
    public void testCase() {
        Leetcode1218 leetcode1218 = new Leetcode1218();
        Assertions.assertEquals(4, leetcode1218.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        Assertions.assertEquals(1, leetcode1218.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        Assertions.assertEquals(4, leetcode1218.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
    }
}
