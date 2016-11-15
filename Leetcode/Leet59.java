import java.util.*;
import java.io.*;
import java.text.*;

public class Leet59{

    public static int[][] generateMatrix(int n) {
        int[][] z=new int[n][n];
        int rowStart=0,rowEnd=n-1,colStart=0,colEnd=n-1,cnt=0;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int j=colStart;j<=colEnd;j++)
                z[rowStart][j]=++cnt;
            rowStart++;
            for(int i=rowStart;i<=rowEnd;i++)
                z[i][colEnd]=++cnt;
            colEnd--;
            for(int j=colEnd;j>=colStart;j--)
                z[rowEnd][j]=++cnt;
            rowEnd--;
            for (int i=rowEnd;i>=rowStart;i--)
                z[i][colStart]=++cnt;
            colStart++;
        }
        return z;
    }

	public static void main(String[] args) throws Exception{
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")),"GBK"));
		int[][] nums=generateMatrix(3);
		for(int[] t:nums)
            for(int x:t)
                System.out.print(x+" ");
			System.out.println();
	}
}
