import java.io.*;
import java.util.*;

public class  Nod1130
{
	public static void main(String[] args) throws Exception
	{	
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int num=Integer.parseInt(reader.readLine());
		while(num-->0){
			int n=Integer.parseInt(reader.readLine());
			//注意结果会是long类型，而不是int
			writer.write((long)(0.5*Math.log10(2*Math.PI*n)+n*Math.log10(n/Math.E))+1+"\n");
		}
		writer.flush();
	}
}