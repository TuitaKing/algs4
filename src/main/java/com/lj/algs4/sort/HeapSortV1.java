package com.lj.algs4.sort;

/**
 * @author lixingmei
 * @create 2017-12-26 上午10:20
 * @desc
 **/
public class HeapSortV1 {
	/**
	 * 初始化构建堆
	 */
	public static void buildMaxHeap(int[] data) {
		int startIndex = getParentIndex(data.length - 1);  //从最后一个元素的父节点开始比较
		for (int i = startIndex; i >= 0; i--) {
			maxHeap(data, data.length, i);
		}

	}

	private static void maxHeap(int[] data, int length, int current) {
		int leftChildindex = getLeftChildindex(current);
		int rightChildindex = getRightChildindex(current);
		int maxIndex = current;
		if (leftChildindex < length && data[maxIndex] < data[leftChildindex]) {
			maxIndex = leftChildindex;
		}
		if (rightChildindex < length && data[maxIndex] < data[rightChildindex]) {
			maxIndex = rightChildindex;
		}
		if (maxIndex != current) {
			int temp = data[current];
			data[current] = data[maxIndex];
			data[maxIndex] = temp;
			maxHeap(data, length, maxIndex);
		}

	}

	private static void heapSort(int[] data){
		for(int i=data.length-1;i>0;i--){
			//将最大的元素交换，放到正确的位置
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			maxHeap(data,i,0); //每循环一次，将最大值放到正确的位置后，已经排好序的部分无需重复比较，需要比较的数组长度-1
		}
	}

	private static int getParentIndex(int current) {
		return (current - 1) >> 1;
	}

	private static int getLeftChildindex(int current) {
		return 2 * current + 1;
	}

	private static int getRightChildindex(int current) {
		return 2 * (current + 1);
	}


	public static void main(String[] args){
		int[] data = new int[]{4,7,9,2,5,8,0,1,6,3};
		buildMaxHeap(data);  //找到最大的元素放在队顶
		heapSort(data);
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+",");
		}
	}
}
