//	2016/8/30	21:03
import java.io.*;
import java.util.*;

public class  ccf15091
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(reader.readLine());
		int[] a=new int[n];
		int cur,count=1;
		String[] s=reader.readLine().split(" ");
		for(int i=0;i<n;i++)
			a[i]=Integer.parseInt(s[i]);
		cur=a[0];
		for(int i=1;i<n;i++){
			if(a[i]!=cur){
				count++;
				cur=a[i];
			}
		}
		writer.write(count+"\n");
		writer.flush();
		reader.close();
	}
}
//	21:12