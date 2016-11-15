package com.zaper.sea.leet;

import  java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/1.
 */
public class Leet136 {
    public static int singleNumber(int[] nums) {
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int x:nums){
            if(hs.contains(x))
                hs.remove(x);
            else
                hs.add(x);
        }
        for(int x:hs)
            return x;
        return nums[0];
    }
}
