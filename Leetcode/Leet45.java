package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/10/16.
 */
import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet45
{
    public static int jump(int[] nums) {
        int len=nums.length,max=0,cnt=0,dis=0;
        if(len==1)
            return 0;
        for(int i=0;i<len;i++){
            if(i>dis){    //  每次访问到dis+1,则到新一层，层数加1，更新dis
                cnt++;    // cnt对应层数，0是第0层，1~nums[0]是第1层
                dis=max;  // dis是上一层能到的最远位置，对应当前层的范围
                max=i+nums[i];
            }
            else if(i+nums[i]>max)
                max=i+nums[i];
            if(i+nums[i]>=len-1)
                return cnt+1;
        }
        return cnt+1;
    }

    public static boolean canJump(int[] nums) {
        int op=0,ed=nums[0],len=nums.length;
        while(op<ed){
            int max=ed;
            for(int i=op;i<=ed;i++){
                max=Math.max(max,i+nums[i]);
                if(i+nums[i]>=len-1)
                    return true;
            }
            op=ed;
            ed=max;
        }
        if(ed==len-1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception
    {
        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
        int[] nums={1,2,3};
        int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
        System.out.println(jump(nums));
        reader.close();
    }

    private static void printNums(int[] nums){
        System.out.println("-----------Print Nums-------------");
        for(int x:nums){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    private static <T> void printList(List<T> z){
        System.out.println("-----------Print List-------------");
        for(T x:z){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    private static void printMatrix(int[][] matrix){
        System.out.println("-----------Print Matrix-------------");
        for(int[] t:matrix){
            for(int x:t)
                System.out.print(x+" ");
            System.out.println();
        }
    }

    private static <T> void printLL(List<List<T>> z){
        System.out.println("-----------Print LL---------------");
        for(List<T> t:z){
            for(T x:t)
                System.out.print(x+" ");
            System.out.println();
        }
    }

}