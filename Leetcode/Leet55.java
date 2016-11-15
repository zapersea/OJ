import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet55
{
    public static boolean canJump(int[] nums) {
    	int len=nums.length;
        boolean[] f=new boolean[len];
        f[0]=true;
        for(int i=1;i<len;i++){
        	for(int j=i-1;j>=0;j--){ //从后到前效率更高
        		if(f[j]==true && j+nums[j]>=i){
        			f[i]=true;
        			break;
        		}
        	}
        	if(f[i]==true && i+nums[i]>=len-1)
        		return true;
        }
        return f[len-1];
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