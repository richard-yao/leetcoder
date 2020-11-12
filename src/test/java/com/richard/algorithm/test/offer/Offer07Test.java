package com.richard.algorithm.test.offer;

import com.richard.algorithm.offer.Offer07;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author yaoxs@shukun.net
 */
public class Offer07Test {

    @Test
    public void testCase() {
        Offer07 offer07 = new Offer07();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        Offer07.TreeNode node = offer07.buildTree(preorder, inorder);
        Assertions.assertEquals(3, node.getVal());
    }
}
