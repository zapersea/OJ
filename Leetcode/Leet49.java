package com.zaper.sea.leet;

import java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/18.
 */
public class Leet49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> re=new LinkedList<List<String>>();
        Map<String,List> z=new HashMap<String, List>();
        for(String str:strs) {
            String feature = array2String(getFeatureArray(str.toCharArray()));
            if (z.get(feature) == null)
                z.put(feature, new LinkedList<String>());
            z.get(feature).add(str);
        }
        for(String feature:z.keySet())
            re.add(z.get(feature));
        return re;
    }

    private int[] getFeatureArray(char[] array){
        int[] cnt=new int[26];
        for(char x:array)
            cnt[x-'a']++;
        return cnt;
    }

    private String array2String(int[] array){
        StringBuilder sb=new StringBuilder();
        for(int x:array)
            sb.append(x);
        return sb.toString();
    }

    public static void main(String[] args) {
        Leet49 x=new Leet49();
        String[] t={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(x.groupAnagrams(t));
    }
}
