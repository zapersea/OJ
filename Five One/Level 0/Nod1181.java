import java.io.*;
import java.util.*;

public class Nod1181 
{
	static int maxn=1000100;
	static int index=0;
	static int[] mark=new int[maxn];
	static int[] prime=new int[maxn];

	public static void printTable(){
		for(int i=2;i<maxn;i++){
			if(mark[i]==0){	 
				prime[index++]=i;
				//区别与从i开始的欧拉函数打表
				//由于后面含有<i的因子的非指数在前面的循环已经处理完，所以最小的是i*i
				// 但是i的范围是10^6，那么i*i为10^12，可能超出int范围,所以需要判断
				if(i<=(int)Math.sqrt(maxn)){
					for(int j=i*i;j<maxn;j+=i) 
						mark[j]=1;  // 标记为非质数
				}
			}
		}
	}

	public static int getPrime(int n){
		int pos,i=0;
		while(prime[i]<n)  //首先确定n在质数表中的位置pos，是第几个
			i++;
		pos=i+1;		//得到的i是下标，即在质数表中排第i+1个
		i=0;
		while(prime[i]<pos)	//然后确定质数表中值刚好不小于pos的质数
			i++;			//即，满足题目要求的质数在质数表中排第prime[i]个元素
		return prime[prime[i]-1]; // 第prime[i]个元素,下标是prime[i]-1
	}


	public static void main(String[] args) throws Exception {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		printTable();
		writer.write(getPrime(n)+"\n");
		writer.flush();
	}
}