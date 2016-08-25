import java.io.*;
import java.util.*;
public class Nod1049  
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		List<Integer> L=new ArrayList<Integer>();
		long max=0;
		long cur=0;
		for (int i=0;i<N ;i++ )
			L.add(sc.nextInt());
		for (int i=0;i<N ;i++ )
		{	
			cur+=(long )L.get(i);
			if(cur>max)
				max=cur;
			if (cur<0) 
				cur=0;
		}
		System.out.println(max);
		sc.close();
	}
}
