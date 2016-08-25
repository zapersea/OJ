//	2016/8/20	21:44
import java.io.*;
import java.util.*;

public class  Nod1001x
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
		leftIndex=0;
		rightIndex=n-1;
		while(leftIndex<rightIndex){
			int sum=data[leftIndex]+data[rightIndex];
			if(sum==k){
				left[pairNum]=data[leftIndex];
				right[pairNum++]=data[rightIndex];
				leftIndex++;
				rightIndex--;
			}
			else if(sum<k )
				leftIndex++;
			else
				rightIndex--;
		}
		if(pairNum==0)
			writer.write("No Solution");
		else{
			for(i=0;i<pairNum;i++)
				writer.write(left[i]+" "+right[i]+"\n");
		}
		writer.flush();
	}
}
//	22:33