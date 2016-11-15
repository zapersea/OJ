package com.zaper.sea.leet;

import java.util.*;

/**
 * Created by Zaper Ocean on 2016/11/9.
 */
public class Leet274 {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0)
            return 0;
        int len=citations.length;
        Arrays.sort(citations);
        for(int i=len-1;i>=0;i--){
            if(citations[i]<len-i)
                return len-(i+1); // neither (len-i) nor citations[i]
        }
        // len<citations[len-1] [100,99,98] return len=3
        return len;
    }

    public static void main(String[] args) {
        Leet274 zz=new Leet274();
        int[] nums={4,4,0,0};
        System.out.println(zz.hIndex(nums));
        Integer[] num={4,4,0,0};
        Arrays.sort(num, new MyComparator());
        for(Integer x:num)
            System.out.println(x);
    }
}

class MyComparator implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}