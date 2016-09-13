//	2016/9/8	9:45
import java.io.*;
import java.util.*;
import java.text.*;

public class  ccf14121
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(reader.readLine());
		int[] a=new int[1001];
		int x;

		String[] s=reader.readLine().split(" ");
		for(int i=0;i<n-1;i++){
			x=Integer.parseInt(s[i]);
			a[x]++;
			writer.write(a[x]+" ");
		}
		x=Integer.parseInt(s[n-1]);
		a[x]++;
		writer.write(a[x]+"\n");

		writer.flush();
		reader.close();
	}
}
//	9:49