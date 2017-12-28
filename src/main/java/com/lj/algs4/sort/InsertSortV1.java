package com.lj.algs4.sort;

import com.lj.algs4.util.CommonMethod;

/**
 * @author lixingmei
 * @create 2017-12-27 下午6:26
 * @desc
 **/
public class InsertSortV1 {

	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int insert = a[i + 1];
			if (insert < a[0]) {
				CommonMethod.move(a, 0, i + 1);
				continue;
			}
			if (insert > a[i]) {
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (a[j] <= insert && a[j + 1] > insert) {
					System.out.println("insert:"+insert+" a[j]:"+a[j]+"  a[j+1]"+a[j+1]);
					CommonMethod.move(a, j + 1, i + 1);
					break;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[] a = new int[]{7, 9, 5, 3, 7, 8, 90, 12, 56, -1, 0, 24};
		sort(a);
		CommonMethod.printArray(a);
	}
}
