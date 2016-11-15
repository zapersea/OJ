import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet229
{

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> z=new LinkedList<Integer>();
        int times1=0,times2=0,ele1=0,ele2=0,cnt1=0,cnt2=0;
        int[] ele=new int[2];
        for(int x:nums){
        	if(ele1==x)
        		times1++;
        	else if(ele2==x)
        		times2++;
        	else if(times1==0){
        		times1=1;
        		ele1=x;
        	}
        	else if(times2==0){
        		times2=1;
        		ele2=x;
        	}
        	else{
        		times1--;
        		times2--;
        	}
        }
        for(int x:nums){
        	if(x==ele1)
        		cnt1++;
        	else if(x==ele2)
        		cnt2++;
        }
        if(cnt1>nums.length/3)
        	z.add(ele1);
        if(cnt2>nums.length/3)
        	z.add(ele2);
        return  z;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums1={1,2,3,3,2,5,2,3,1,2,3};
		int[] nums2={3,3,4,4,5};
		int[] nums3={1 ,2 ,3, 1, 2 ,3, 1, 2, 4, 3, 3};
		List<Integer> z=majorityElement(nums2);
		for(int x:z)
			System.out.println(x+" ");
		reader.close();
	}
}