package com.richard.algorithm.test;

import com.richard.algorithm.Leetcode131;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode131Test {

    @Test
    public void testCase() {
        Leetcode131 leetcode131 = new Leetcode131();
        List<List<String>> result = leetcode131.partition("aab");
        Assertions.assertArrayEquals(new String[]{"aa", "b"}, result.get(1).toArray());
        Assertions.assertArrayEquals(new String[]{"a", "a", "b"}, result.get(0).toArray());
    }
}
