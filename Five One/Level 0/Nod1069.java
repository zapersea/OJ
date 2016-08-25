import java.io.*;
import java.util.*;

public class  Nod1069
{
	public static void main(String[] args) throws Exception
	{			
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		int re=Integer.parseInt(reader.readLine());
		for(int i=1;i<n;i++){
			re=re^Integer.parseInt(reader.readLine());
		}
		if(re==0)
			writer.write("B\n");
		else 
			writer.write("A\n");
		writer.flush();
	}
}