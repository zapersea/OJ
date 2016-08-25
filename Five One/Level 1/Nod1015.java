//	2016/8/21	17:03
import java.io.*;
import java.util.*;

public class Nod1015
{
	public static int flower(int m){
		char[] data=String.valueOf(m).toCharArray();
		int sum=0;
		for(int i=0;i<data.length;i++)
			sum+=Math.pow((data[i]-'0'),data.length);
		return sum;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		sc.close();
		while(m!=flower(m))
			m++;
		System.out.println(m);
	}
}	
//	17:20