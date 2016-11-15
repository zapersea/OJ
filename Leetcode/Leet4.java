import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet4
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	if(nums1.length==0)
    		return findMedian(nums2,0,nums2.length-1);
    	if(nums2.length==0)
    		return findMedian(nums1,0,nums1.length-1);    	
        if(nums1.length>=nums2.length)
        	return findMedianSortedArraysX(nums1,nums2,0,nums1.length-1,0,nums2.length-1);
        else
        	return findMedianSortedArraysX(nums2,nums1,0,nums2.length-1,0,nums1.length-1);
    }

    private static double findMedianSortedArraysX(int[] nums1,int[] nums2,int low1,int hi1,int low2,int hi2){
    	int mid1=(low1+hi1)/2,mid2=(low2+hi2)/2;
    	if(hi1==low1&&hi2==low2)
    		return (nums1[low1]+nums2[low2])/2.0;
    	if(low2==hi2)
    		return findMedianB(nums1,low1,hi1,nums2[low2]);
    	if(low1==hi1)
    		return findMedianB(nums2,low2,hi2,nums1[low1]);
    	if(nums1[mid1]==nums2[mid2]){
    		if((hi1-low1+1)%2==1&&(hi2-low2+1)%2==1)
    			return nums1[mid1]*1.0;
    		else if((hi1-low1+1)%2==0&&(hi2-low2+1)%2==0)
    			return (Math.min(nums1[mid1],nums2[mid2])+Math.min(nums1[mid1+1],nums2[mid2+1]))/2.0;
    		else
    			return Math.min(nums1[mid1],nums2[mid2])*1.0;
    	}
    	else if(nums1[mid1]<nums2[mid2]){
    		if(nums1[mid1+1]<=nums2[mid2+1]){
	    		int off=Math.max(hi2-mid2,1);
	    		return findMedianSortedArraysX(nums1,nums2,low1+off,hi1,low2,mid2);
	    	}
	    	else
	    		return findMedian(nums2,low2,hi2);	
    	}
    	else {
    		if(nums1[mid1+1]<=nums2[mid2+1]){
	    		int off=mid2-low2+1;
	    		return findMedianSortedArraysX(nums1,nums2,low1,hi1-off,mid2+1,hi2);
    		}
    		else
    			return findMedian(nums1,low1,hi1);	
    	}

    }

    private static double findMedian(int[] nums,int low,int hi){
    	if((hi-low+1)%2==1)
    		return nums[(low+hi)/2]*1.0;
    	else 
    		return (nums[(low+hi)/2]+nums[(low+hi)/2+1])/2.0;
    }

    private static double findMedianB(int[] nums,int low,int hi,int t){
    	if(nums[low]>=t)
    		return findMedian(nums,low,hi-1);
    	if(nums[hi]<=t)
    		return findMedian(nums,low+1,hi);
    	int left=low,right=hi,index=0;
    	while(left<right){
    		int mid=(left+right)/2;
    		if(nums[mid]==t){
    			index=mid;
    			break;
    		}
    		else if(nums[mid]>t)
    			right=mid;
    		else
    			left=mid+1;
    		index=right;
    	}
    	int m=low+(hi-low+1)/2;
    	if (m==index){
    		if((hi-low+2)%2==1)
    			return t*1.0;
    		else
    			return (nums[m]+t)/2.0;
    	}
    	else if(m>index){
    		if((hi-low+2)%2==0 && index==m-1)
    			return (nums[m]+t)/2.0;
    		else 
    			return findMedian(nums,low,hi-1);
    	}
    	else{
    		if((hi-low+2)%2==0 && index==m+1)
    			return (nums[m]+t)/2.0;
    		else 
    			return findMedian(nums,low+1,hi);
    	}
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums1={3,4};
		int[] nums2={1,2,5};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		System.out.println(findMedianSortedArrays(nums1,nums2));
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