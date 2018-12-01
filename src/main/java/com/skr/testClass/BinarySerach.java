package com.skr.testClass;

/**
 * Created by 15082188 on 2018/10/9.
 */
public class BinarySerach {
    public static void main(String[] args) {
        Integer a[]={1,2,3,4,5,7,8,9};
        int des=3;
        System.out.println(a[new BinarySerach().binarySearch(a,des)]);
    }

    public static int binarySearch(Integer[] srcArray, int des) {
        //定义初始最小、最大索引
        int low = 0;
        int high = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (low <= high) {
            //计算出中间索引值
            int middle = (high + low)>>>1 ;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //判断上限
            } else {
                low = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }
}
