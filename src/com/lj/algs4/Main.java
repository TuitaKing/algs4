package com.lj.algs4;

import com.lj.algs4.sort.InsertSort;
import com.lj.algs4.sort.SelectSort;
import com.lj.algs4.sort.ShellSort;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Integer[] a = new Integer[2000];
		Random random = new Random(47);
		for (int i = 0; i < 2000; i++) {
			a[i] = random.nextInt(2000);
		}
		SelectSort selectSort = new SelectSort(a);
		long time1 = System.currentTimeMillis();
		selectSort.sort(a);
		System.out.println("select sort:  " + (System.currentTimeMillis() - time1));
		InsertSort insert = new InsertSort();
		long time2 = System.currentTimeMillis();
		insert.sort(a);
		System.out.println("Insert sort : " + (System.currentTimeMillis() - time2));
		//System.out.println(a);

		ShellSort shellSort = new ShellSort();
		long time3 = System.currentTimeMillis();
		shellSort.sort(a);
		System.out.println("Shell sort : " + (System.currentTimeMillis() - time3));

	}
}

