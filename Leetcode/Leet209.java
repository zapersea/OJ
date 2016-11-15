import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet209
{

    public int minSubArrayLen(int s, int[] nums) {  
        //init check  
        int start = 0;  
        int end = 0;  
          
        int sum = 0;  
        int min = Integer.MAX_VALUE;  
          
        while(start<nums.length && end<nums.length) {  
            while(sum<s && end<nums.length) {  
                sum += nums[end++];  
            }  
            while(sum>=s && start<=end) {  
                min = Math.min(min, end-start);  
                sum -= nums[start++];  
            }  
        }  
        return min==Integer.MAX_VALUE ? 0 : min;  
    } 

	public static void main(String[] args) throws Exception
	{			
		Integer[] nums={2,3,1,2,4,3};
		int[] num={2,3,1,2,4,3};
		Integer[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		List<Integer> t=new LinkedList<Integer>();
		List<List<Integer>> z=new LinkedList<List<Integer>>();
		t.add(5);
		z.add(t);
		t.add(6);
		z.add(new LinkedList<Integer>(t));
		System.out.println(minSubArrayLen(7,num));
		//printNums(nums);
		//printMatrix(matrix);
		//printList(t);
		//printLL(z);

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