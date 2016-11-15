import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet53
{
    public static int maxSubArray(int[] nums) {
        int sum=nums[0],max=nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum<=nums[i])
                sum=nums[i];
            max=Math.max(max,sum);
        }
        return max;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
		reader.close();
	}
}