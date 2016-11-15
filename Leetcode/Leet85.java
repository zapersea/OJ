package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/10/19.
 */
import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet85
{

    public static  int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;
        int re=0,lin=matrix.length,col=matrix[0].length;
        int[][] a=new int[lin][col];
        for(int i=0;i<lin;i++){
            for(int j=0;j<col;j++)
                a[i][j]=matrix[i][j]-'0';
        }
        for(int i=1;i<lin;i++){
            for (int j = 0; j < col; j++) {
                if (a[i][j]==1)
                    a[i][j]+=a[i-1][j];
            }
        }
        for(int i=0;i<lin;i++)
            re=Math.max(re,Leet84.largestRectangleArea(a[i]));
        return re;
    }

    public static void main(String[] args) throws Exception
    {
        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
        int[] nums={3,2,1,0,4};
        char[][] matrix={{'1','0','1','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
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