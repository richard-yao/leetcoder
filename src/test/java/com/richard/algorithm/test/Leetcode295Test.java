package com.richard.algorithm.test;

import com.richard.algorithm.Leetcode295;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode295Test {

    @Test
    public void testCase() {
        Leetcode295 leetcode295 = new Leetcode295();
        leetcode295.addNum(6);
        Assertions.assertEquals(6, leetcode295.findMedian());
        leetcode295.addNum(10);
        Assertions.assertEquals(8, leetcode295.findMedian());
        leetcode295.addNum(2);
        Assertions.assertEquals(6, leetcode295.findMedian());
        leetcode295.addNum(6);
        Assertions.assertEquals(6, leetcode295.findMedian());
        leetcode295.addNum(5);
        Assertions.assertEquals(6, leetcode295.findMedian());
        leetcode295.addNum(0);
        Assertions.assertEquals(5.5, leetcode295.findMedian());
    }
}
