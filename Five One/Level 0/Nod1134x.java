import java.io.*;
import java.util.*;

public class  Nod1134x
{
	public static int find(long[] c,int len,long b){
		int left=0,right=len,mid=(left+right)/2;
		while(left<=right){			//这里必须包括=的情况，否则对于left=len=0的情况无法处理
			if(b>c[mid])
				left=mid+1;
			else if(b<c[mid])
				right=mid-1;
			else
				return mid;
			mid=(left+right)/2;
		}
		return left;				//left代表的是小于b的最大数所在位置，用于替换
	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(reader.readLine());
		int i,j,max=0;
		long[] a=new long[N];
		long[] count=new long[N];
		int right=0;
		for(i=0;i<N;i++){
			a[i]=Integer.parseInt(reader.readLine());
			if(i==0) count[0]=a[0];			//设置count[0],否则初始情况无法比较
			j=find(count,right,a[i]);
			count[j]=a[i];
			if(j>right)						//对应在后面插入，len+1 的情况
				right=j;
		}
		System.out.println(right+1);
	}
}