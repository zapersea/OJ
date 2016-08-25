import java.io.*;
import java.util.*;

public class  Nod1106
{
	public static void isPrime(int a){
		int i=2;
		while(i<=Math.sqrt(a)){
			if(a%i==0){
				System.out.println("No");
				return ; 
			}
			i++;
		}
		System.out.println("Yes");
	}

	public static void main(String[] args)  throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		while(N-->0)
			isPrime(Integer.parseInt(reader.readLine()));
	}
}