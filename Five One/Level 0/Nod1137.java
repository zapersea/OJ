import java.io.*;
import java.util.*;

public class Nod1137
{
	public static void main(String[] args) throws IOException{
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(reader.readLine());
		int i,j,k,result;
		int[][] a=new int[n][n];
		int[][] b=new int[n][n];
		String[] c=new String[n];
		for(i=0;i<n;i++){
			c=reader.readLine().split(" ");
			for(j=0;j<n;j++)
				a[i][j]=Integer.parseInt(c[j]);
		}
		for(i=0;i<n;i++){
			c=reader.readLine().split(" ");
			for(j=0;j<n;j++)
				b[i][j]=Integer.parseInt(c[j]);
		}
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				result=0;
				for(k=0;k<n;k++)
					result+=a[i][k]*b[k][j];
				System.out.print(result+" ");
			}
			System.out.println();
		}
						
	}
}
