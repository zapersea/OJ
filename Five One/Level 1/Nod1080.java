//	2016/8/22	10:13
import java.io.*;
import java.util.*;

public class Nod1080  
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=sc.nextInt();
		sc.close();
		int i=0,j=(int)Math.sqrt(n);
		int count=0;
		while(i<=j){	// 题目中说i可以等于j
			if(i*i+j*j==n){
				writer.write(i+" "+j+"\n");
				i++;
				j--;
				count++;
			}
			else if(i*i+j*j<n)
				i++;
			else	
				j--;
		}
		if(count==0)
			writer.write("No Solution");
		writer.flush();
	}
}
//	10:26