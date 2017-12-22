package com.lj.algs4.sort;

public class QuickSort extends AbstractSort {
    public void sort(Comparable[] a) {
        quickSort(a,0,a.length-1);
    }
    public void quickSort(Comparable[] a,int lo ,int hi){
        if(lo>=hi) return;
        int j= partion(a,lo,hi);
        quickSort(a,lo,j-1);
        quickSort(a,j+1,hi);


    }
    public int partion(Comparable[] a,int lo , int hi ){
        int i=lo,j=hi+1;
        Comparable k=a[lo];
        while (true){
            while(less(a[++i],k)) if(i==hi) break;
            while(less(k,a[--j])) if(j==lo) break;
            if(i>=j) break;
            exc(a,i,j);
        }
        exc(a,lo,j);
        return j;
    }
}
