package com.lj.algs4.sort;
//插入排序
public class InsertSort extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
       for(int i = 1 ;i < a.length ; i++){
           //将当前的数据开始查询,将排好序的数据放入数组中，移动数组后面的数据
          for(int j =0 ; j <i;j++){
              if(a[j].compareTo(a[i])>0){
                 exc(a,i,j);
              }
          }
       }
       show(a);
    }
}
