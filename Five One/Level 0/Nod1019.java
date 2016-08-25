import java.io.*;
import java.util.*;

public class  Nod1019
{
	static int count=0;

	public static void mergeSort(long[] a,long[] aux,int lo,int hi){
		if (hi <= lo)	return;   //������Ҫ������������������������lo==hi��ʱ��Ԫ�����ֻ��1����ʱ����Ҫ����
		int mid=(lo+hi)/2;
		mergeSort(a,aux,lo,mid);
		mergeSort(a,aux,mid+1,hi);
		merge(a,aux,lo,mid,hi);
	}

	public static void merge(long[] a,long[] aux,int lo ,int mid,int hi){
		int k;
		int i=lo;
		int j=mid+1;
		for(k=lo;k<=hi;k++){
			aux[k]=a[k];
		}
		k=lo;
		while(k<=hi){
			if(i>mid) 
				a[k++]=aux[j++];
			else if(j>hi) 
				a[k++]=aux[i++];	  
			else if(aux[i]<=aux[j]) 
				a[k++]=aux[i++];
			else {
				a[k++]=aux[j++];
				count+=mid-i+1;    // !! ����1�д�i��midһ���У�mid-i+1) ����������2�е�j��
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(reader.readLine());
		long[] a=new long[N];
		long[] aux=new long[N];
		for(int i=0;i<N;i++){
			a[i]=Integer.parseInt(reader.readLine());
		}
		mergeSort(a,aux,0,a.length-1);
        System.out.println(count);
	}
}