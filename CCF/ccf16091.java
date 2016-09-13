
import java.io.*;
import java.util.*;
import java.text.*;

public class ccf16091 {
	public static void main(String[] args)throws Exception{
		
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")),"GBK"));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(reader.readLine());
		int[] a=new int[n];
		String[] s=reader.readLine().split(" ");
		int i,max=0;
		
		for(i=0;i<n;i++)
			a[i]=Integer.parseInt(s[i]);
		for(i=1;i<n;i++){
			int x=a[i]-a[i-1];
			if(x<0)
				x*=-1;
			if(x>max)
				max=x;
		}
		
		System.out.println(max);
	}

}
