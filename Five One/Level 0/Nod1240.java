import java.io.*;
import java.util.*;

public class  Nod1240
{
	//Ī����˹����
	public static void Mobius(int[] visit,int[] mobi,int[] prime,int n){
		int index=0;
		mobi[1]=1;
		for(int i=2;i<=n;i++){
			if(visit[i]==0){
				prime[index++]=i;
				mobi[i]=-1;  // �������������ֽ���������ֻ��һ�������ӣ���Ϊ-1
			}
			for(int j=0;j<index && i*prime[j]<=n;j++){
				visit[i*prime[j]]=1;	// ����i*prime[j]��������
				if(i%prime[j]==0){	
					mobi[i*prime[j]]=0;
					break;	
					// ���break�ܹؼ�����Ϊ���i%prime[j]==0���������е�j,����mobi[i*prime[j]]=0
					// ������mobi[i*prime[j]]�ĳ�ʼֵǡ�ö���0������ֱ��������������
				}
				else mobi[i*prime[j]]=-mobi[i];
				// ���k>j,i%prime[k]==0,����i%prime[j]!=0,û��ϵ
				// ��Ϊ��ʱ��mobi[i]�϶�����0,����mobi[i*prime[j]]���ǵ���0
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