//	2016/9/9	12:59
import java.io.*;
import java.util.*;
import java.text.*;

public class  ccf14031
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		
		int[] z=new int[1001];
		int[] f=new int[1001];
		int i,re=0;
		int n=Integer.parseInt(reader.readLine());
		String[] s=reader.readLine().split(" ");
		for(i=0;i<n;i++){
			int t=Integer.parseInt(s[i]);
			if(t>0)
				z[t]++;
			else
				f[-t]++;
		}
		for(i=1;i<=1000;i++)
			re+=Math.min(z[i],f[i]);

		System.out.println(re);
		reader.close();
	}
}
//	13:04