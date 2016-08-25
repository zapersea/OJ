//	2016/8/23	11:53
import java.io.*;
import java.util.*;

public class Nod1009
{
	public static int count99(int n){
		int ans=n;
		while(n-->1){
			ans*=10;
		}
		return ans;
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i,j,k,count=0,ans=0;
		char[] cn=String.valueOf(n).toCharArray();
		int length=cn.length;
		int[] a=new int[length];
		int[] dp=new int[length+1];	//dp[i][j]为j开头的i位数中1的最大数
		for(i=length-1;i>=0;i--)
			a[i]=cn[i]-'0';
		if(a[length-1]>=1)
			dp[1]=1;
		for(i=2;i<=length;i++){
			int data=a[length-i];
			if(data==0)
				dp[i]+=dp[i-1];
			else if(data==1){
				dp[i]+=count99(i-1);
				int tmp=(int)Math.pow(10,i-1);
				int start1=n-(n/tmp)*tmp+1;
				dp[i]+=start1+dp[i-1];
			}
			else{
				dp[i]+=count99(i-1);
				int tmp=(int)Math.pow(10,i-1);
				dp[i]+=tmp+count99(i-1);
				for(k=2;k<data;k++)
						dp[i]+=count99(i-1);
				dp[i]+=dp[i-1];
			}
		}
		System.out.println(dp[length]);
	}

}
//,12:08