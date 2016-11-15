import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet90
{
	public static int max=1000000;
	public static boolean[] visit;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> z=new LinkedList<List<Integer>>();
		z.add(new LinkedList<Integer>());  //加入初始的空集
		Arrays.sort(nums);
        int i,j,len=nums.length,last=1-nums[0];  //如果取last=-nums[0]，当nums[0]=0...相等
		for(i=0;i<len;i++){
			int x=nums[i];	
			int startLen=z.size(); //记录起始长度，否则后面add的同时size一直在变
			if(x!=last)
				visit=new boolean[max];
			for(j=0;j<startLen;j++){
				if(visit[j]==false){
					List<Integer> m=new LinkedList<Integer>();
					visit[j]=true;
					m.addAll(z.get(j));
					m.add(nums[i]);
					z.add(m);
				}
			}
			last=x;
		}
		return z;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums = {0};
		List<List<Integer>> z=subsetsWithDup(nums);
		for(List<Integer> t:z){
			for(int x: t)
				System.out.print(x+" ");
			System.out.println();
		}
		reader.close();
	}
}