//	2016/9/8	9:50
import java.io.*;
import java.util.*;
import java.text.*;

public class  ccf14122
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(reader.readLine());
		int[][] a=new int[n][n];
		int i,j;
		boolean dir=true;
		// Input
		for(i=0;i<n;i++){
			String[] s=reader.readLine().split(" ");
			for(j=0;j<n;j++)
				a[i][j]=Integer.parseInt(s[j]);
		}
		//	Search
		writer.write(a[0][0]+"");
		if(n>1){
			writer.write(" "+a[0][1]);
			i=1;
			j=0;
			while(i<n && j<n){
				writer.write(" "+a[i][j]);
				if(j==n-1){
					dir=true;		
					i++;
					writer.write(" "+a[i][j]);
					i++;
					j--;		
				}
				else if(i==n-1){
					dir=false;			
					j++;
					writer.write(" "+a[i][j]);
					i--;
					j++;			
				}
				else if(i==0){
					dir=true;
					j++;
					writer.write(" "+a[i][j]);
					i++;
					j--;
				}
				else if(j==0){
					dir=false;
					i++;
					writer.write(" "+a[i][j]);
					i--;
					j++;
				}
				else{
					if(dir){
						i++;
						j--;
					}
					else{
						i--;
						j++;
					}
				}
			}
		}
		writer.write("\n");

		writer.flush();
		reader.close();
	}
}
//	10:50