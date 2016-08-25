//	2016/8/21	16:26
import java.io.*;
import java.util.*;

public class Nod1083
{
	public static void main(String[] args) throws Exception {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		int[][] data=new int[n][n];
		int i,j;
		for(i=0;i<n;i++){	//输入数据
			String[] s=reader.readLine().split(" ");
			for(j=0;j<n;j++)
				data[i][j]=Integer.parseInt(s[j]);
		}
		for(i=1;i<n;i++){	//初始化第0行和第0列的数据
			data[0][i]+=data[0][i-1];
			data[i][0]+=data[i-1][0];
		}
		for(i=1;i<n;i++){	//从第1行，第1列开始dp，更新数据
			for(j=1;j<n;j++)
				data[i][j]+=Math.max(data[i][j-1],data[i-1][j]);
		}
		writer.write(data[n-1][n-1]+"\n");
		writer.flush();
	}
}
//	16:42