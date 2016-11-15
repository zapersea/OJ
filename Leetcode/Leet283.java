import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet283
{
    public static void moveZeroes(int[] nums) {
        int cnt=0,i=0;
		for(i=0;i<nums.length;i++){
			if(nums[i]!=0)
				nums[cnt++]=nums[i];
		}
		for(i=cnt;i<nums.length;i++)
			nums[i]=0;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={0, 1, 0, 3, 12};
		moveZeroes(nums);
		for(int i=0;i<nums.length;i++)
			System.out.println(nums[i]);
		reader.close();
	}
}