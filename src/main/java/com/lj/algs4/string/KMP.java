package com.lj.algs4.string;

/**
 * Created by lijing on 2019-03-01.
 * KMP 算法
 */
public class KMP {

    public static void main(String[] args) {
        String text="abcdexabcdafgvc";
        String pattern="abcdaf";
        System.out.println(findSubIndexByKmp(pattern.toCharArray(),text.toCharArray()));
    }


    public static int findSubIndexByKmp(char[] pattern,char[] str) {
        int p = pattern.length;
        int s = str.length;
        if (s == 0) return 0;
        int[] next = next(pattern);
        int j = 0, k = 0;
        while (j < s) {
            if (str[j] == pattern[k]) {
                if(k == p-1) return j-p+1;
                j++;
                k++;
            }else if(k>0){
                k=next[k-1];
            }else j++;

        }
        return -1;
    }


    public static int[] next(char[] pattern){
        int[] next=new int[pattern.length];
        int i=1;
        int k=0;
        int m=pattern.length;
        while(i<m){
            if(pattern[i]==pattern[k]){
                i++;
                k++;
                next[i]=k;
            }else if(k>0){
                k=next[k-1];
            }else i++;
        }
        return next;
    }



}
