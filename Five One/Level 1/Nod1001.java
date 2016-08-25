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
		while(i<=n-1 && data[i]<k/2) // 这里有个坑，如果data中所有数都小于k/2，那么i会取到n
			i++;					//	从而数组访问越界，因此需要判断data[i]前先判断i
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