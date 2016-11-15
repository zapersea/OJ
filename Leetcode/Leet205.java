package com.zaper.sea.leet;

import java.util.HashMap;

/**
 * Created by Zaper Ocean on 2016/11/2.
 */
public class Leet205 {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> z=new HashMap<Character, Character>();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            char y=t.charAt(i);
            if(!z.containsKey(x)){
                if(z.containsValue(y))
                    return false;
                z.put(x,y);
            }
            else if(!z.containsValue(y))
                return false;
            else if(z.get(x)!=y)
                return false;
        }
        return true;
    }
}
