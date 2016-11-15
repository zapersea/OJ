import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet55x
{
    public static boolean canJump(int[] nums) {
    	int op=0,ed=nums[0],len=nums.length;
        while(op<ed){
            int max=ed;
            for(int i=op;i<=ed;i++){
                max=Math.max(max,i+nums[i]);
                if(i+nums[i]>=len-1)
                    return true;
            }
            op=ed;
            ed=max;
        }
        if(ed==len-1)
            return true;
        else 
            return false;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={3,2,1,0,4};
		System.out.println(canJump(nums));
		reader.close();
	}
}