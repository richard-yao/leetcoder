package com.richard.algorithm;

/**
 * @author YaoXiansheng
 */
public class Leetcode953 {

    /**
     * 判断给定的单词是否按照给定的order中字母序进行排序
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) {
            return true;
        }
        for(int i = 0; i < words.length - 1; i++) {
            if(!compareWords(words[i], words[i+1], order)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断词汇顺序是否一致
     *
     * @param word1
     * @param word2
     * @param order
     * @return
     */
    private boolean compareWords(String word1, String word2, String order) {
        int i = 0, j = 0;
        while(i < word1.length() && j < word2.length()) {
            char word1Char = word1.charAt(i);
            char word2Char = word2.charAt(j);
            int realIdxWord1 = order.indexOf(word1Char);
            int realIdxWord2 = order.indexOf(word2Char);
            if(realIdxWord1 == realIdxWord2) {
                i++;
                j++;
            } else {
                return realIdxWord1 < realIdxWord2;
            }
        }
        // 如果i有剩余部分，j计算完了，则比较失败
        if(i < word1.length() && j == word2.length()) {
            return false;
        }
        return true;
    }
}
