package com.zaper.sea.leet;

import  java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/7.
 */
public class Leet447 {
    public static int numberOfBoomerangs(int[][] points) {
        int len=points.length,cnt=0;
        for(int i=0;i<len;i++){
            HashMap<Integer,Integer> a=new HashMap<Integer,Integer>();
            for(int j=0;j<len;j++){
                int dis=(points[i][0]-points[j][0])*(points[i][0]-points[j][0]);
                dis+=(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                if(a.get(dis)!=null)
                    a.put(dis,a.get(dis)+1);
                else a.put(dis,1);
            }
            for(int x:a.keySet()) {
                int n=a.get(x);
                cnt += n*(n-1);
            }
        }
        return cnt;
        //下面这种做法反而会TLE，因为每次还要访问数组？
//        HashMap<Integer,Integer> []a=new HashMap[len];
//        for(int i=0;i<len;i++)
//            a[i]=new HashMap<Integer,Integer>();
//        for(int i=0;i<len;i++){
//            for(int j=i+1;j<len;j++){
//                int dis=(points[i][0]-points[j][0])*(points[i][0]-points[j][0]);
//                dis+=(points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
//                if(a[i].get(dis)!=null)
//                    a[i].put(dis,a[i].get(dis)+1);
//                else a[i].put(dis,1);
//                if(a[j].get(dis)!=null)
//                    a[j].put(dis,a[j].get(dis)+1);
//                else a[j].put(dis,1);
//            }
//            for(int x:a[i].keySet()) {
//                int n=a[i].get(x);
//                cnt += n*(n-1);
//            }
//        }
    }
}
