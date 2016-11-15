import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet1
{
    public static int removeElement(int[] nums, int val) {
		int cnt=0,i=0;
		for(i=0;i<nums.length;i++){
			if(nums[i]!=val)
				nums[cnt++]=nums[i];
		}
		return cnt;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={3,2,2,3};
		int ans=removeElement(nums,3);
		System.out.println(ans);
		reader.close();
	}
}