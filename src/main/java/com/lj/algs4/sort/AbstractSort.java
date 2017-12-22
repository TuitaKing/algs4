package com.lj.algs4.sort;
//排序的模板类，主要用来比较和交换数据。
public abstract class AbstractSort {
    public  abstract void sort(Comparable[]  a);
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }
    public static void exc(Comparable[] t,int i,int j){
        if(null!=t[i]&&null!=t[j]){
            Comparable temp=t[i];
            t[i]=t[j];
            t[j]=temp;
            temp=null;
        }
    }
    public static void show(Comparable[] t){
       StringBuilder sb=new StringBuilder();
        for(Comparable a:t){
            sb.append(a.toString()+" ");
        }
        System.out.println(sb.toString());
    }
    public static boolean isSorted(Comparable[] t,boolean des){
        for(int  i = 1 ; i <t.length ; i++){
            if(!des){
                if(less(t[i],t[i-1])) return false;
            }else{
                if(less(t[i-1],t[i])) return false;
            }

        }
        return true;
    }
}
