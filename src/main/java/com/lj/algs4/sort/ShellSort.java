package com.lj.algs4.sort;

public class ShellSort extends AbstractSort {
    @Override
    public void sort(Comparable[] a) {
        int gap=1;//表示当前的间隔数据
        while(gap<a.length/3)
            gap=gap*3+1; //wiki上说这个间隔的效率比较高  1 4 13
        while(gap>0){
                for(int i = gap ; i<a.length ; i ++){ //从当前位置开始往前
                     Comparable temp=a[i];
                     int  j = i ;
                     while(j>=0&&temp.compareTo(a[j-gap])<0){ //如果当前位置的值比上一个gap范围类的值小，则交换，一直比较到最开始的位置。
                            a[j]=a[j-gap];
                            j=j-gap;
                     }
                     a[j]=temp;
                }
                gap=gap/3;
        }
        show(a);
    }
}
