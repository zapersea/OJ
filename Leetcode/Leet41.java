package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/10/15.
 */
import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class  Leet41
{
    public static int firstMissingPositive(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0 && nums[i]-1<nums.length){
                max=nums[i]>max?nums[i]:max;  //max must be here !!!!
                if(nums[i]-1!=i && nums[nums[i]-1]!=nums[i]) {
                    swap(nums, i, nums[i] - 1);
                    i--;
                }
            }
        }
        for(int i=0;i<max;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return max+1;
    }

    private  static void swap(int[] nums,int a,int b){
        int x=nums[a];
        nums[a]=nums[b];
        nums[b]=x;
    }

    public static int firstMissingPositive0(int[] nums) {
        int max=0,cntNeg=0,sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0)
                cntNeg++;
            else {
                sum += nums[i];
                max = nums[i] > max ? nums[i] : max;
            }
        }
        if(nums.length-cntNeg==max)
            return max+1;
        else
            return (1+max)*max/2-sum;
    }

    public static void main(String[] args) throws Exception
    {
        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
//        int[] nums={1,1,3,2,5,5,5,6,13};
        int[] nums={-4,500};
        int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
        System.out.println(firstMissingPositive(nums));
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