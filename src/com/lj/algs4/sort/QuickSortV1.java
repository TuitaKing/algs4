package com.lj.algs4.sort;

import java.util.Random;

/**
 * @author lixingmei
 * @create 2017-12-22 下午4:40
 * @desc
 **/
public class QuickSortV1 extends AbstractSort {


	@Override
	public void sort(Comparable[] a) {

		compareAndSort(a, 0, a.length - 1);

	}

	private void compareAndSort(Comparable[] a, int leftIndex, int rightIndex) {

		int nextRightIndex = rightIndex;
		int left = leftIndex;
		Comparable key = a[left];
		while (leftIndex < rightIndex) {
			while (a[rightIndex].compareTo(key) >= 0 && rightIndex > leftIndex) {
				rightIndex--;
			}
			while (a[leftIndex].compareTo(key) <= 0 && leftIndex < rightIndex) {
				leftIndex++;
			}
			if (leftIndex < rightIndex) {
				swap(a, rightIndex, leftIndex);
			}
		}
			swap(a, rightIndex, left);
			if (leftIndex - 1 > left) {
				compareAndSort(a, left, leftIndex - 1); //key值左边的
			}
			if (leftIndex + 1 < nextRightIndex) {
				compareAndSort(a, leftIndex + 1, nextRightIndex); //key值右边的
			}


	}

	private void swap(Comparable[] a, int i, int storeIndex) {
		Comparable temp = a[i];
		a[i] = a[storeIndex];
		a[storeIndex] = temp;
	}

	public void showaa(Comparable[] a) {
		StringBuilder sb = new StringBuilder();
		for (Comparable c : a) {
			if (c != null) {
				sb.append(c.toString() + " ");
			}
		}
		System.out.println(sb.toString());
	}
}
