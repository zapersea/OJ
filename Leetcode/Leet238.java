import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet238
{
    public static int[] productExceptSelf(int[] nums) {
    	int cnt=1;
        for(int i=0;i<nums.length;i++){
        	int x=nums[i];
        	for(int j=0;j<i;j++)
        		nums[j]*=x;
        	nums[i]=cnt; //nums本身就含有一个x
        	cnt*=x;
        }
        return nums;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={1,2,3,4};
		int[] re=productExceptSelf(nums);
		for(int x:re)
			System.out.print(x+" ");
		reader.close();
	}
}