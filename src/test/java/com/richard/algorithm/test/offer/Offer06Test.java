package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer06;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Offer06Test {

    @Test
    public void testCase() {
        Offer06 offer06 = new Offer06();
        Offer06.ListNode listNode = offer06.generateFromArray(new int[]{1, 3, 2});
        Assertions.assertArrayEquals(new int[]{2, 3, 1}, offer06.reversePrint(listNode));
    }
}
