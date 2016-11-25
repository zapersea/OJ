package com.zaper.sea.leet;


import java.util.*;

/**
 * Created by Zaper Ocean on 2016/11/23.
 */
public class Leet30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> re=new LinkedList<Integer>();
        if(words.length==0) return re;

        int len=words[0].length();
        int nums=words.length;
        Map<String,Integer> record=new HashMap<String, Integer>();

        int[][] window=new int[2][nums];
        int index=0;
        for(int i=0;i<nums;i++){
            String w=words[i];
            if(record.get(w)==null) {
                record.put(w, index);
                window[0][index++]++;
            }
            else
                window[0][record.get(w)]++;
        }
        int left=0,right=0,cnt=0;
        while(left+nums*len<=s.length()){
            String RightSub=s.substring(right,right+len);
            right+=len;
            if(record.containsKey(RightSub) && window[1][record.get(RightSub)]++<window[0][record.get(RightSub)]){
                cnt++;
            }
            else{
                right=++left;
                cnt=0;
                window[1]=new int[nums];
                continue;
            }
            if(right-left==nums*len){
                if(cnt==nums)
                    re.add(left);
                right=++left;
                cnt=0;
                window[1]=new int[nums];
            }
        }
        return re;
    }

    public static void main(String[] args) {
        String nums[]={"fooo","barr","wing","ding","wing"};
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",nums));
    }
}
