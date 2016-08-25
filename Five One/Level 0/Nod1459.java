import java.io.*;
import java.util.*;

public class  Nod1459
{
	public static void initialize_single_source(int n,int start,int[] parent,int[] dis){
		for(int i=0;i<n;i++){
			if(i==start){
				parent[i]=i;
				dis[i]=0;
			}else{
				parent[i]=-1;
				dis[i]=Integer.MAX_VALUE;
			}
		}
	}
	
	public static int extract_min(List<Integer> list,int[] dis){
		int index=-1,mindis=Integer.MAX_VALUE,maxscore=-1;
		for(int i : list){
			//���ﲻ��Ҫ�ж�score��score��������ɳڲ����жϼ���
			if(dis[i]<mindis){
				index=i;	
				mindis=dis[i];
			}
		}
		//System.out.println(list+"* "+index);
		return index;
	}

	public static void dijkstra(int n,int start,int[] score,int[][] path,int[] parent,int[] dis,int[] allscore){
		initialize_single_source(n,start,parent,dis);
		List<Integer> L=new LinkedList<Integer>();
		int i,j,index;
		for(i=0;i<n;i++)
			L.add(i);
		while(!L.isEmpty()){
			index=extract_min(L,dis);
			L.remove((Integer)index);
			//!!! iһ������ȡL�����Ԫ�أ�������Щȷ�����·���ĵ��parent�ᱻ����
			for(int k=0;k<n;k++){	
				if(path[index][k]!=0){	//������index�б������Ľڵ㣬�ɳ�
					 // =�Ų�����,������score[index]>score[parent[k]]�ж�
					if((dis[k]>dis[index]+path[index][k])||( dis[k]==dis[index]+path[index][k] 
						&& allscore[index]+score[k]>allscore[k] )){
						parent[k]=index;
						dis[k]=dis[index]+path[index][k];
						allscore[k]=allscore[index]+score[k];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int start=sc.nextInt();
		int end=sc.nextInt();
		int[] score=new int[n];		//��Ȩֵ
		int[][] path=new int[n][n];   //��Ȩֵ
		int[] parent=new int[n];    //�����������·���ϵ���һ���ڵ�
		int[] dis=new int[n];	    //�����㵽Դ�ڵ�ľ���
		int[] allscore=new int[n];
		int i,j,k;
		for(i=0;i<n;i++){
			score[i]=sc.nextInt();
			allscore[i]=score[i];
		}
		for(i=0;i<m;i++){
			j=sc.nextInt();
			k=sc.nextInt();
			path[j][k]=sc.nextInt();
			path[k][j]=path[j][k];
		}
		sc.close();
		dijkstra(n,start,score,path,parent,dis,allscore); //��scoreҲ��Ϊ̰��ʱ��Ŀ�������
		k=end;
		/*while(k!=start){
			System.out.println("k= "+k+" parent[k]="+parent[k]);
			k=parent[k];
		}*/
		System.out.println(dis[end]+" "+allscore[end]);
	}

}
1647997645