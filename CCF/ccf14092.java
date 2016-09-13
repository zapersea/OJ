//	2016/9/9	20:09
import java.io.*;
import java.util.*;
import java.text.*;

public class  ccf14092
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		
		int[][] a=new int[101][101];
		int n=Integer.parseInt(reader.readLine());
		int i,j,x1,x2,y1,y2,re=0;

		while(n-->0){
			String[] s=reader.readLine().split(" ");
			x1=Integer.parseInt(s[0]);
			y1=Integer.parseInt(s[1]);
			x2=Integer.parseInt(s[2]);
			y2=Integer.parseInt(s[3]);
			for(i=x1;i<x2;i++){
				for(j=y1;j<y2;j++){
					if(a[i][j]==0){
						a[i][j]=1;
						re++;
					}
				}
			}
		}

		System.out.println(re);
		reader.close();
	}
}
//	20:20