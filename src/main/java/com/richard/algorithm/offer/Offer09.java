package com.richard.algorithm.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yaoxs@shukun.net
 */
public class Offer09 {

    private final Deque<Integer> tempStack1;
    private final Deque<Integer> tempStack2;

    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    public Offer09() {
        tempStack1 = new LinkedList<>();
        tempStack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        tempStack1.push(value);
    }

    /**
     * 这里虽然是两个栈，但是并没有一直保持两个栈中的数据顺序是一致的，而是允许第二个栈保存之前待删除的数据记录，这样在第二个栈删除完后才会将第一个栈中数据再搬运到第二个栈，减少数据搬运过程，提高效率
     *
     * @return
     */
    public int deleteHead() {
        if(tempStack2.isEmpty()) {
            while(!tempStack1.isEmpty()) {
                tempStack2.push(tempStack1.pop());
            }
        }
        if(tempStack2.isEmpty()) {
            return -1;
        } else {
            return tempStack2.pop();
        }
    }
}
