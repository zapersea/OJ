import java.io.*;
import java.util.*;

public class  Nod1002
{
	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		long[][] data=new long[n][n];  //Ҫ��sumֵ��������Ҫlong
		int i,j;
		for(i=0;i<n;i++){
			String[] s=reader.readLine().split(" ");
			//����ֵ
			for(j=0;j<=i;j++)
				data[i][j]=Long.parseLong(s[j]);
			// ���±߽粿��ֵ
			if(i!=0){
				data[i][0]+=data[i-1][0];
				data[i][i]+=data[i-1][i-1];
			}
			// ���ϵ��¸����м䲿��ֵ
			for(j=1;j<i;j++)
				data[i][j]+=Math.max(data[i-1][j-1],data[i-1][j]);
		}
		Arrays.sort(data[n-1]); //����õ����ֵ
		writer.write(data[n-1][n-1]+"\n");
		writer.flush();
	}
}