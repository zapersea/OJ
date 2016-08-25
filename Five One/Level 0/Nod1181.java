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
				//�������i��ʼ��ŷ���������
				//���ں��溬��<i�����ӵķ�ָ����ǰ���ѭ���Ѿ������꣬������С����i*i
				// ����i�ķ�Χ��10^6����ôi*iΪ10^12�����ܳ���int��Χ,������Ҫ�ж�
				if(i<=(int)Math.sqrt(maxn)){
					for(int j=i*i;j<maxn;j+=i) 
						mark[j]=1;  // ���Ϊ������
				}
			}
		}
	}

	public static int getPrime(int n){
		int pos,i=0;
		while(prime[i]<n)  //����ȷ��n���������е�λ��pos���ǵڼ���
			i++;
		pos=i+1;		//�õ���i���±꣬�������������ŵ�i+1��
		i=0;
		while(prime[i]<pos)	//Ȼ��ȷ����������ֵ�պò�С��pos������
			i++;			//����������ĿҪ������������������ŵ�prime[i]��Ԫ��
		return prime[prime[i]-1]; // ��prime[i]��Ԫ��,�±���prime[i]-1
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