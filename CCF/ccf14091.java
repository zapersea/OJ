//	2016/9/9	19:46
import java.io.*;
import java.util.*;
import java.text.*;

public class  ccf14091
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		
		int[] a=new int[10001];
		int n=Integer.parseInt(reader.readLine());
		String[] s=reader.readLine().split(" ");
		int i,cnt,re=0;
		for(i=0;i<n;i++)
			a[Integer.parseInt(s[i])]=1;
		i=1;
		while(i<=10000){
			cnt=0;
			if(a[i]==1){
				while(a[i]==1 && i<=10000){
					i++;
					cnt++;
				}
				cnt--;
			}
			else
				i++;
			re+=cnt;
		}

		System.out.println(re);
		reader.close();
	}
}
//	19:59