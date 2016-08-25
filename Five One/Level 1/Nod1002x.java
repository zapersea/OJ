import java.io.*;
import java.util.*;

public class  Nod1002x
{
	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		long[][] data=new long[n][n];  //要存sum值，所以需要long
		int i,j;
		for(i=0;i<n;i++){
			String[] s=reader.readLine().split(" ");
			//输入值
			for(j=0;j<=i;j++)
				data[i][j]=Long.parseLong(s[j]);
		}
		// 从下到上更新所有值
		for(i=n-2;i>=0;i--){
			for(j=0;j<=i;j++)
				data[i][j]+=Math.max(data[i+1][j],data[i+1][j+1]);
		}
		writer.write(data[0][0]+"\n");
		writer.flush();
	}
}