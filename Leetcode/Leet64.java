import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet64
{

    public static int minPathSum(int[][] grid) {
		int i,j,m=grid.length,n=grid[0].length;
		for(i=1;i<m;i++)
			grid[i][0]+=grid[i-1][0];
		for(j=1;j<n;j++)
			grid[0][j]+=grid[0][j-1];
		for(i=1;i<m;i++){
			for(j=1;j<n;j++)
				grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
		}
        return grid[m-1][n-1];
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[][] grid={{1,2,3},{5,1,3},{6,5,4}};
		System.out.println(minPathSum(grid));
		reader.close();
	}
}