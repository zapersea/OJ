import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet152
{
    public static int maxProduct(int[] nums) {
        int i,t,cnt=0,ans=nums[0],max=Integer.MIN_VALUE;
		i=0;
		while(i<nums.length && nums[i]==0){
			max=0;
			i++;
		}
		if(i<nums.length){
			ans=nums[i];
			max=nums[i];
		}
		i++;
		for(;i<nums.length;i++){
			if(nums[i]==0 || i==nums.length-1){
				if(nums[i]!=0){   //别忘了乘最后一个元素，但不能i==len-1判断
					ans*=nums[i];   // 因为nums[len-1]也可能为0
					cnt++;
					t=i;
				}
				else{
					if(max<0)		   //  测试用例{-2,0,-1} ，最大是0
					max=0;
					t=i-1;
				}
				while(ans<0 && cnt>0){   //除掉最后一个负数
					ans/=nums[t--];
					cnt--;
				}
				if(ans>max)
					max=ans;
				i++;
				if(i<nums.length)
					ans=nums[i];
				cnt=0;
			}
			else{ 
				ans*=nums[i];
				cnt++;
			}
		}
		i=nums.length-1;
		while(i>=0 && nums[i]==0)
			i--;
		if(i>=0)
			ans=nums[i];
		i--;
		for(;i>=0;i--){
			if(nums[i]==0 || i==0){
				if(nums[i]!=0)	{ //别忘了乘第一个元素，但不能i==0判断
					ans*=nums[i];
					cnt++;
					t=i;
				}
				else
					t=i+1;
				while(ans<0 && cnt>0) {  //除掉第一个负数
					ans/=nums[t++];
					cnt--;
				}
				if(ans>max)
					max=ans;
				i--;
				if(i>=0)
					ans=nums[i];
				cnt=0;
			}
			else {
				ans*=nums[i];
				cnt++;
			}
		}
		return max;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		//int[] nums={2,3,-2,4,-3,5,-1,4};
		int[] nums={0,2};
		System.out.println(maxProduct(nums));
		reader.close();
	}
}