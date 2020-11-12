package com.richard.algorithm.offer;

import lombok.Getter;

/**
 * @author yaoxs@shukun.net
 */
public class Offer06 {

    public static class ListNode {
        @Getter
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 循环创建单链表
     *
     * @param array
     * @return
     */
    public ListNode generateFromArray(int[] array) {
        if(array.length == 0) {
            return null;
        } else {
            Offer06.ListNode head = null, tail = null;
            for (int j : array) {
                if (head == null) {
                    head = new ListNode(j);
                    tail = head;
                } else {
                    ListNode newNode = new ListNode(j);
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            return head;
        }
    }

    public ListNode generateWithArrayRecursive(int[] array) {
        if(array.length == 0) {
            return null;
        }
        return generateRecursive(array, 0);
    }

    /**
     * 递归创建单链表
     *
     * @param array
     * @param index
     * @return
     */
    public ListNode generateRecursive(int[] array, int index) {
        if(index == array.length) {
            return null;
        }
        ListNode listNode = new ListNode(array[index]);
        listNode.next = generateRecursive(array, index + 1);
        return listNode;
    }

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
     * 0 <= 链表长度 <= 10000
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if(head == null) {
            return new int[0];
        }
        int[] result = new int[1];
        int index = 0;
        while(head != null) {
            if (index < 0) {
                int[] newArray = new int[result.length + 1];
                // 这里由于一直在进行内存的复制操作，导致效率很低，
                // 这里思路错了，虽然确实是少了一遍遍历，但是遍历一遍链表的内存操作很明显比复制数组要高效
                System.arraycopy(result, 0, newArray, 1, result.length);
                result = newArray;
                index = index + 1;
            }
            result[index--] = head.val;
            head = head.next;
        }
        return result;
    }

    /**
     * 从队尾遍历，直接赋值给数组，这个是效率最高的方式
     *
     * @param head
     * @return
     */
    public int[] reversePrintFastest(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (head!=null){
            length++;
            head = head.next;
        }
        int[] result = new int[length];
        for (int i = length-1;i >=0;i--) {
            result[i] = temp.val;
            temp = temp.next;
        }
        return result;
    }

    /**
     * 反转单链表, 循环处理
     *
     * @param node
     * @return
     */
    public ListNode reverseListNode(ListNode node) {
        ListNode before = null, next = null;
        while(node != null) {
            // 暂存node.next节点引用
            next = node.next;
            // node.next节点指向前置节点
            node.next = before;
            // before与next节点后移
            before = node;
            node = next;
        }
        return before;
    }

    /**
     * 反转单链表，递归处理
     *
     * @param node
     * @return
     */
    public ListNode reverseListNodeWithRecursive(ListNode node) {
        // 倘若当前节点是最后一个，返回
        if(node.next == null) {
            return node;
        }
        // 递归处理下一个节点
        ListNode newNode = reverseListNodeWithRecursive(node.next);
        // 当前节点的下一个节点的next指针指向当前节点，相当于节点指向反转
        node.next.next = node;
        // 当前节点的next指针重置
        node.next = null;
        // 返回包括node.next节点的新节点
        return newNode;
        // 代码运行时处理逻辑
        // 1 -> 2 -> 3, return 3
        // 3 -> 2, 2 -> null, return 3
        // 2 -> 1, 1 -> null, return 3
    }
}
