package com.richard.algorithm.test;

import com.richard.algorithm.Leetcode953;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author YaoXiansheng
 * @date 2020/11/9 22:21
 */
public class Leetcode953Test {

    @Test
    public void testCase() {
        Leetcode953 code = new Leetcode953();
        Assertions.assertTrue(code.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Assertions.assertFalse(code.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
    }
}
