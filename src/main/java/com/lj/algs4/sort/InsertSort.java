package com.lj.algs4.sort;

//插入排序
public class InsertSort extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            //将当前的数据开始查询,将排好序的数据放入数组中，移动数组后面的数据 i表示当前要插入的数组index，j表示已经排好序的数组index。
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j-1]) < 0) {
                    exc(a, j-1, j);//将当前需要排序的值和前一个比较，如果小于，则将当前值往前移动。（由于只是检查小于，该算法是稳定的。）
                }
            }
        }
        show(a);
    }
    //时间复杂度，（最坏的情况是倒叙排成正序，时间主要消费是交换，一共1+2+...+n-1+n,也就是大O(n的二次方)），空间复杂度o(1)
    public static void main(String agrs[]){
        Comparable[] a={1,9,5,8,2,4,3,7};
        InsertSort inser=new InsertSort();
        inser.sort(a);
        boolean b=isSorted(a,false);
        System.out.println(b);
    }
}
