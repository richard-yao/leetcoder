package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer12;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Offer12Test {

    @Test
    public void testCase() {
        Offer12 offer12 = new Offer12();
        Assertions.assertEquals(1, offer12.numWays(0));
        Assertions.assertEquals(2, offer12.numWays(2));
        Assertions.assertEquals(21, offer12.numWays(7));
    }
}
