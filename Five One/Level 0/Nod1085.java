import java.io.*;
import java.util.*;

public class  Nod1085
{
	public static int maxValue(int a,int b){
		return a>b?a:b;
	}
	
	public static int countPack(int[] W,int[] P,int[][] C,int n,int v){
		if (C[n][v]!=-1)	return C[n][v];
		else if (n==1){
			if(W[n]<=v){ 
				C[n][v]=P[n];
			}else
				C[n][v]=0;
		}
		else if (W[n]>v)
			C[n][v]=countPack(W,P,C,n-1,v);
		else 
			C[n][v]=maxValue(countPack(W,P,C,n-1,v-W[n])+P[n],countPack(W,P,C,n-1,v));
		return C[n][v];
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int V=sc.nextInt();
		int[] W=new int[N+1];
		int[] P=new int[N+1];
		int[][] C=new int[N+1][V+1];
		int i=1;
		int j=1;
		while(i<=N){
			W[i]=sc.nextInt();
			P[i]=sc.nextInt();
			j=1;			// ！！这里j一定别忘了重新赋1，否则无法完全初始化
			while(j<=V){
				C[i][j]=-1;
				j++; 
			}
			i++;
		}
		sc.close();
		System.out.println(countPack(W,P,C,N,V));
	}
}
	