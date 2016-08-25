import java.io.*;
import java.util.*;

public class  Nod1135
{
	static int primeNum;

	// 质因子分解
	public static void pri_element(int n,int[] priEle){
		primeNum=0;
		int max=(int)Math.sqrt(n);// 如果用i*i<=n，判断，i*i可能会超出int范围出错
		for(int i=2;i<=max&&n>1;i++){ 
			if(n%i==0){
				priEle[primeNum++]=i;
				while(n%i==0)
					n=n/i;
			}
		}
		//if(n>1) priEle[primeNum++]=n;
	}

	public static long quick_mod(long a,long r,long mod){
		long ans=1;
		long plus=a;
		while(r>0){
			if(r%2==1)
				ans=(ans*a)%mod;	
			r=r/2;
			a=(a*a)%mod;	//此处a*a可能超出int范围，所以全部变量改用long
		}
		return ans;
	}

	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int p=Integer.parseInt(reader.readLine());
		int[] priEle=new int[(int)Math.sqrt(p)];	//如果是new int[p] ，heap size会超出报错
		pri_element(p-1,priEle);  //对p-1质因子分解，得到它的质因子
		for(int i=2;i<p;i++){
			if(quick_mod(i,p-1,p)==1){
				boolean flag=true;
				for(int j=0;j<primeNum;j++){
					if(quick_mod(i,(p-1)/priEle[j],p)==1){
						flag=false;
						break;
					}
				}
				if(flag==true){
					writer.write(i+"\n");
					break; //原根是满足条件的最小值，所以第一个满足条件就是原根，结束查找
				}
			}
		}
		writer.flush();
	}
}