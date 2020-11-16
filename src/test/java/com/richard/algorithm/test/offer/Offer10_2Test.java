package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer10_2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Offer10_2Test {

    @Test
    public void testCase() {
        Offer10_2 offer102 = new Offer10_2();
        Assertions.assertEquals(1, offer102.numWays(0));
        Assertions.assertEquals(2, offer102.numWays(2));
        Assertions.assertEquals(21, offer102.numWays(7));
    }
}
