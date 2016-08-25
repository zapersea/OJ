//  2016/8/20	
//	15:50
import java.io.*;
import java.util.*;

public class Nod1004
{
	public static long quickMod(long a,long b,long mod){
		long ans=1;
		while(b>0){
			if(b%2==1)
				ans=(ans*a)%mod;
			b=b/2;
			a=(a*a)%mod;
		}
		return ans;
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		System.out.println(quickMod(n%10,n,10));
	}
}
//	16:00