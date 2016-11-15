import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet73x
{
     public void setZeroes(int[][] matrix) {
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
         int m = matrix.length, n = matrix[0].length;
         boolean row = false, col = false;
         for (int i = 0; i < m; i++)
             for (int j = 0; j < n; j++){
                 if (matrix[i][j] == 0) {
                     matrix[0][j] = 0;
                     matrix[i][0] = 0;
                     if (i == 0) row = true;
                     if (j == 0) col = true;
                 }
             }
         for (int i = 1; i < m; i++){
             if (matrix[i][0] == 0){
                 for (int j = 1; j < n;j++)
                     matrix[i][j] = 0;
             }
         }
         for (int j = 1; j < n; j++){
             if (matrix[0][j] == 0){
                 for (int i = 1; i < m; i++)
                     matrix[i][j] = 0;
             }
         }
         if (row){
             for (int j = 0; j < n; j++)
                 matrix[0][j] = 0;
         }
         if (col){
             for(int i = 0; i < m; i++)
                 matrix[i][0] = 0;
         }
	 }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[][] matrix={{-2147483647,   1,  1,  1},{1, 0, 1, 1},{1, 1, 1, 1}};
		setZeroes(matrix);
		for(int[] t:matrix){
			for(int x:t)
				System.out.print(x+" ");
			System.out.println();
		}
		reader.close();
	}
}