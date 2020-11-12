package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer03;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Offer03Test {

    @Test
    public void testCase() {
        Offer03 offer03 = new Offer03();
        Assertions.assertEquals(2, offer03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
