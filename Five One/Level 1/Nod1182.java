//	2016/8/21	13:58
import java.io.*;
import java.util.*;

public class Nod1182
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		char[] a=s.toCharArray();
		int[] count=new int[26];
		int sum=0;
		for(int i=0;i<a.length;i++){
			int ascii=(a[i]-'A')%('a'-'A');
			count[ascii]+=1;
		}
		Arrays.sort(count);
		for(int i=0;i<26;i++)
			sum+=count[i]*(i+1);
		System.out.println(sum);
	}
}	
//	14:10