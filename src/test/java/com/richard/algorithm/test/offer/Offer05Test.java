package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer05;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Offer05Test {

    @Test
    public void testCase() {
        Offer05 offer05 = new Offer05();
        Assertions.assertEquals("We%20are%20happy.", offer05.replaceSpace("We are happy."));
    }
}
