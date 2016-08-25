import java.io.*;
import java.util.*;

public class  Nod1242
{	
	static int mod=1000000009;
	
	//矩阵相乘
	public static long[][] multi(long[][] a, long[][] b,int n){ 
		long[][] re=new long[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<n;k++)
					re[i][j]=( re[i][j] +(a[i][k]*b[k][j])%mod )%mod;
			}
		}
		return re;
	}
		
	public static long Fibonacci(long n){
		long[][] E={{1,0},{0,1}};  // 单位矩阵 
		long[][] re=E;	//结果矩阵,初始值为单元矩阵
		long[][] feb={{1,1},{1,0}}; //底数矩阵
		while(n>0){
			if((n&1)==1) { //这里必须加括号
				re=multi(re,feb,2);
			}
			else re=multi(re,E,2);  //可省略
			n=n/2;
			feb=multi(feb,feb,2);
		}
		return re[0][0];
	}			

	public static void main(String[] args) throws Exception
	{			
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		long n=Long.parseLong(reader.readLine());
		writer.write(Fibonacci(n-1)+"\n"); //re[0][0]最后是F(n+1),想得到F(n)所以传入n-1
		writer.flush();
	}
}