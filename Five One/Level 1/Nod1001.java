//	2016/8/20	21:44
import java.io.*;
import java.util.*;

public class  Nod1001
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int k=Integer.parseInt(s[0]);
		int n=Integer.parseInt(s[1]);
		int[] data=new int[n];
		int[] left=new int[n];
		int[] right=new int[n];
		int i,j,pairNum=0,leftIndex,rightIndex;
		for(i=0;i<n;i++)
			data[i]=Integer.parseInt(reader.readLine());
		Arrays.sort(data);
		i=0;
		while(i<=n-1 && data[i]<k/2) // �����и��ӣ����data����������С��k/2����ôi��ȡ��n
			i++;					//	�Ӷ��������Խ�磬�����Ҫ�ж�data[i]ǰ���ж�i
		rightIndex=i;
		leftIndex=i-1;
		while(leftIndex>=0 && rightIndex<=n-1){
			int sum=data[leftIndex]+data[rightIndex];
			if(sum==k){
				left[pairNum]=data[leftIndex];
				right[pairNum++]=data[rightIndex];
				leftIndex--;
				rightIndex++;
			}
			else if(sum<k )
				rightIndex++;
			else
				leftIndex--;
		}
		if(pairNum==0)
			writer.write("No Solution");
		else{
			for(i=pairNum-1;i>=0;i--)
				writer.write(left[i]+" "+right[i]+"\n");
		}
		writer.flush();
	}
}
//	22:33