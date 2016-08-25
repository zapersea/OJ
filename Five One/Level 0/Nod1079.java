import java.io.*;
import java.util.*;

public class  Nod1079
{
	static long x,y;

	//扩展欧几里德算法
	public static long extend_gcd(long a,long b){
		if(b==0){
			x=1;
			y=0;
			return a;
		}
		long ret=extend_gcd(b,a%b);
		long temp=x-a/b*y;
		x=y;
		y=temp;
		return ret;
	}
	
	public static void main(String[] args) throws Exception
	{	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();		
		int i;
		long[] a=new long[n];
		long[] m=new long[n];
		long sum=1,ans=0;	  //一定要用long，不然sum和ans会超
		for(i=0;i<n;i++){
			m[i]=sc.nextLong();
			sum*=m[i];
			a[i]=sc.nextLong();
		}
		for(i=0;i<n;i++){
			long mi=sum/m[i];
			extend_gcd(mi,m[i]);
			ans=(ans+a[i]*mi*x)%sum;
		}
		if(ans<0) ans+=sum;
		System.out.println(ans);
		sc.close();
	}
}