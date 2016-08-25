import java.io.*;
import java.util.*;

public class  Nod1066
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(reader.readLine());
		while(N-->0){
			String[] s=reader.readLine().split(" ");
			if( Integer.parseInt(s[0]) % (Integer.parseInt(s[1])+1) == 0)
				System.out.println("B");
			else
				System.out.println("A");
		}
	}
}