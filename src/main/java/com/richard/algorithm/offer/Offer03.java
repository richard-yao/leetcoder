package com.richard.algorithm.offer;

/**
 * @author yaoxs@shukun.net
 */
public class Offer03 {

    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 2 <= n <= 100000
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int[] values = new int[nums.length];
        for(int temp : nums) {
            // 将对应数字放在对应的数组index上，大于0则已经存在，认为重复了
            if(values[temp] == 0) {
                values[temp] = 1;
            } else {
                values[temp] = values[temp] + 1;
                return temp;
            }
        }
        return -1;
    }

    public int findRepeatNumberFastest(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i) {
                // 如果nums[i]和nums[nums[i]]已经存在，则已经找到重复的值了
                if(nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // nums[i]和nums[nums[i]]的值互换
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
