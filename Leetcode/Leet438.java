package com.zaper.sea.leet;

import java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/8.
 */
public class Leet438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> z=new LinkedList<Integer>();
        char[] a=new char[p.length()];
        char[] b=p.toCharArray();
        Arrays.sort(b);
        for(int i=0;i<s.length()-p.length()+1;i++){
            for(int j=0;j<p.length();j++)
                a[j]=s.charAt(i+j);
            if(compareCharIndic(a,b))
                z.add(i);
        }
        return z;
    }

    private static boolean compareCharIndic(char[] a,char[] b){
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i])
                return  false;
        }
        return true;
    }
}
