// Prime�㷨�õ���С��������Ȩֵ��
import java.io.*;
import java.util.*;

public class  Nod1212
{
	public static void main(String[] args) throws Exception
	{	
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int[][] cost=new int[n+1][n+1];
		int[] minc=new int[n+1];	//ÿ���ڵ��뵱ǰ����������С����
		int i,j,k,last=n-1,index,min,sum=0;

		for(k=1;k<=n;k++)
			minc[k]=Integer.MAX_VALUE;
		for(k=1;k<=m;k++){
			s=reader.readLine().split(" ");
			i=Integer.parseInt(s[0]);
			j=Integer.parseInt(s[1]);
			cost[i][j]=Integer.parseInt(s[2]);			//����ͼ
			cost[j][i]=Integer.parseInt(s[2]);
			if(i==1)
				minc[j]=Integer.parseInt(s[2]);
		}

		while(last>0){		//����last������ֱ��ѭ��n-1��Ҳ�У���Ϊ����ͨͼ������ÿ��index����ȡ��
			min=Integer.MAX_VALUE;
			index=0;
			for(i=2;i<=n;i++){
				if(minc[i]!=0&&minc[i]<min){		//minc[i]==0��Ϊi�ڵ��Ѿ���������ı�־
					min=minc[i];
					index=i;
				}
			}
			if(index!=0){
				last-=1;
				sum+=minc[index];
				minc[index]=0;
			}
			for(i=2;i<=n;i++){		//ͨ�����¼������Ľڵ�Ƚϣ�����ʣ��ÿ���ڵ��뵱ǰ����������С����
				if(minc[i]!=0&&cost[index][i]!=0&&cost[index][i]<minc[i])	//��(index,i)���ܲ����ڣ��������ж�cost[index][i]!=0
					minc[i]=cost[index][i];	
			}
		}
		writer.write(sum+"\n");
		writer.flush();
	}
}