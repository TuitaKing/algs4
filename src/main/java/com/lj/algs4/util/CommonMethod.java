package com.lj.algs4.util;

/**
 * @author lixingmei
 * @create 2017-12-27 下午6:07
 * @desc
 **/
public class CommonMethod {

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void move(int[] a, int start, int end) {
		int temp = a[end];
		int index = end;
		while (index > start) {
			a[index] = a[index - 1];
			index --;
		}
		a[start]=temp;
	}

	public static void printArray(int[] a) {
		for (int e : a) {
			System.out.print(e + "  ");
		}
	}
}
