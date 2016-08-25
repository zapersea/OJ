import java.io.*;
import java.util.*;

public class Nod1284
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long t=0;
		t+=n/2+n/3+n/5+n/7;
		t-=n/(2*3)+n/(2*5)+n/(2*7)+n/(3*5)+n/(3*7)+n/(5*7);
		t+=n/(2*3*5)+n/(2*5*7)+n/(3*5*7)+n/(2*3*7);
		t-=n/(2*3*5*7);
		System.out.println(n-t);
	}
}