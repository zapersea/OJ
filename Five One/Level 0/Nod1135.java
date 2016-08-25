import java.io.*;
import java.util.*;

public class  Nod1135
{
	static int primeNum;

	// �����ӷֽ�
	public static void pri_element(int n,int[] priEle){
		primeNum=0;
		int max=(int)Math.sqrt(n);// �����i*i<=n���жϣ�i*i���ܻᳬ��int��Χ����
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
			a=(a*a)%mod;	//�˴�a*a���ܳ���int��Χ������ȫ����������long
		}
		return ans;
	}

	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int p=Integer.parseInt(reader.readLine());
		int[] priEle=new int[(int)Math.sqrt(p)];	//�����new int[p] ��heap size�ᳬ������
		pri_element(p-1,priEle);  //��p-1�����ӷֽ⣬�õ�����������
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
					break; //ԭ����������������Сֵ�����Ե�һ��������������ԭ������������
				}
			}
		}
		writer.flush();
	}
}