//	2016/8/21	10:46
import java.io.*;
import java.util.*;

public class Nod1003x
{
	public static int elementNum(int p,int ele){
		int num=0;
		while(p%ele==0){
			num++;
			p=p/ele;
		}
		return num;
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int num2=0,num5=0;
		for(int i=2;i<=n;i++){
			num2+=elementNum(i,2);
			num5+=elementNum(i,5);
		}
		System.out.println(Math.min(num2,num5));
	}
}