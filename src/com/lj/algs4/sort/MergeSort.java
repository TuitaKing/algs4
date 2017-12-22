package com.lj.algs4.sort;

//采用遍历的方式
public class MergeSort extends AbstractSort {

    private static Comparable[] result;

    @Override
    public void sort(Comparable[] a) {
        Comparable[] temp = new Comparable[a.length];
        for (int block = 1; block < 2 * a.length; block *= 2) {//最外层循环表示归并的子序列中的元素个数
            for (int start = 0; start < a.length; start += 2 * block) { //按照上面提到的元素个数对每一组进行排序
                int indext = start;
                int mid = (start + block) > a.length ? a.length : (start + block);
                int end = (start + 2 * block) > a.length ? a.length : (start + 2 * block);
                int loStart = start, loEnd = mid;
                int hiStart = mid, hiEnd = end;
                while (loStart < loEnd && hiStart < hiEnd) {
                    temp[indext++] = a[loStart].compareTo(a[hiStart]) > 0 ? a[hiStart++] : a[loStart++];
                }
                while (loStart < loEnd) {
                    temp[indext++] = a[loStart++];
                }
                while (hiStart < hiEnd) {
                    temp[indext++] = a[hiStart++];
                }
            }
            Comparable[] cap = a;
            a = temp;
            temp = cap;
        }
        temp = a;
        show(a);
    }
    public static void megre_sort(Comparable[] a){
        result=new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        int start1 = lo, end1 = mid;
        int start2 = mid + 1, end2 = hi;
        int index = lo;
        for (int k = index; k <= hi; k++) {
            result[k] = a[k];
        }
        while (start1 <= end1 && start2 <= end2) {
            a[index++] = result[start1].compareTo(result[start2]) < 0 ? result[start1++] : result[start2++];
        }
        while (start1 <= end1) {
            a[index++] = result[start1++];
        }
        while (start2 <= end2) {
            a[index++] = result[start2++];
        }
        //这里全部用小与等于，避免出现某个尾端没有被排序到的情况。比如：不满足第一个while的时候，但是没有到大end2，后面如果不用<=则一直都不能被调用


    }

}
