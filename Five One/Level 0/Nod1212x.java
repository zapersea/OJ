// Kruskal算法得到最小生成树的权值和
import java.io.*;
import java.util.*;

public class  Nod1212x
{	
	public static class vc {
		public int v	;
		public int u;
		public int w;
		
		public vc(){
			this.v=0;
			this.u=0;
			this.w=Integer.MAX_VALUE;
		}

		public vc(int v,int u,int w){
			this.v=v;
			this.u=u;
			this.w=w;
		}
	}
	
	public static void swmp(vc[] data,int start,int end){
		vc temp=data[start];
		data[start] = data[end];
		data[end] = temp;
	}
	//	快排
	public static void quick_sort(vc[] data,int start,int end){
		//判断数组是否为空，数组元素是否为0
		if (data.length < 1 || data == null) {
			return;
		}
		//头指针小于尾指针，则返回
		if (start >= end) {
			return;
		}
		//数组不为空且元素个数大于0
		boolean flag = true;
		int low = start;
		int high = end;
		int key = data[low].w;
		while (low < high) {
			//flag用来判断是否从下标为high的值与基准进行比较
			if (flag) {
				if (data[high].w < key) {
					swmp(data, low, high);
					flag = false;
				} else {
					high--;
				}
			} else {
				//判断下标为low的值是否与基准进行比较。
				if (data[low].w > key) {
					swmp(data, low, high);
					flag = true;
				} else {
					low++;
				}
			}
		}
		quick_sort(data, start, low - 1);
		quick_sort(data, high + 1, end);
	}

	public static void main(String[] args) throws Exception
	{	
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		
		int mark[]=new int[n+1];		//记录每个节点当前所属的树的标志节点，以区别不同树
		vc[] minc=new vc[m+1];		//记录每条边的两个节点和权值
		int i,j,k,x,sum=0;

		for(k=1;k<=m;k++){
			s=reader.readLine().split(" ");
			minc[k]=new vc(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]) );
		}
		quick_sort(minc,1,m);
		
		for(i=1;i<=m;i++){
			j=minc[i].v;
			k=minc[i].u;
			if(mark[j]==mark[k]){
				if(mark[j]==0){				//两个节点都不属于任何树，新建一个树
					mark[j]=j;
					mark[k]=j;
				}else{						//两个节点属于同一个树，忽略这条边
					continue;
				}
			}else{
				if(mark[j]==0)				// v节点不属于任何树，u节点属于一棵树
					mark[j]=mark[k];
				else if(mark[k]==0)
					mark[k]=mark[j];		// u节点不属于任何树，v节点属于一棵树
				else{
					int store=mark[k];		//！！ 一定要用一个变量存mark[k]的值
					for(x=1;x<=n;x++){		// v节点和u节点各属于一棵树，合并，u对应树中所有节点并入v树
						if(mark[x]==store)	//这里不能用mark[k]判断，因为mark[k]在遍历过程中会被改变,需要借助第三方变量
							mark[x]=mark[j];  
					}
				}
			}
			sum+=minc[i].w;
			//System.out.println(i+" : "+minc[i].w+" mark"+j+": "+mark[j]+" mark"+k+": "+mark[k]);
			//for(x=1;x<=n;x++)
				//System.out.println(" mark"+x+"="+mark[x]);
		}

		writer.write(sum+"\n");
		writer.flush();
	}
}
