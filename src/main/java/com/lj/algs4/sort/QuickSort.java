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

    public static void quick(Comparable[] a, int lo, int hi) {
        if(lo>=hi){
            return;
        }
            int i = lo ,j = hi ;
            Comparable key=a[(lo+hi)/2];
            for(;i<=j;){
                    while(a[i].compareTo(key)<0){
                        i++;
                    }
                    while(a[j].compareTo(key)>0){
                        j--;
                    }
                    if(i<=j){
                        exc(a,i,j);
                        i++;
                        j--;
                    }
      }
        quick(a,lo,j);
        quick(a,i,hi);
    }
    public static void quickWith3Part(Comparable[] a,int lo ,int hi){
             if(lo>=hi){
                 return;
             }
             int head=lo,tail=hi,eq=lo+1;//分成三个部分，比k小，等于k，比k大。[head]....a[lo-1]<k  ,a[lo]...a[eq]=k ,k<a[eq+1]....a[tail]
             Comparable k=a[lo];//将当前a[lo]作为中间值
             while(eq<=hi){
                 if(k.compareTo(a[eq])>0){ //左边遍历当值小于K，则与a[lo]交换，相当于等于k的数组迁移（是不稳定的。）
                     exc(a,lo,eq);
                     eq++;
                     lo++;
                 }else if(k.compareTo(a[eq])<0){ //当前值如果大于k，则将当前值放在数组尾部。然后继续比较，如果此时的值仍然是比r还大，
                                                // 则又将当前值与hi-1位进行对比，直到找到对应的小于k值得位置。)
                     exc(a,eq,hi);
                     hi--;
                 }
                 else {
                     eq++;
                 }
             }
        quickWith3Part(a,head,lo-1);
        quickWith3Part(a,hi+1,tail);

    }
//该方法比较的交换的次数会比上面提到的次数少，但是比较的次数会变多。
    public void quick3Sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        Comparable key = a[lo];
        int eq = lo, tail = hi, head = lo;
        while (eq <= tail) { //如果不用等号，会出现如果当前用作key值是最大值，但是最右边的数据为比最大值还小，则不会发生交换。
            if (key.compareTo(a[eq]) > 0) {

                exc(a, lo++, eq++);
            } else if (key.compareTo(a[eq]) < 0 && eq != tail) { //如果当前a[eq]大于key，则从尾部开始遍历到比key值小的进行交换。再一次循环会将他与lo交换。
                                        // 当最后eq与tail相等，此时eq的值比key大，如果进入下面的语句会产生交换
                // 当前值小于key时候  当前eq位置 : 9 当前lo位置:7 当前tail位置 9
                //    1 2 3 2 1 2 3 4 4 9 6 8 5 7 当前的eq==tail为9，进入到下面的while中，减一后退出，然后进入到下面的if，这个时候的a[tail]为4,a[eq]为9，则会交换。所以提前检查当前不是eq==tail的情况
                // 当前值大于key时候 需要交换 当前eq位置 : 9 当前lo位置:7 当前tail位置 8
                // 1 2 3 2 1 2 3 4 9 4 6 8 5 7
                while (key.compareTo(a[tail]) < 0) {
                    tail--;//循环找到小于key的位置
                    if (tail <= eq) break;
                }
                if (key.compareTo(a[tail]) >= 0) {
                    exc(a, eq, tail);
                }
            } else if (key.compareTo(a[eq]) == 0) {
                eq++;
            } else {
                //当前eq已经运行到和tail相等，但是不满足上面的要求，exMy
                break;
            }
        }
        quick3Sort(a, head, lo - 1);
        quick3Sort(a, eq, hi);
    }
  public static void sort1(Comparable[] a,int lo,int hi){
        if(lo>=hi) return;
        Comparable key=a[lo];
        int head=lo,tail=hi+1;
        while(lo<=hi){
            while(key.compareTo(a[++head])>0){

            }
            while(key.compareTo(a[--tail])<0){
            }
            if(head<=tail){
                exc(a,head,tail);
            }
        }
      sort1(a,lo,head-1);
        sort1(a,head+1,hi);
  }
    public static void main(String agrs[]) {
        Random random = new Random(47);
        Comparable[] a = new Comparable[random.nextInt(40)];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(1000);
        }
        QuickSort inser = new QuickSort();
       // inser.sort(a);
       // inser.quick(a,0,a.length-1);
        show(a);
        inser.quickWith3Part(a,0,a.length-1);
        show(a);
        boolean b = isSorted(a, false);
        System.out.println(b);
    }
}
