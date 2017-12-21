package com.lj.algs4.sort;
//采用遍历的方式
public class MergeSort extends AbstractSort {
    public static void merge_sort(Comparable[] arr) {
        int len = arr.length;
        Comparable[] result = new Comparable[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for(block = 1; block < len*2; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1].compareTo( arr[start2] )<0? arr[start1++] : arr[start2++];
                }
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            Comparable[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
        show(arr);
    }
    @Override
    public void sort(Comparable[] a) {
        Comparable[] temp=new Comparable[a.length];
        for(int block=1; block<2*a.length;block*=2){//最外层循环表示归并的子序列中的元素个数
            for(int start=0 ; start<a.length ; start+=2*block){ //按照上面提到的元素个数对每一组进行排序
                int indext=start;
                int mid=(start+block)>a.length ? a.length:(start+block);
                int end=(start+2*block)>a.length?a.length:(start+2*block);
                int loStart=start,loEnd=mid;
                int hiStart=mid,hiEnd=end;
                while(loStart<loEnd && hiStart < hiEnd){
                    temp[indext++]=a[loStart].compareTo(a[hiStart])>0?a[hiStart++]:a[loStart++];
                }
                while(loStart<loEnd){
                    temp[indext++]=a[loStart++];
                }
                while(hiStart<hiEnd){
                    temp[indext++]=a[hiStart++];
                }
            }
             Comparable[] cap=a;
             a=temp;
             temp=cap;
        }
        temp = a;
        show(a);
    }
    private void sort(Comparable[] a ,int lo , int hi){


    }

}
