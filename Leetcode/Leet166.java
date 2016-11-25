package com.zaper.sea.leet;

import java.util.*;

/**
 * Created by Zaper Ocean on 2016/11/17.
 */
public class Leet166 {

    public static String fractionToDecimal(int numerator, int denominator) {
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);
        String re=((numerator!=0&&denominator!=0&&(numerator>0)!=(denominator>0))?"-":"")+num/den;
        if(num%den==0)
            return re;
        return re+"."+getRepeat(num%den,den);
    }

    private static String getRepeat(long remainder,long den){
        StringBuilder sb=new StringBuilder();
        HashMap<Long,Integer> z=new HashMap<Long,Integer>();
        int cnt=0;
        while(remainder!=0 && !z.containsKey(remainder)){
            z.put(remainder,cnt++);
            sb.append(remainder*10/den);
            remainder=(remainder*10)%den;
        }
        if(remainder!=0){
            sb.insert(z.get(remainder),"(");
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-1 ,-2147483648));
    }

    // Memory Exceed Limit
    private String getRepeatArray(long remainder,long den){
        StringBuilder sb=new StringBuilder();
        int[] index=new int[(int)den];
        for(int i=0;i<(int)den;i++)
            index[i]=-1;
        int cnt=0;
        while(remainder!=0 && index[(int)remainder]==-1){
            index[(int)remainder]=cnt++;
            sb.append(""+remainder*10/den);
            remainder=(remainder*10)%den;
        }
        if(remainder!=0){
            sb.insert(index[(int)remainder],"(");
            sb.append(")");
        }
        return sb.toString();
    }
}
