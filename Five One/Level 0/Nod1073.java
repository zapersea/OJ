//  ��������ͨ�����ֵģ��һ��List
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
			while(f[i]==1){			  //���ѭ���������left-1��ǰ��
				i=i%n+1;	//����left=0������f[i]��ֵ��Ϊ1����ѭ���߲����ж�left>0�ⲽ
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