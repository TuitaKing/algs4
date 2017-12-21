package com.lj.algs4.sort;
//采用遍历的方式
public class MergeSort extends AbstractSort {
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
