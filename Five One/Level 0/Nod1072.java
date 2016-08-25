import java.io.*;
import java.util.*;

public class  Nod1072
{
	public static void main(String[] args) throws Exception
	{	
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		int temp;
		double goldenCult=(Math.sqrt(5)+1)/2;  //黄金分割比
		while(n-->0){
			String[] s=reader.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			if(a>b){	//确保 b-a>0
				temp=a;
				a=b;
				b=temp;
			}
			if(a==(int)((b-a)*goldenCult))
				writer.write("B\n");
			else
				writer.write("A\n");	
		}
		writer.flush();
	}
}