package com.zaper.sea.leet;

import java.util.Arrays;

/**
 * Created by Zaper Ocean on 2016/11/12.
 */
public class Leet451 {

    class Pair implements  Comparable{
        char c;
        int t;

        public Pair(char c){
            this.c=c;
            this.t=0;
        }

        private void add(){
            this.t++;
        }

        private void dec(){
            this.t--;
        }

        // 降序
        public int compareTo(Object o) {
            Pair other=(Pair)o;
            return other.t-this.t;
        }
    }

    public String frequencySort(String s) {
        if(s.length()==0)
            return "";
        Pair[] z=new Pair[256];
        for(int i=0;i<256;i++)
            z[i]=new Pair((char)i);
        for(char x:s.toCharArray())
            z[x].add();
        Arrays.sort(z);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<256;i++){
            if(z[i].t==0)
                break;
            while(z[i].t>0){
                sb.append(i+"");
                z[i].dec();
            }
        }
        return sb.toString();

    }
}
