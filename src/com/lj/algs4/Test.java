package com.lj.algs4;

import com.lj.algs4.sort.QuickSortV1;

/**
 * @author lixingmei
 * @create 2017-12-22 下午5:05
 * @desc
 **/
public class Test {

	public static void main(String[] args) {
		QuickSortV1 qs = new QuickSortV1();
		Integer[] a = {6,1,2,7,9,3,4,5,10,8,-1,0};

		qs.sort(a);


		StringBuilder sb = new StringBuilder();
		for (Integer c : a) {
			if (c != null) {
				sb.append(c.toString() + " ");
			}
		}

		System.out.println(sb.toString());

	}
}
