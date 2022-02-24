package com.cslong.app.book.aha;

//https://www.cnblogs.com/morethink/p/8419151.html#%E7%9B%B4%E6%8E%A5%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F
public class Aha_Part1 {

    //    桶排序


    //冒泡排序
//    平均时间复杂度	最好情况	最坏情况	空间复杂度
//    O(n²)	        O(n)	O(n²)	   O(1)
    public static void maopaoSort(int[] a) {
        //外层循环控制比较的次数
        for (int i = 0; i < a.length - 1; i++) {
            //内层循环控制到达位置
            for (int j = 0; j < a.length - i - 1; j++) {
                //前面的元素比后面大就交换
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }


    //    快速排序
//    核心思想，基准书作为左右分割，使用递归
    public static void QuickSort(int[] nums, int low, int high) {
        //已经排完
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;

        //保存基准值
        int pivot = nums[left];

        while (left != right) {
            //从后向前找到比基准小的元素
            while (left < right && nums[right] >= pivot)
                right--;
            //从前往后找到比基准大的元素
            while (left < right && nums[left] <= pivot)
                left++;

            //交互两个数在数组中的位置。
            if (left < right) { //当两个标记值没有相遇时候
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }

        }

        // 放置基准值，准备分治递归快排
        nums[left] = pivot;

        QuickSort(nums, low, left - 1);
        QuickSort(nums, left + 1, high);
    }


}
