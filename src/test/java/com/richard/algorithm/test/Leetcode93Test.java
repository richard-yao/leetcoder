package com.richard.algorithm.test;

import com.richard.algorithm.Leetcode93;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode93Test {

    @Test
    public void testCase() {
        Leetcode93 leetcode93 = new Leetcode93();
        Assertions.assertArrayEquals(new String[]{"255.255.11.135", "255.255.111.35"}, leetcode93.restoreIpAddresses("25525511135").toArray());
        Assertions.assertArrayEquals(new String[]{"0.10.0.10", "0.100.1.0"}, leetcode93.restoreIpAddresses("010010").toArray());
    }
}
