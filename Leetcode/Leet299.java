package com.zaper.sea.leet;

import java.util.HashMap;

/**
 * Created by Zaper Ocean on 2016/10/26.
 */
public class Leet299 {
    public static String getHint(String secret, String guess) {
        HashMap<Integer,Integer> cnt=new HashMap<Integer, Integer>();
        for(int i=0;i<secret.length();i++){
            int x=secret.charAt(i)-'0';
            if(cnt.containsKey(x)){
                cnt.put(x,cnt.get(x)+1);
            }
            else
                cnt.put(x,1);
        }
        StringBuilder sb=new StringBuilder();
        int a=0,b=0;
        for(int i=0;i<guess.length();i++){
            int x=guess.charAt(i)-'0';
            if(cnt.get(x)!=null && secret.charAt(i)-'0'==x){
                a++;
                cnt.put(x,cnt.get(x)-1);
            }
        }
        for(int i=0;i<guess.length();i++){
            int x=guess.charAt(i)-'0';
            if(cnt.get(x)!=null && secret.charAt(i)-'0'!=x && cnt.get(x)>0){
                b++;
                cnt.put(x,cnt.get(x)-1);
            }
        }
        return  sb.append(a).append('A').append(b).append('B').toString();
    }
}
