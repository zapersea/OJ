package com.zaper.sea.leet;

import java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/15.
 */
public class Leet187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> z=new LinkedList<String>();
        if(s==null||s.length()<10)
            return z;
        Set<String> set=new HashSet<String>();
        Set<String> re=new HashSet<String>();
        StringBuilder sb=new StringBuilder(s.substring(0,10));
        set.add(sb.toString());
        for(int i=10;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.deleteCharAt(0);
            String x=sb.toString();
            if(set.contains(x))
                re.add(x);
            else
                set.add(x);
        }
        z.addAll(re);
        return z;
    }
}
