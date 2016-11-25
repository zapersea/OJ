package com.zaper.sea.leet;

import java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/19.
 */
public class Leet454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> z=new HashMap<Integer, Integer>();
        for(int a:A){
            for(int b:B)
                z.put(a+b,z.get(a+b)==null?1:z.get(a+b)+1);
        }
        int re=0;
        for(int c:C){
            for(int d:D)
                re+=z.get(-(c+d))==null?0:z.get(-(c+d));
        }
        return re;
    }
}
