package com.richard.algorithm.offer;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaoxs@shukun.net
 */
public class Offer07 {

    public static class TreeNode {
        @Getter
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static Map<Integer, Integer> cacheMap;

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 0 <= 节点个数 <= 5000
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 整颗树的递归开始的时候，开始节点为0，length - 1
        cacheMap = new HashMap<>(inorder.length);
        for(int i = 0; i < inorder.length; i++) {
            cacheMap.put(inorder[i], i);
        }
        return buildTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeNode(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int startIdx, int endIdx) {
        if(preorderStart > preorderEnd) {
            return null;
        }
        // 先序遍历的数组中首字符即为子树根节点
        int rootVal = preorder[preorderStart];
        TreeNode treeNode = new TreeNode(rootVal);
        if (preorderStart != preorderEnd) {
            // 获取到根节点在中序遍历中的位置， 则位置左边为左子树，右边为右子树
            int rootIdxInorder = cacheMap.get(rootVal);
            // 根据中序遍历获取到左边子树的数量：rootIdxInorder - startIdx, 右边子树的数量：endIdx - rootIdxInorder
            int leftNodes = rootIdxInorder - startIdx, rightNodes = endIdx - rootIdxInorder;
            // 左子树的先序遍历范围：[preorderStart + 1, preorderStart + leftNodes], 中序遍历范围：[startIdx, rootIdxInorder - 1]
            treeNode.left = buildTreeNode(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, startIdx, rootIdxInorder - 1);
            // 右子树的先序遍历范围：[preorderEnd - rightNodes + 1, preorderEnd], 中序遍历范围：[rootIdxInorder + 1, endIdx]
            treeNode.right = buildTreeNode(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIdxInorder + 1, endIdx);
        }
        return treeNode;
    }

    /**
     * 找出根节点在中序遍历的位置
     *
     * @param rootVal
     * @param inorder
     * @return
     */
    private int findIdxInOrder(int rootVal, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            if(rootVal == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
