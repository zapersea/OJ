package com.zaper.sea.leet;

import java.util.HashMap;

/**
 * Created by Zaper Ocean on 2016/10/27.
 */
public class Leet409 {
    public static int longestPalindrome(String s) {
        if(s==null||s.length()==0)
            return 0;
        HashMap<Character,Integer> z=new HashMap<Character, Integer>();
        for(char x:s.toCharArray()){
            if(z.get(x)!=null)
                z.put(x,z.get(x)+1);
            else{
                z.put(x,1);
            }
        }
        int re=0,hasOne=0;
        for(char x:z.keySet()){
            if(z.get(x)%2==0)
                re+=z.get(x);
            else {
                re+=z.get(x)-1;
                hasOne = 1;
            }
        }
        re+=hasOne;
        return re;
    }
}
