package com.lj.algs4.sort;

import java.util.Random;

public class ShellSort extends AbstractSort {
    @Override
    public void sort(Comparable[] a) {
        int gap=1;//表示当前的间隔数据
        while(gap<a.length/3)
            gap=gap*3+1; //wiki上说这个间隔的效率比较高  1 4 13
        while(gap>0){
                for(int i = gap ; i<a.length ; i ++){  //当成a[0]...[length-1]的插入排序，每一次排序都是按照gap的增加。a[0] a[gap] ...。
                                                      // 这里是将a[0]..a[gap-1]当成插入排序中已经排好序的位置，a[gap]则是与a[0]做比较进行插入排序
                     int  j = i ;
                     while(j >= gap && a[j-gap].compareTo(a[j])>0){ //对gap分割的各个数组进行插入排序
                         exc(a,j-gap,j);
                         j=j-gap;
                     }
                }
                gap=(gap-1)/3;
        }
        show(a);
    }

    public static void main(String agrs[]){
        Random random=new Random(47);
        Comparable[] a=new Comparable[random.nextInt(40)];
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(100);
        }
        ShellSort inser=new ShellSort();
        inser.sort(a);
    }
}
