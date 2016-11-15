package com.zaper.sea.leet;

import java.util.*;

/**
 * Created by Zaper Ocean on 2016/11/4.
 */
public class Leet349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> z=new ArrayList<Integer>();
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i]==nums2[j]){
                if(z.size()==0||nums1[i]!=z.get(z.size()-1))
                    z.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])
                i++;
            else j++;
        }
        int[] re=new int[z.size()];
        for(int k=0;k<z.size();k++)
            re[k]=z.get(k);
        return re;
    }
}
