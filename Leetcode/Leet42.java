import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet42
{
    public static int trap(int[] height) {
        int len=height.length,left=0,right=0,re=0;
        int[] maxRight=new int[len];
        for(int i=len-1;i>=0;i--){
            maxRight[i]=right;
            right=height[i]>right?height[i]:right;
        }
        for(int i=0;i<len;i++){
            re+=Math.min(maxRight[i],left)-height[i]>0?Math.min(maxRight[i],left)-height[i]:0;
            left=height[i]>left?height[i]:left;
        }
        return re;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={3,1,2,3,1,4,1,1,2,3};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		System.out.println(trap(nums));
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