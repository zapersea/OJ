import java.io.*;
import java.util.*;

public class  Nod1183
{
	public static void main(String[] args) throws IOException
	{	

		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String a=reader.readLine();
		String b=reader.readLine();
		int i,j,temp;
		int al=a.length();
		int bl=b.length();
		int[][] count=new int[al+1][bl+1];
		for(i=0;i<=al;i++)
			count[i][0]=i;
		for(j=0;j<=bl;j++)
			count[0][j]=j;
		for(i=1;i<=al;i++){
			for(j=1;j<=bl;j++){
				temp=count[i-1][j-1];
				if(a.charAt(i-1)!=b.charAt(j-1))
					temp+=1;
				count[i][j]=Math.min(count[i-1][j]+1 ,Math.min(count[i][j-1]+1 ,temp));
			}
		}
		System.out.println(count[al][bl]);
	}
}