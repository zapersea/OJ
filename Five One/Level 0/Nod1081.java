import java.io.*;
import java.util.*;

public class  Nod1081
{
	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int i,j;
		
		int n=Integer.parseInt(reader.readLine());
		long[] re=new long[n+1];	//  和的值有可能超过Int类型的最大值，需要long
		for(i=1;i<=n;i++){
			re[i]=re[i-1]+Integer.parseInt(reader.readLine());
		}
		
		int q=Integer.parseInt(reader.readLine());
		while(q-->0){
			String[] s=reader.readLine().split(" ");
			i=Integer.parseInt(s[0]);
			j=Integer.parseInt(s[1]);
			writer.write((re[i+j-1]-re[i-1])+"\n");
		}
		writer.flush();
	}
}