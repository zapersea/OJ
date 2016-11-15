import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet154
{

    public static int findMin(int[] nums) {
        if(nums==null||nums.length<1)
            return 0;
        int low=0,hi=nums.length-1;
        if(nums[low]<nums[hi])
            return nums[low];
        while(low<hi){
            while(low<hi&&nums[low]==nums[hi]){
                low++;
                hi--;
            }
            int mid=(low+hi)/2;
            if(nums[mid+1]<nums[mid])
                return nums[mid+1];
            if(nums[low]>nums[mid])
                hi=mid;
            else if(nums[hi]<nums[mid])
                low=mid;
        }
        return nums[low];
    }


	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={1,1,3,1};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		System.out.println(findMin(nums));
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