package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/11/11.
 */
public class Leet3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        int cnt=1,re=0,left=0,right=1;
        int[] a=new int[256];
        a[s.charAt(0)]++;
        while(right<s.length()){
            int x=s.charAt(right);
            if(a[x]>0){
                re=Math.max(re,cnt);
                while(left<right && a[x]!=0) {
                    a[s.charAt(left)]--;
                    left++;
                    cnt--;
                }
            }
            a[x]++;
            cnt++;
            right++;
        }
        re=Math.max(re,cnt);
        return re;
    }
}
