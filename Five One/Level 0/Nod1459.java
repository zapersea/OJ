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
			//这里不需要判断score，score的最大在松弛部分判断即可
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
			//!!! i一定不能取L以外的元素，否则哪些确定最短路径的点的parent会被重置
			for(int k=0;k<n;k++){	
				if(path[index][k]!=0){	//遍历与index有边相连的节点，松弛
					 // =号不能少,不能用score[index]>score[parent[k]]判断
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
		int[] score=new int[n];		//点权值
		int[][] path=new int[n][n];   //边权值
		int[] parent=new int[n];    //各个点在最短路径上的上一个节点
		int[] dis=new int[n];	    //各个点到源节点的距离
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
		dijkstra(n,start,score,path,parent,dis,allscore); //把score也作为贪心时候的考虑条件
		k=end;
		/*while(k!=start){
			System.out.println("k= "+k+" parent[k]="+parent[k]);
			k=parent[k];
		}*/
		System.out.println(dis[end]+" "+allscore[end]);
	}

}
1647997645