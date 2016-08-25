import java.io.*;
import java.util.*;

public class  Nod1136x
{
	public static int[] Phi(int n){
		int[] re=new int[n+1];
		re[1]=1;
		for(int i=2;i<=n;i++){	//打表出每个数的互质数个数,O(nloglogn)的时间计算完   
			if(re[i]==0){		// i=2肯定是质数
				for(int j=i;j<=n;j+=i){		//这里区别与素数打表，素数打表是从i*i开始
					if(re[j]==0)
						re[j]=j;
					re[j]-=re[j]/i;
				}
			}
		}
		return re;
	}

	public static void main(String[] args) throws Exception
	{			
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		int[] re=Phi(n);
		writer.write(re[n]+"\n");
		writer.flush();
	}
}