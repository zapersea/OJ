import java.io.*;
import java.util.*;
import java.math.*;

public class  Nod1185
{
	public static void main(String[] args) throws Exception
	{	
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		long temp;
		BigDecimal g = new BigDecimal("1.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911374");  
		while(n-->0){
			String[] s=reader.readLine().split(" ");
			long a=Long.parseLong(s[0]);
			long b=Long.parseLong(s[1]);
			if(a>b){	//È·±£ b-a>0
				temp=a;
				a=b;
				b=temp;
			}
			long result=g.multiply(new BigDecimal(b-a)).longValue();
			if(a==result)
				writer.write("B\n");
			else
				writer.write("A\n");	
		}
		writer.flush();
	}
}