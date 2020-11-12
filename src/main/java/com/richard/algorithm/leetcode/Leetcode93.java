package com.richard.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yaoxs@shukun.net
 */
public class Leetcode93 {

    private static final int SEG_COUNT = 4;
    private final List<String> ans = new ArrayList<>();

    /**
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        ans.clear();
        dfs(s, 0, 0, new int[SEG_COUNT]);
        return ans;
    }

    /**
     * 对给定的ip进行字符串拆分，回溯的终止条件是seg数量到达4
     *
     * @param ip 原始的字符串，虽然是分割问题，但是原始字符串得要传输进来以保证作为终止条件的长度判断可以正常处理
     * @param segId
     * @param segStart
     * @param segments 记录实际拆分的多段ip部分
     */
    private void dfs(String ip, int segId, int segStart, int[] segments) {
        // 当段数达标，并且字符串已经全部被遍历到，则该组合是合法的
        if(segId == SEG_COUNT) {
            if(segStart == ip.length()) {
                // 拼接数字数组为ip字符串
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < segments.length - 1; i++) {
                    sb.append(segments[i]).append(".");
                }
                sb.append(segments[segments.length - 1]);
                ans.add(sb.toString());
            }
            return;
        }
        // 遍历完但是不符合4段要求
        if(segStart == ip.length()) {
            return;
        }
        // 由于在ip地址中不能有0开头的数字，只能是0本身，这里做特殊处理
        if(ip.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(ip, segId + 1, segStart + 1, segments);
        }
        // 常规情况，处理每段数字
        int addr = 0;
        for(int segEnd = segStart; segEnd < ip.length(); segEnd++) {
            // 将字符转化为数字用于判断ip分割是否合法
            addr = addr * 10 + (ip.charAt(segEnd) - '0');
            if(addr > 0 && addr <= 0xff) {
                segments[segId] = addr;
                dfs(ip, segId + 1, segEnd + 1, segments);
            } else {
                // 但凡有一段不满足条件，则整个回溯需要返回到上一层继续处理
                break;
            }
        }
    }
}
