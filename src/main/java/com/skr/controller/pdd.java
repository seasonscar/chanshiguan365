package com.skr.controller;

import java.util.Arrays;
import java.util.Scanner;

public class pdd {
    public static void main(String[] args) {
        staticTest p=new staticTest();
        new staticTest().print222();
        System.out.println("I AM STATIC2");
        Scanner sc = new Scanner(System.in);
        int childNum = sc.nextInt();
        int arrChild[] = new int[childNum];
        for (int i = 0; i < childNum; i++) {
            arrChild[i] = sc.nextInt();
        }
        int teacNum = sc.nextInt();
        int arrTeac[] = new int[teacNum];
        for (int i = 0; i < teacNum; i++) {
            arrTeac[i] = sc.nextInt();
        }
        //排序
        Arrays.sort(arrChild);
        Arrays.sort(arrTeac);

        //用老师最小的巧克力和学生最小的期望比，依次加1
        int j=0;//表示学生的计数
        int count=0;//标记可以上台的人数
        for(int i=0;i<teacNum;i++) {
            if (j<childNum&&arrChild[j]<=arrTeac[i]) {//孩子的期望小于老师所能给的巧克力
                count++;
                j++;
            }
        }
        System.out.println(count);
    }


}