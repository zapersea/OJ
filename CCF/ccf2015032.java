//	2016/9/6	17:14
import java.io.*;
import java.util.*;

class Zaper implements Comparable{
	public int i;
	public int cnt;


	public Zaper(int i,int cnt){
		this.i=i;
		this.cnt=cnt;
	}

	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper)other;
		return o.cnt-this.cnt;
	}
}

public class  ccf2015032
{	
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n =Integer.parseInt(reader.readLine());
		int[] a=new int[n];
		Zaper[] c=new Zaper[1001];
		int i,index;
		for(i=0;i<1001;i++)
			c[i]=new Zaper(i,0);
		String[] s=reader.readLine().split(" ");
		for(i=0;i<n;i++){
			index=Integer.parseInt(s[i]);
			c[index].cnt++;
		}
		Arrays.sort(c);
		i=0;
		while(c[i].cnt!=0){
			writer.write(c[i].i+" "+c[i].cnt+"\n");
			i++;
		}
		writer.flush();
		reader.close();
	}
}
//	17:43