import java.io.*;
import java.util.*;

public class  Nod1242
{	
	static int mod=1000000009;
	
	//�������
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
		long[][] E={{1,0},{0,1}};  // ��λ���� 
		long[][] re=E;	//�������,��ʼֵΪ��Ԫ����
		long[][] feb={{1,1},{1,0}}; //��������
		while(n>0){
			if((n&1)==1) { //������������
				re=multi(re,feb,2);
			}
			else re=multi(re,E,2);  //��ʡ��
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
		writer.write(Fibonacci(n-1)+"\n"); //re[0][0]�����F(n+1),��õ�F(n)���Դ���n-1
		writer.flush();
	}
}