package com.lj.algs4.sort;

public class HeapSort extends AbstractSort{

    @Override
    public  void sort(Comparable[] pq) {
        int n = pq.length-1;
        for (int k = n/2; k >= 0; k--)
            sink(pq, k, n);
        while (n > 0) {
            exch(pq, 0, n--);
            sink(pq, 0, n);
        }
    }

    protected void swim(int k, Comparable[] a) { //当前插入的数据比他的父节点还大，则将当前节点“上浮”，也就是大根堆（根节点大于子节点的堆）
        if(a[k/2]==null) return;
        while (k >= 1 && less(a[k / 2], a[k])) {
            exc(a, k / 2, k);
            k = k / 2;
        }
    }
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private  void sink(Comparable[] pq, int k, int n) { //当前插入的数据比他的父节点还小，则将当前节点“下沉”，也就是小根堆（根节点小于子节点的堆）
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }


    public static void main(String args[]){
        Comparable[] a={1,5,6,3,2,4,7,8,9};
        HeapSort heapSort=new HeapSort();
        heapSort.sort(a);
        show(a);
    }
}
