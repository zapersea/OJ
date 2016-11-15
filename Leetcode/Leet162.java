import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet162
{
    public static int findPeakElement(int[] nums) {
		int i,j,len=nums.length;
		if(len==1)		//只有一个元素是nums[1]会越界
			return 0;
		if(nums[0]>nums[1])
			return 0;
		if(nums[len-1]>nums[len-2])
			return len-1;
		if(len>=3)
		i=1;
		j=len-2;
		while(i<=j){
			int mid=(i+j)/2;
			if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
				return mid;

		}
		for(i=1;i<len-1;i++){
			if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
				return i;
		}
		return -1;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={3,6,7,8,21,15,14};
		System.out.println(findPeakElement(nums));
		reader.close();
	}
}