import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet189
{
    public static void rotate(int[] nums, int k) {
		int i=0,len=nums.length;
		k=k%len;
		int[] a=new int[len+k];
		for(i=0;i<len;i++)
			a[i+k]=nums[i];
		for(i=0;i<k;i++)
			nums[i]=a[len+i];
		for(i=k;i<len;i++)
			nums[i]=a[i];
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={1,2,3,4,5,6,7};
		rotate(nums,3);
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
		reader.close();
	}
}