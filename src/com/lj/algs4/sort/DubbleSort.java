package com.lj.algs4.sort;

public class DubbleSort extends  AbstractSort {
    @Override
    public void sort(Comparable[] a) {
            int count=1;
        for(int i = 0 ; i< a.length-count;i++){
            int j = 0 ;
            while(j<a.length-count){
                if(a[j].compareTo(a[j+1])>0){
                    exc(a,j,j+1);
                }
                j++;
            }
            count++;//由于每趟都会将最大的数移动到尾部，每趟遍历结束后将遍历的数减去1。比wiki上的时间好像会快点
        }
      //  show(a);
    }
}
