import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet228
{
    public static List<String> summaryRanges(int[] nums) {
        List<String> z=new LinkedList<String>();
        if(nums.length==0)
        	return z;
        int low=0,hi=0;
        StringBuilder sb=new StringBuilder(nums[0]+"");
        for(int i=1;i<nums.length;i++){
        	if(nums[i]-nums[i-1]==1)
        		hi++;
        	else{
        		if(hi>low)
        			sb.append("->"+nums[hi]);
        		z.add(sb.toString());
        		low=i;
    			hi=i;
    			sb=new StringBuilder(nums[i]+"");	
        	}
        }
        if(hi>low)
			sb.append("->"+nums[hi]);
        z.add(sb.toString());
        return z;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={0,1,2,4,5,7};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		List<String> z=summaryRanges(nums);
		for(String x:z)
			System.out.println(x);
		reader.close();
	}
}