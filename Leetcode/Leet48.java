import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet48
{
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=n-1;i>=1;i--){
        	int[] s=new int[n];
        	for(int j=0;j<i;j++)
        		s[j]=matrix[0][j];
        	for(int k=1;k<=i;k++){
        		for(int j=0;j<i;j++)
        			matrix[k-1][j]=matrix[k][j];
        	}
        	for(int j=0;j<=i;j++)
        		matrix[i][j]=matrix[i-j][i];
        	for(int j=0;j<i;j++)
        		matrix[j][i]=s[j];
        }
    }

    public static void printMatrix(int[][] matrix){
    	System.out.println("-------------------------");
    	for(int[] t:matrix){
			for(int x:t)
				System.out.print(x+" ");
			System.out.println();
		}
    }
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		printMatrix(matrix);
		rotate(matrix);
		printMatrix(matrix);
		reader.close();
	}
}