import java.io.*;
import java.util.*;

public class  Nod1240x
{
	//求单个数的莫比乌斯值,非打表
	public static int Mobius(int n){
		int ans=1;
		for(int i=2;i*i<n;i++){
			if(n%(i*i)==0) return 0;
			if(n%i==0) {
				ans=-ans;
				n/=i;
			}
		}
		if(n>1) ans*=-1;
		return ans;
	}

	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		writer.write(Mobius(n)+"\n");
		writer.flush();
	}
}