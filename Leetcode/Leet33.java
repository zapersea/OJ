import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet33
{

	public static int binarySearch(int[] a,int low,int hi,int key){
		if(low>hi)
			return -1;
		while(low<=hi){
			int mid=(low+hi)/2;
			if(key==a[mid])
				return mid;
			else if(key<a[mid])
				hi=mid-1;
			else
				low=mid+1;
		}
		return -1;
	}
	
    public static int search(int[] nums, int target) {
        int low=0,hi=nums.length-1,min=nums[0];
		while(low<hi){
			int mid=(low+hi)/2;
			if(nums[mid]>nums[hi])
				low=mid+1;
			else 
				hi=mid;  //mid可能值最小值，这里是mid，而不是mid-1 !
		}
		if(low==0)
			return binarySearch(nums,0,nums.length-1,target);
		else
			return Math.max(binarySearch(nums,0,low-1,target),binarySearch(nums,low,nums.length-1,target) );
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={ 5 ,1 ,3};
		System.out.println(search(nums,5));
		reader.close();
	}
}