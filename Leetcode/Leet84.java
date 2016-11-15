package com.zaper.sea.leet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zaper Ocean on 2016/10/19.
 */
public class Leet84 {

    public static int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0)
            return 0;
        int re=0;
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<heights.length;i++){
            while(!s.empty()&&heights[i]<=heights[s.peek()]){
                int cur=s.pop();
                //栈顶下一个元素位置右一位就是相同栈顶元素到的最小坐标，栈底元素是最小的，所以取i就好
                re=Math.max(re,heights[cur]*(s.empty()?i:(i-s.peek()-1)));
            }
            s.push(i);
        }
        //处理元素完全按顺序排列的栈
        int cur=s.peek()+1;
        while(!s.empty()) {
            int x=s.pop();
            re = Math.max(re, heights[x]*(s.empty()?cur:(cur-s.peek()-1)));
        }
        return re;
    }

    public static void main(String[] args) throws Exception
    {
        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int[] nums={1,2,3,4,2,2,2,2,5,6};
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(largestRectangleArea(nums));
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