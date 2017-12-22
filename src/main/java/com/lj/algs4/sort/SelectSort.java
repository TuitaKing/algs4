package com.lj.algs4.sort;

//选择排序
public class SelectSort extends AbstractSort {
    private Comparable[] array;
    public SelectSort(Comparable[] a){
        this.array=a;
    }

    @Override //选出排序的，交换数组位置.
    public void sort(Comparable[] a) {
        for(int i= 0 ; i < a.length ; i++){
            //Comparable min=a[i];
            for(int j = i+1 ;j<a.length;j++){
                if(less(a[j],a[i])) exc(a,i,j);
            }
        }
        show(a);
    }

    public Comparable[] getArray() {
        return array;
    }

    public void setArray(Comparable[] array) {
        this.array = array;
    }
}
