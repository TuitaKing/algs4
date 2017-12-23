package com.lj.algs4.sort;

import java.util.Random;

public class QuickSort extends AbstractSort {
    public void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public void quickSort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partion(a, lo, hi);
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    public int partion(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable k = a[lo];
        while (true) {
            while (less(a[++i], k)) if (i == hi) break; //将a[lo]作为第一次key值，左边从i+1开始，如果发现i的值大于key。则当前的i停止，
            while (less(k, a[--j])) if (j == lo) break;//如果上面的i停止查找比key小的值，则j找到比key的值小的值并且和i交换。（当前的排序完毕，i和j相遇）
            if (i >= j) break;
            exc(a, i, j);
        }
        exc(a, lo, j);
        return j;
    }

    public static void main(String agrs[]) {
        Random random = new Random(47);
        Comparable[] a = new Comparable[random.nextInt(40)];
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(1000);
        }
        QuickSort inser = new QuickSort();
        inser.sort(a);
        show(a);
        boolean b = isSorted(a, false);
        System.out.println(b);
    }
}
