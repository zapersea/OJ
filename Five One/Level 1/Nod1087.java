//	2016/8/22	10:45
import java.io.*;
import java.util.*;

public class Nod1087
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int t=Integer.parseInt(reader.readLine());
		while(t-->0){
			int n=Integer.parseInt(reader.readLine());
			n=2*(n-1);
			int tmp=(int)Math.sqrt(n);
			if(tmp*(tmp+1)==n)
				writer.write("1\n");
			else
				writer.write("0\n");
		}
		writer.flush();
	}
}
//	11:01