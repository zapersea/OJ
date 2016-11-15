import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet34
{
    public static int[] searchRange(int[] nums, int target) {
    	int[] z={-1,-1};
        if(binarySearchEqual(0,nums.length-1,nums,target)==-1)
        	return z;
        z[0]=binarySearchLeft(0,nums.length-1,nums,target);
        z[1]=binarySearchRight(0,nums.length-1,nums,target);
        return z;
    }

    public static int binarySearchEqual(int low,int hi,int[] nums,int target){
    	if(low>hi)
    		return -1;
    	while(low<=hi){
    		int mid=(low+hi)/2;
    		if(nums[mid]==target)
    			return mid;
    		else if(nums[mid]<target)
    			low=mid+1;
    		else if(nums[mid]>target)
    			hi=mid-1;
    	}
    	return -1;
    }

    public static int binarySearchLeft(int low,int hi,int[] nums,int target){
    	if(low>hi)
    		return 0;
    	while(low<hi){
    		int mid=(low+hi)/2;
    		if(nums[mid]<target)
    			low=mid+1;
    		else if(nums[mid]>=target)
    			hi=mid;
    	}
    	return hi;
    }

     public static int binarySearchRight(int low,int hi,int[] nums,int target){
    	if(low>hi)
    		return 0;
    	while(low<hi){
    		int mid=(low+hi+1)/2;   // !!!! considering nums=[2,2] ，must be (low+hi+1)
    		if(nums[mid]>target)
    			hi=mid-1;
    		else if(nums[mid]<=target)
    			low=mid;
    	}
    	return low;
    }

	public static void main(String[] args) throws Exception
	{			
		int[] nums={5, 7, 7, 8, 8, 10};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		int[] z=searchRange(nums,8);
		printNums(z);
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