//	2016/9/6	17:03
import java.io.*;
import java.util.*;

public class  ccf2015031
{
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int n =Integer.parseInt(s[0]);
		int m =Integer.parseInt(s[1]);
		int[][] a=new int[n][m];
		int i,j;
		for(i=0;i<n;i++){
			String[] t=reader.readLine().split(" ");
			for(j=0;j<m;j++)
				a[i][j]=Integer.parseInt(t[j]);
		}
		for(j=m-1;j>=0;j--){
			for(i=0;i<n-1;i++)
				writer.write(a[i][j]+" ");
			writer.write(a[n-1][j]+"\n");
		}
		writer.flush();
		reader.close();
	}
}
//	17:12