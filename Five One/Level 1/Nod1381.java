import java.io.*;
import java.util.*;

public class Nod1381
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		long n=Long.parseLong (reader.readLine()); 
		while(n-->0){
			long t=Long.parseLong (reader.readLine());
			writer.write(2*t+"\n");
		}
		writer.flush();
	}
}