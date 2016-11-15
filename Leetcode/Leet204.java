package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/10/19.
 */
import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet204
{
    public static int countPrimes(int n) {
        boolean[] a=new boolean[n];
        int cnt=0;
        for(int i=2;i<n;i++){
            if(a[i]==false){
                cnt++;
                for(int j=i+i;j<n;j+=i)
                    a[j]=true;
            }
        }
        return cnt;
    }
}