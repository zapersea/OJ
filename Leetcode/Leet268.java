import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet268
{
    public static int missingNumber(int[] nums) {
        int i,max=0,len=nums.length;
		long re=0;
		for(i=0;i<len;i++){
			re+=nums[i];
			if(nums[i]>max)
				max=nums[i];
		}
		if(max==len-1)
			max++;	// 对于0,1,2,3,4这种特殊情况，认为是缺5
		re=(1+max)*max/2-re;
		return (int)re;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[]  nums = {0,1,2,3,4};
		System.out.println(missingNumber(nums));
		reader.close();
	}
}