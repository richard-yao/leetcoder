package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer10_1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Offer10_1Test {

    @Test
    public void testCase() {
        Offer10_1 offer101 = new Offer10_1();
        Assertions.assertEquals(1, offer101.fib(2));
        Assertions.assertEquals(5, offer101.fib(5));
    }
}
