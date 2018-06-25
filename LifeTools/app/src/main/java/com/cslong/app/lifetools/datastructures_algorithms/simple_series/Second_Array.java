package com.cslong.app.lifetools.datastructures_algorithms.simple_series;

/**
 * Created by chenlongjian on 2018/6/25.
 * <p>
 * <p>
 * 数组的常规操作
 * 1、如何插入一条新的数据项
 * 2、如何寻找某一特定的数据项
 * 3、如何删除某一特定的数据项
 * 4、如何迭代的访问各个数据项，以便进行显示或其他操作
 */

public class Second_Array {

    //声明数组1,声明一个长度为3，只能存放int类型的数据
    int[] myArray = new int[3];
    //声明数组2,声明一个数组元素为 1,2,3的int类型数组
    int[] myArray2 = {1, 2, 3};


    //    访问数组元素以及给数组元素赋值
    private void testArray() {
        myArray[0] = 1;
//        访问myArray的第一个元素
        System.out.println(myArray[0]);
    }


    //    遍历
    private void testArray2() {
        int[] myArray2 = {1, 2, 3};
        for (int i = 0; i < myArray2.length; i++) {
            System.out.println(myArray2[i]);
        }
    }


}
