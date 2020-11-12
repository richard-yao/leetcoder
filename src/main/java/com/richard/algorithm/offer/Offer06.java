package com.richard.algorithm.offer;

/**
 * @author yaoxs@shukun.net
 */
public class Offer06 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

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
     * 从队尾遍历，直接赋值给数组
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
}
