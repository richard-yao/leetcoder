package com.richard.algorithm.offer;

/**
 * @author yaoxs@shukun.net
 */
public class Offer05 {

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
     * 0 <= s 的长度 <= 10000
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder newString = new StringBuilder();
        char temp;
        for(int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if(temp != ' ') {
                newString.append(temp);
            } else {
                newString.append("%20");
            }
        }
        return newString.toString();
    }
}
