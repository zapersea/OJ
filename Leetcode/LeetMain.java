package com.zaper.sea.leet;

import java.io.*;
import java.util.*;
/**
 * Created by Zaper Ocean on 2016/10/19.
 */
public class LeetMain {
    public static void main(String[] args) throws Exception
    {
        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
        int[] nums={1, 2, 2, 1};
        int[] nums0={2,2};
        char[][] matrix={{'1','.','.','.','.','.','.','.','.'},{'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'}
        ,{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'}
        ,{'6','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'}
        ,{'9','.','.','.','.','.','.','.','.'}};
        int[][] points={{0,0},{1,0},{2,0}};
        int[][] points0={{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8}};
        System.out.println(Leet447.numberOfBoomerangs(points));
        //printNums(Leet350.intersect(nums,nums0));
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
