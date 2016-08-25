//	2016/8/23	11:26
import java.io.*;
import java.util.*;

public class Nod1090
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine()); 
		int[] a=new int[n];
		int i,j,k,count=0;
		for(i=0;i<n;i++)
			a[i]=Integer.parseInt(reader.readLine());
		Arrays.sort(a);
		i=0;
		while(a[i]<0){
			j=i+1;
			k=n-1;
			while(j<k){
				if(a[i]+a[j]+a[k]==0){
					writer.write(a[i]+" "+a[j]+" "+a[k]+"\n");
					j++;
					k--;
					count++;
				}
				else if(a[i]+a[j]+a[k]<0)
					j++;
				else
					k--;
			}
			i++;
		}
		if(count==0)
			writer.write("No Solution");
		writer.flush();
	}
}
//	11:39