package com.lj.algs4;

import java.util.Date;

/**
 * @author lixingmei
 * @create 2017-12-26 上午10:35
 * @desc
 **/
public class Test {

	public static void main(String[] args) {
		int res;
		long t1 = new Date().getTime();
		for (int i = 1000000000; i > 0; i--) {
			res = i << 1;
		}
		System.out.println(new Date().getTime() - t1);
		long t2 = new Date().getTime();
		for (int j = 1000000000; j > 0; j--) {
			res = j * 2;
		}
		System.out.println(new Date().getTime() - t2);
	}
}
