//	2016/9/11	9:36
import java.io.*;
import java.util.*;
import java.text.*;

class Zaper implements Comparable{
	public int i;
	public int cnt;

	public Zaper(int i,int cnt){
		this.i=i;
		this.cnt=cnt;
	}

	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper) other;
		if(this.cnt!=o.cnt)
			return this.cnt-o.cnt;
		else
			return o.i-this.i;
	}
}

public class ccf13121{

	public static void main(String[] args) throws Exception{

		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")),"GBK"));
		int n=Integer.parseInt(reader.readLine());
		Zaper[] z=new Zaper[10001];
		int i;

		for(i=0;i<=10000;i++)		// 0也要初始话，否则sort的时候会空指针错误
			z[i]=new Zaper(i,0);
		String[] s=reader.readLine().split(" ");
		for(i=0;i<n;i++)
			z[Integer.parseInt(s[i])].cnt++;
		Arrays.sort(z);
		System.out.println(z[10000].i);
		reader.close();
	}
}
//	9:47