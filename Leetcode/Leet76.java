package com.zaper.sea.leet;


import java.util.HashMap;

/**
 * Created by Zaper Ocean on 2016/11/25.
 */
public class Leet76 {
    public String minWindow(String s, String t) {
        if(s==null||s.length()==0) return "";

        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        HashMap<Character,Integer> window=new HashMap<Character,Integer>();
        for(char c:t.toCharArray()) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
            window.put(c,0);
        }

        char[] schar=s.toCharArray();
        boolean find=false;
        int left=0,right=0,cnt=0,start=0,end=schar.length,nums=t.length(); // end!=length-1
        while(right<schar.length){
            while(right<schar.length && !map.containsKey(schar[right]))
                right++;
            if(right>=schar.length) break;
            char y=schar[right++];
            //window.put的返回值可能为null ！！！
            if(!window.containsKey(y)||window.put(y,window.get(y)==null?1:window.get(y)+1)<map.get(y))
                cnt++;
            if(cnt==nums){
                while(left<right && cnt==nums){
                    char x=schar[left++];
                    if(window.containsKey(x)&&window.put(x,window.get(x)-1)<=map.get(x))
                        cnt--;
                }
                if(right-left+1<=end-start){
                    find=true;
                    start=left-1;
                    end=right;
                }
            }
        }
        if(find) return s.substring(start,end);
        else return "";
    }

    public static void main(String[] args) {
//        System.out.println(new Leet76().minWindow("ADOBECODEBANC","ABBC"));
        System.out.println(new Leet76().minWindow("a","a"));

    }
}
