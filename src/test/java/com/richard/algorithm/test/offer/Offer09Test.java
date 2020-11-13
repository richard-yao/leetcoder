package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer09;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Offer09Test {

    @Test
    public void testCase() {
        Offer09 offer09 = new Offer09();
        Assertions.assertEquals(-1, offer09.deleteHead());
        offer09.appendTail(5);
        offer09.appendTail(2);
        Assertions.assertEquals(5, offer09.deleteHead());
        Assertions.assertEquals(2, offer09.deleteHead());
    }
}
