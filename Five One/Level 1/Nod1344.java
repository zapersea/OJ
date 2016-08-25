//	2016/8/22	13:51
import java.io.*;
import java.util.*;

public class Nod1344
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		long[] a=new long[n];
		int i;
		long res=0;
		for(i=0;i<n;i++)
			a[i]=Long.parseLong(reader.readLine());
		for(i=n-1;i>=0;i--)
			res=Math.max(res-a[i],0);
		writer.write(res+"\n");
		writer.flush();
	}
}
//	13:57