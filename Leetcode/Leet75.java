import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet75
{
    public static void sortColors(int[] nums) {
        int i,cnt0=0,cnt1=0,len=nums.length;
		for(i=0;i<len;i++){
			if(nums[i]==0)
				nums[cnt0++]=0;
			else if(nums[i]==1)
				cnt1++;
		}
		for(i=0;i<cnt1;i++)
			nums[cnt0+i]=1;
		for(i=cnt0+cnt1;i<len;i++)
			nums[i]=2;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={0,1,2,2,1,0,1,2};
		sortColors(nums);
		for(int x:nums)
			System.out.println(x+" ");
		reader.close();
	}
}