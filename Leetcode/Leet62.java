import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet62
{
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
		for(int i=0;i<m;i++)
			dp[i][0]=1;
		for(int i=0;i<n;i++)
			dp[0][i]=1;
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
				dp[i][j]=dp[i-1][j]+dp[i][j-1];
		return dp[m-1][n-1];
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		System.out.println(uniquePaths(3,7));
		reader.close();
	}
}