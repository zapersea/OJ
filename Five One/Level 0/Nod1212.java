// Prime算法得到最小生成树的权值和
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
		int[] minc=new int[n+1];	//每个节点与当前生成树的最小距离
		int i,j,k,last=n-1,index,min,sum=0;

		for(k=1;k<=n;k++)
			minc[k]=Integer.MAX_VALUE;
		for(k=1;k<=m;k++){
			s=reader.readLine().split(" ");
			i=Integer.parseInt(s[0]);
			j=Integer.parseInt(s[1]);
			cost[i][j]=Integer.parseInt(s[2]);			//无向图
			cost[j][i]=Integer.parseInt(s[2]);
			if(i==1)
				minc[j]=Integer.parseInt(s[2]);
		}

		while(last>0){		//不用last计数，直接循环n-1次也行，因为是联通图，所以每次index都能取到
			min=Integer.MAX_VALUE;
			index=0;
			for(i=2;i<=n;i++){
				if(minc[i]!=0&&minc[i]<min){		//minc[i]==0作为i节点已经在树里面的标志
					min=minc[i];
					index=i;
				}
			}
			if(index!=0){
				last-=1;
				sum+=minc[index];
				minc[index]=0;
			}
			for(i=2;i<=n;i++){		//通过与新加入树的节点比较，更新剩余每个节点与当前生成树的最小距离
				if(minc[i]!=0&&cost[index][i]!=0&&cost[index][i]<minc[i])	//边(index,i)可能不存在，别忘了判断cost[index][i]!=0
					minc[i]=cost[index][i];	
			}
		}
		writer.write(sum+"\n");
		writer.flush();
	}
}