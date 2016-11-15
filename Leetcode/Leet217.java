import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet217
{
    public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for(int i=1;i<nums.length;i++){
			if(nums[i]-nums[i-1]==0)
				return true;
		}
		return false;
    }
	
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={3,4,6,2,1,8,9,4,5};
		System.out.println(containsDuplicate(nums));
		reader.close();
	}
}