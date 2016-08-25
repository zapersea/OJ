import java.io.*;
import java.util.*;

public class  Nod1240
{
	//莫比乌斯函数
	public static void Mobius(int[] visit,int[] mobi,int[] prime,int n){
		int index=0;
		mobi[1]=1;
		for(int i=2;i<=n;i++){
			if(visit[i]==0){
				prime[index++]=i;
				mobi[i]=-1;  // 素数的质因数分解是它本身，只有一个质因子，故为-1
			}
			for(int j=0;j<index && i*prime[j]<=n;j++){
				visit[i*prime[j]]=1;	// 表明i*prime[j]不是质数
				if(i%prime[j]==0){	
					mobi[i*prime[j]]=0;
					break;	
					// 这个break很关键，因为如果i%prime[j]==0，对于所有的j,都有mobi[i*prime[j]]=0
					// 而所有mobi[i*prime[j]]的初始值恰好都是0，所以直接跳过不处理即可
				}
				else mobi[i*prime[j]]=-mobi[i];
				// 如果k>j,i%prime[k]==0,但是i%prime[j]!=0,没关系
				// 因为这时候mobi[i]肯定等于0,所以mobi[i*prime[j]]还是等于0
			}
		}
	}

	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		int[] visit=new int[n+1];
		int[] mobi=new int[n+1];
		int[] prime=new int[n];
		Mobius(visit,mobi,prime,n);
		writer.write(mobi[n]+"\n");
		writer.flush();
	}
}