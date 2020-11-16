package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer11;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Offer11Test {

    @Test
    public void testCase() {
        Offer11 offer11 = new Offer11();
        Assertions.assertEquals(1, offer11.minArray(new int[]{3,4,5,1,2}));
        Assertions.assertEquals(0, offer11.minArray(new int[]{2,2,2,0,1}));
        Assertions.assertEquals(1, offer11.minArray(new int[]{3,1}));
        Assertions.assertEquals(1, offer11.minArray(new int[]{1,1}));
    }
}
