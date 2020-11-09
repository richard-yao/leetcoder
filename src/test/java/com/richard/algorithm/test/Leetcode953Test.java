package com.richard.algorithm.test;

import com.richard.algorithm.Leetcode953;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author YaoXiansheng
 * @date 2020/11/9 22:21
 */
public class Leetcode953Test {

    @Test
    public void testCase() {
        Leetcode953 code = new Leetcode953();
        Assert.assertTrue(code.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        Assert.assertFalse(code.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
    }
}
