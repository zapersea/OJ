//	2016/9/11	10:09
import java.io.*;
import java.util.*;
import java.text.*;

public class ccf13123{

	public static void main(String[] args) throws Exception{

		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")),"GBK"));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(reader.readLine());
		String[] s=reader.readLine().split(" ");
		int[] a=new int[n];
		int[] len=new int[n];
		int[] re=new int[n];
		int i,j;

		for(i=0;i<n;i++){
			a[i]=Integer.parseInt(s[i]);
			len[i]=a[i];
			re[i]=a[i];
		}

		for(i=0;i<n;i++){
			int br=1;
			for(j=i+1;j<n;j++){
				br++;
				if(a[j]<len[i])
					len[i]=a[j];
				if(len[i]*br>re[i])
					re[i]=len[i]*br;
			}
		}
		Arrays.sort(re);
		System.out.println(re[n-1]);
		reader.close();
	}
}
//	10:35