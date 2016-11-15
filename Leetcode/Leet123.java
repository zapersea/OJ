package com.zaper.sea.leet;


import java.util.Arrays;

/**
 * Created by Zaper Ocean on 2016/10/24.
 */
public class Leet123 {
    static class Zaper implements Comparable{
        private int low0;
        private int high0;
        private int low1;
        private int high1;
        private int sum;

        public Zaper(int low0,int high0,int low1,int high1){
            this.low0=low0;
            this.high0=high0;
            this.low1=low1;
            this.high1=high1;
            this.sum=high0-low0+high1-low1;
        }

        public int compareTo(Object other) {
            Zaper o=(Zaper)other;
            return o.sum-this.sum;
        }
    }

    public static int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int op=0;
        while(op+1<prices.length&&prices[op+1]<=prices[op])
            op++;
        if(op+1==prices.length)
            return 0;
        int[] low=new int[prices.length];
        int[] high=new int[prices.length];
        int cnt=0;
        low[0]=prices[op];
        for(int i=op+1;i<prices.length-1;i++){
            if(prices[i]==prices[i+1])
                prices[i]=prices[i-1];
            else if(prices[i]>prices[i-1]&&prices[i]>prices[i+1])
                high[cnt++]=prices[i];
            else if(prices[i]<prices[i-1]&&prices[i]<prices[i+1])
                low[cnt]=prices[i];
        }
        if(prices[prices.length-1]>prices[prices.length-2])
            high[cnt++]=prices[prices.length-1];

        // DP
        if(cnt==1)
            return high[0]-low[0];
        Zaper re=new Zaper(low[0],high[0],low[1],high[1]);
        Zaper[] z=new Zaper[4];
        for(int i=2;i<cnt;i++){
            z[0]=new Zaper(re.low0,re.high0,low[i],high[i]);
            z[1]=new Zaper(re.low1,re.high1,low[i],high[i]);
            z[2]=new Zaper(re.low0,re.high1,low[i],high[i]);
            z[3]=new Zaper(re.low0,re.high0,re.low1,high[i]);
            Arrays.sort(z);
            if(z[0].sum>=re.sum){
                re.low0=z[0].low0;
                re.high0=z[0].high0;
                re.low1=z[0].low1;
                re.high1=z[0].high1;
                re.sum=z[0].sum;
            }
        }
        return re.sum;
    }

}
