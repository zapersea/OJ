package com.zaper.sea.leet;

import  java.util.*;

/**
 * Created by Zaper Ocean on 2016/11/6.
 */
public class Leet350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> li=new LinkedList<Integer>();
        Map<Integer,Integer> z1=new HashMap<Integer,Integer>();
        for(int x:nums1){
            if(!z1.containsKey(x))
                z1.put(x,1);
            else
                z1.put(x,z1.get(x)+1);
        }
        Map<Integer,Integer> z2=new HashMap<Integer,Integer>();
        for(int x:nums2){
            if(!z2.containsKey(x))
                z2.put(x,1);
            else
                z2.put(x,z2.get(x)+1);
        }
        for(int x:z1.keySet()){
            if(z2.containsKey(x)){
                int min=Math.min(z1.get(x),z2.get(x));
                while(min-->0)
                    li.add(x);
            }
        }
        int[] re=new int[li.size()];
        for(int i=0;i<li.size();i++)
            re[i]=li.get(i);
        return re;
    }
}
