package com.richard.algorithm.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode295 {

    /**
     * 自定义数组来实现相关操作
     */
    private int[] objects;
    private int index = 0;

    /**
     * 大根堆, 根节点最大，从头取元素组成倒序排列
     */
    private PriorityQueue<Integer> maxHeap;
    /**
     * 小根堆，根节点最小，从头取元素组成升序排列
     */
    private PriorityQueue<Integer> minHeap;
    /**
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     */
    public Leetcode295() {
        // objects = new int[2];
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        int size1 = maxHeap.size();
        int size2 = minHeap.size();
        // 平衡大根堆与小根堆的数量保持在差1的情况
        if(size1 - size2 > 1) {
            // 将大根堆的最大值加入小根堆中，这样小根堆中是交大值的部分，堆顶是交大值部分的最小值
            minHeap.offer(maxHeap.poll());
        }
        if(size2 - size1 > 1) {
            // 将小根堆的最小值加入到大根堆中，这样大根堆中是较小部分，堆顶是较小值部分的最大值
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int size1 = maxHeap.size();
        int size2 = minHeap.size();
        if (size1 == size2) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else if (size1 < size2) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }

    public void addNumBackup(int num) {
        // 数组满了，扩容
        if(index >= objects.length) {
            int[] newObjects = new int[objects.length << 1];
            System.arraycopy(objects, 0, newObjects, 0, index);
            objects = newObjects;
        }
        if(index == 0) {
            objects[0] = num;
        } else {
            insertNumToArray(num, objects);
        }
        index++;
    }

    /**
     * 将指定数字插入到有序数组中
     *
     * @param num
     * @param objects
     */
    private void insertNumToArray(int num, int[] objects) {
        int start = 0, end = index - 1;
        if(num <= objects[start]) {
            System.arraycopy(objects, 0, objects, 1, index);
            objects[0] = num;
        } else if(num >= objects[end]) {
            objects[end + 1] = num;
        } else {
            while(start < end) {
                int mid = start + (end - start) >> 1;
                if(objects[mid] == num) {
                    System.arraycopy(objects, mid, objects, mid + 1, end - mid + 1);
                    objects[mid] = num;
                    break;
                } else if(objects[mid] < num) {
                    if(objects[mid + 1] > num) {
                        System.arraycopy(objects, mid + 1, objects, mid + 2, end - mid);
                        objects[mid + 1] = num;
                        break;
                    } else {
                        start = mid + 1;
                    }
                } else if(objects[mid] > num) {
                    if(objects[mid - 1] < num) {
                        System.arraycopy(objects, mid, objects, mid + 1, end - mid + 1);
                        objects[mid] = num;
                        break;
                    } else {
                        end = mid - 1;
                    }
                }
            }
        }
    }

    public double findMedianBackup() {
        int mid = (index - 1) / 2;
        if(index % 2 == 0) {
            return (objects[mid] + objects[mid + 1]) / 2.0;
        } else {
            return objects[mid];
        }
    }
}
