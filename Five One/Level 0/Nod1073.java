//  土方法，通过标记值模拟一个List
import java.io.*;
import java.util.*;

public class  Nod1073
{
	public static void main(String[] args) throws IOException
	{	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		sc.close();
		int[] f=new int[n+1];
		int i=1,count=0,left=n,lastone=0;
		while(left>0){
			while(f[i]==1){			  //这个循环必须放在left-1的前面
				i=i%n+1;	//否则当left=0，所有f[i]的值都为1，死循环走不到判断left>0这步
			}		
			count++;
			if(count==k){
				f[i]=1;
				count=0;
				left-=1;
			}
			if(left==0)	lastone=i;
			i=i%n+1;
		}
		System.out.println(lastone);
	}
}