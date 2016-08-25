//	2016/8/23	11:02
import java.io.*;
import java.util.*;

public class Nod1283
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine()); 
		int length=1,width=n,min=Integer.MAX_VALUE;
		while(length<=width){
			if(length*width==n && length+width<min)
				min=length+width;
			length++;
			width=n/length;
		}
		writer.write(2*min+"\n");
		writer.flush();
	}
}
//	11:11