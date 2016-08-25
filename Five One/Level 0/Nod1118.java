import java.io.*;
import java.util.*;

public class  Nod1118
{
	static final int mod=1000000007;

	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int m=Integer.parseInt(s[0]);
		int n=Integer.parseInt(s[1]);
		int[][] re=new int[m+1][n+1];
		int i,j;

		for(i=1;i<=m;i++)
			re[i][1]=1;
		for(i=1;i<=n;i++)
			re[1][i]=1;
		for(i=2;i<=m;i++){
			for(j=2;j<=n;j++){
				re[i][j]=(re[i-1][j]%mod+re[i][j-1]%mod)%mod;			// 由于加完的和可能大于Int的最大值，所以需要模
			}
		}
		writer.write(re[m][n]%mod+"\n");
		writer.flush();
	}
}