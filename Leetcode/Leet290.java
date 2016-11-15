package com.zaper.sea.leet;

import java.util.HashMap;

/**
 * Created by Zaper Ocean on 2016/10/30.
 */
public class Leet290 {
    public static boolean wordPattern(String pattern, String str) {
        char[] c=pattern.toCharArray();
        String[] s=str.split(" ");
        if(c.length!=s.length)
            return false;
        HashMap<Character,String> z=new HashMap<Character, String>();
        for(int i=0;i<c.length;i++){
            if(!z.containsKey(c[i])) {
                if(z.containsValue(s[i]))      //一个V对应多个K
                    return false;
                z.put(c[i], s[i]);
            }
            else if(!z.containsValue(s[i])) //一个K对应多个V
                return false;
            else if(!z.get(c[i]).equals(s[i]))
                return false;
        }
        return true;
    }
}
