import java.io.*;
import java.util.*;
import java.text.*;

class Zaper implements Comparable{
	int v;
	int i;

	public Zaper(int v,int i){
		this.v=v;
		this.i=i;
	}

	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper)other;
		if(this.v!=o.v)
			return this.v-o.v;
		else
			return this.i-o.i; //保证相邻两点之间的i差值最小
	}
}

@SuppressWarnings("unchecked")
public class  Leet219
{
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
		int i,len=nums.length;
		Zaper[] z=new Zaper[len];
		for(i=0;i<len;i++)
			z[i]=new Zaper(nums[i],i);
		Arrays.sort(z);
		for(i=1;i<len;i++){
			if(z[i].v==z[i-1].v && z[i].i-z[i-1].i<=k)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={3,4,6,2,1,8,9,4,5};
		System.out.println(containsNearbyDuplicate(nums,1));
		reader.close();
	}
}