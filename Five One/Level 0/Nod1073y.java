import java.io.*;
import java.util.*;

public class Nod1073y
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		sc.close();
		int re=0;
		for(int i=2;i<=n;i++)
			re=(re+m) % i;
		System.out.println(re+1);
	}
}