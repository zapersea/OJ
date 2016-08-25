//	2016/8/21	10:46
import java.io.*;
import java.util.*;

public class Nod1003
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int total5=0,i=1;
		while(Math.pow(5,i)<=n){
			total5+=n/Math.pow(5,i);
			i++;
		}
		System.out.println(total5);
	}
}	
// 11:32