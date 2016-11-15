import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet78
{
    public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> z=new LinkedList<List<Integer>>();
		z.add(new LinkedList<Integer>());  //加入初始的空集
        int i,j,len=nums.length;
		for(i=0;i<len;i++){
			int x=nums[i];	
			int startLen=z.size(); //记录起始长度，否则后面add的同时size一直在变
			for(j=0;j<startLen;j++){
				List<Integer> m=new LinkedList<Integer>();
				m.addAll(z.get(j));
				m.add(nums[i]);
				z.add(m);
			}
		}
		return z;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums = {1,2,3};
		List<List<Integer>> z=subsets(nums);
		for(List<Integer> t:z){
			for(int x: t)
				System.out.print(x+" ");
			System.out.println();
		}
		reader.close();
	}
}