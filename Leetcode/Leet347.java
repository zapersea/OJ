package com.zaper.sea.leet;

import java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/16.
 */
public class Leet347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> z=new HashMap<Integer, Integer>();
        for(int x:nums)
            z.put(x,(z.get(x)==null?0:z.get(x)+1));

        // Form bucket
        List<Integer> bucket[]=new List[nums.length];
        for(int i=0;i<nums.length;i++)
            bucket[i]=new LinkedList<Integer>();
        for(int x:z.keySet())
            bucket[z.get(x)].add(x);

        //bucket sort
        List<Integer> re=new LinkedList<Integer>();
        for(int i=nums.length-1;i>=0 && re.size()<k ;i--) {
            if (bucket[i].size() > 0)
                re.addAll(bucket[i]);
        }
        return re;
    }
}
