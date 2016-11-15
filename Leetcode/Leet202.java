package com.zaper.sea.leet;

import  java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/3.
 */
public class Leet202 {
    public boolean isHappy(int n) {
        String s=String.valueOf(n);
        Set z=new HashSet();
        while(!z.contains(s)){
            z.add(s);
            if(s.equals("1"))
                return true;
            else{
                int sum=0;
                for(char x:s.toCharArray()){
                    sum+=(x-'0')*(x-'0');
                }
                s=Integer.toString(sum);
            }
        }
        return false;
    }
}
