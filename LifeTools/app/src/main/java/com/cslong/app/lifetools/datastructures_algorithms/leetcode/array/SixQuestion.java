package com.cslong.app.lifetools.datastructures_algorithms.leetcode.array;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 两个数组的交集 II
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class SixQuestion {

    public static void main(String[] args) {

    }


//组合最大情况，就是较小的全部包含在内。以小的去遍历大的。击中就统计一次，并修正击中结果。
    public static int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> count = new ArrayList<>();
        if (nums1.length > nums2.length) {
            int length = nums2.length;

            for (int i = 0; i < length; i++) {
                int check = nums2[i];
                for (int j=0;j<nums1.length;j++) {
                    if (check == nums1[j]) {
                        nums1[j] = -1;
                        count.add(check);
                        break;
                    }
                }
            }
        } else {
            int length = nums1.length;

            for (int i = 0; i < length; i++) {
                int check = nums1[i];
                for (int j=0;j<nums2.length;j++) {
                    if (check == nums2[j]) {
                        nums2[j] = -1;
                        count.add(check);
                        break;
                    }
                }
            }
        }

        int[] d = new int[count.size()];
        for (int i = 0; i < count.size(); i++) {
            d[i] = count.get(i);
        }

        return d;


    }


}
