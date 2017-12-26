package com.lj.algs4.select;

import com.lj.algs4.sort.AbstractSort;
import com.lj.algs4.sort.QuickSort;

import java.util.Random;

/**
 * Created by lijing on 2017/12/26.
 */
public class BinarySearch {
    public Comparable get(Comparable key,Comparable[] a){
        int lo = 0 ,hi = a.length-1;
        int result=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(a[mid].compareTo(key)>0){
                hi=mid-1;
            }
            else if(a[mid].compareTo(key)<0){
                lo=mid+1;
            }else if(a[mid].compareTo(key)==0){
                result=mid;
                break;
            }
            //   result=mid;
        }
        if(key.compareTo(a[result])==0) {
            System.out.println(result+" : ");
            return a[result];
        }return null;
    }
    public static void main(String args[]){
        Comparable[] a=new Comparable[20];
        Random random=new Random(47);
        Comparable key=0;
        for(int i=0;i<a.length;i++){
            a[i]=random.nextInt(1000);

        }
        QuickSort quickSort=new QuickSort();
        quickSort.sort(a);
        AbstractSort.show(a);
        key=0;//a[random.nextInt(20)];
        BinarySearch binarySearch=new BinarySearch();
        Comparable aa= binarySearch.get(key,a);
        System.out.println(aa);


    }

}
