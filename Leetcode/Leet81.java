import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet81
{

	public static boolean binarySearch(int[] a,int low,int hi,int key){
		if(low>hi)
			return false;
		while(low<=hi){
			int mid=(low+hi)/2;
			if(key==a[mid])
				return true;
			else if(key<a[mid])
				hi=mid-1;
			else
				low=mid+1;
		}
		return false;
	}
	
    public static boolean search(int[] nums, int target) {
        int low=0,hi=nums.length-1,min=nums[0];
		for(int i=1;i<=hi;i++){
			if(nums[i]<nums[i-1])
				low=i;
		}
		if(low==0)
			return binarySearch(nums,0,nums.length-1,target);
		else
			return (binarySearch(nums,0,low-1,target) || binarySearch(nums,low,nums.length-1,target) );
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={2,2,2,0,2,2};
		System.out.println(search(nums,0));
		reader.close();
	}
}