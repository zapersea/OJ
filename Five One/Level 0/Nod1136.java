import java.io.*;
import java.util.*;

public class  Nod1136
{
	public static int Phi(int n){
		int re=n;
		for(int i=2;i*i<=n;i++){
			if(n%i==0)
				re=re-re/i;
			while(n%i==0){
				n=n/i;
			}
		}
		if(n>1)
			re=re-re/n;
		return re;
	}

	public static void main(String[] args) throws Exception
	{			
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		writer.write(Phi(n)+"\n");
		writer.flush();
	}
}