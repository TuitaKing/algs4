package com.lj.algs4;

import com.lj.algs4.sort.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random=new Random(47);
        Integer[] a=new Integer[random.nextInt(20)];
        for(int i = 0 ; i<a.length;i++ ){
            a[i]=random.nextInt(20000);
        }
        SelectSort selectSort=new SelectSort(a);
        long time1=System.currentTimeMillis();
       //selectSort.sort(a);
       System.out.println("select sort:  "+(System.currentTimeMillis()-time1));
        InsertSort insert=new InsertSort();
        long time2=System.currentTimeMillis();
      //  insert.sort(a);
        System.out.println("Insert sort : "+(System.currentTimeMillis()-time2));
      //System.out.println(a);

        ShellSort shellSort=new ShellSort();
        long time3=System.currentTimeMillis();
    //    shellSort.sort(a);
        System.out.println("Shell sort : "+(System.currentTimeMillis()-time3));
        DubbleSort dubbleSort=new DubbleSort();
        long time4=System.currentTimeMillis();
       // dubbleSort.sort(a);
        System.out.println("Dubble sort : "+(System.currentTimeMillis()-time4));
        MergeSort mergeSort=new MergeSort();
        Comparable[] b=a;
       // mergeSort.merge_sort(a);
        show(a);
       // mergeSort.megreSort(b);
        show(b);
        QuickSort quickSort=new QuickSort();
        quickSort.sort(a);
        show(a);
    }
    public static void show(Comparable[] t){
        StringBuilder sb=new StringBuilder();
        for(Comparable a:t){
            sb.append(a.toString()+" ");
        }
        System.out.println(sb.toString());
    }
}

