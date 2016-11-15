package com.zaper.sea.leet;

import java.util.HashMap;

/**
 * Created by Zaper Ocean on 2016/10/29.
 */
public class Leet389 {
    public static char findTheDifference(String s, String t) {
        HashMap<Character,Integer> z=new HashMap<Character, Integer>();
        for(char x:t.toCharArray()){
            if(z.get(x)!=null)
                z.put(x,z.get(x)+1);
            else
                z.put(x,1);
        }
        for(char x:s.toCharArray())
            z.put(x,z.get(x)-1);
        for(char x:z.keySet()){
            if(z.get(x)!=0)
                return x;
        }
        return ' ';
    }

    public static char findTheDifference1(String s, String t) {
        int sum=0;
        for (int i=0; i < s.length(); i++)
            sum += t.charAt(i)-s.charAt(i);
        sum += t.charAt(t.length()-1);
        return (char)sum;
    }
}
