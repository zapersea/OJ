// Kruskal�㷨�õ���С��������Ȩֵ��
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
	//	����
	public static void quick_sort(vc[] data,int start,int end){
		//�ж������Ƿ�Ϊ�գ�����Ԫ���Ƿ�Ϊ0
		if (data.length < 1 || data == null) {
			return;
		}
		//ͷָ��С��βָ�룬�򷵻�
		if (start >= end) {
			return;
		}
		//���鲻Ϊ����Ԫ�ظ�������0
		boolean flag = true;
		int low = start;
		int high = end;
		int key = data[low].w;
		while (low < high) {
			//flag�����ж��Ƿ���±�Ϊhigh��ֵ���׼���бȽ�
			if (flag) {
				if (data[high].w < key) {
					swmp(data, low, high);
					flag = false;
				} else {
					high--;
				}
			} else {
				//�ж��±�Ϊlow��ֵ�Ƿ����׼���бȽϡ�
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
		
		int mark[]=new int[n+1];		//��¼ÿ���ڵ㵱ǰ���������ı�־�ڵ㣬������ͬ��
		vc[] minc=new vc[m+1];		//��¼ÿ���ߵ������ڵ��Ȩֵ
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
				if(mark[j]==0){				//�����ڵ㶼�������κ������½�һ����
					mark[j]=j;
					mark[k]=j;
				}else{						//�����ڵ�����ͬһ����������������
					continue;
				}
			}else{
				if(mark[j]==0)				// v�ڵ㲻�����κ�����u�ڵ�����һ����
					mark[j]=mark[k];
				else if(mark[k]==0)
					mark[k]=mark[j];		// u�ڵ㲻�����κ�����v�ڵ�����һ����
				else{
					int store=mark[k];		//���� һ��Ҫ��һ��������mark[k]��ֵ
					for(x=1;x<=n;x++){		// v�ڵ��u�ڵ������һ�������ϲ���u��Ӧ�������нڵ㲢��v��
						if(mark[x]==store)	//���ﲻ����mark[k]�жϣ���Ϊmark[k]�ڱ��������лᱻ�ı�,��Ҫ��������������
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
