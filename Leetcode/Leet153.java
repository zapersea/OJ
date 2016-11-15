import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet153
{
    public static int findMin(int[] nums) {
        for(int i=1;i<nums.length;i++){
			if(nums[i]<nums[i-1])
				return nums[i];
		}
		return nums[0];
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={4 ,5 ,6 ,7 ,0 ,1 ,2};
		System.out.println(findMin(nums));
		reader.close();
	}
}