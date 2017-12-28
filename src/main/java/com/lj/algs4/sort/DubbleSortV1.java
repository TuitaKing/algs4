package com.lj.algs4.sort;

import com.lj.algs4.util.CommonMethod;

/**
 * @author lixingmei
 * @create 2017-12-27 下午5:57
 * @desc
 **/
public class DubbleSortV1 {

	public static void sort(int[] a){
		for(int i=0;i<a.length-1;i++){
			for(int j=a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					CommonMethod.swap(a,j,j-1);
				}
			}
		}
	}

	public static void main(String[] args){
		int[] a= new int[]{7,9,5,3,7,8,90,12,56,-1,0,24};
		sort(a);
		CommonMethod.printArray(a);
	}
}
