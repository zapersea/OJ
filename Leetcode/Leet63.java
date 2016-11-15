import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet63
{
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int i,m=obstacleGrid.length,n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
		for(i=0;i<m && obstacleGrid[i][0]==0;i++)
			dp[i][0]=1;
		for(;i<m;i++)
			dp[i][0]=0;
		for(i=0;i<n && obstacleGrid[0][i]==0;i++)
			dp[0][i]=1;
		for(;i<n;i++)
			dp[0][i]=0;
		for(i=1;i<m;i++)
			for(int j=1;j<n;j++)
				dp[i][j]=(1-obstacleGrid[i-1][j])*dp[i-1][j]+(1-obstacleGrid[i][j-1])*dp[i][j-1];
		return (1-obstacleGrid[m-1][n-1])*dp[m-1][n-1];   //目标节点的obstacleGrid值也要判断
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		//int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
		int[][] obstacleGrid={{1}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
		reader.close();
	}
}