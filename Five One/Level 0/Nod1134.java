import java.io.*;
import java.util.*;

public class  Nod1134
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(reader.readLine());
		int i,j,max=0;
		long[] a=new long[N];
		int[] count=new int[N];
		for(i=0;i<N;i++){
			a[i]=Integer.parseInt(reader.readLine());
			count[i]=1;				//每个读入的字符自身至少是长度为1的递增序列
			for(j=i-1;j>=0;j--){
				if(a[i]>a[j] && (count[j]+1)>count[i])    // count[i]的初始值为0
					count[i]=count[j]+1;
			}
			if(count[i]>max)
				max=count[i];
		}
		System.out.println(max);
	}
}