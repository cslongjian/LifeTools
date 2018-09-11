package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.character_string;

/**
 * 字符串中的第一个唯一字符
 * <p>
 * <p>
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 * <p>
 * <p>
 * 与array中的第五题有点累屎。不过处理方式不同。
 */
public class ThreeQuestion {

    public static void main(String[] args) {

    }

    public int firstUniqChar(String s) {

        char[] stringList = s.toCharArray();
        for (int i = 0; i < stringList.length; i++) {
            for (int j = 0; j < stringList.length; j++) {
                if (j != i) {
                    if (stringList[i] == stringList[j]) {
                        break;
                    } else {
                        if (j == stringList.length - 1) {
                            return i;
                        }
                    }
                } else if (j == stringList.length - 1) {
                    return i;
                }
            }
        }

        return -1;

    }

    //    高级解法。针对字母。只有26个的情况。进行操作。与一开始想法，使用数组记录累屎。。
    public int firstUniqChar2(String s) {

        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

//    最高效率解法。关键方法 lastIndexof. 不用在对数组进行排序记录。直接找对对应的最后一位。
    public int firstUniqChar3(String s) {
        int result = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                result = result != -1 ? Math.min(result, index) : index;
            }
        }
        return result;
    }

}
