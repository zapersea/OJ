import java.io.*;
import java.util.*;

public class  ccf15124y
{

	public static Stack<Integer> st=new Stack<Integer>();

	public static void dfs(int s,int n,boolean[][] a){
		for(int j=1;j<=n;j++){
			if(a[s][j]){
				a[s][j]=false;
				a[j][s]=false;
				search(j,n,a);
			}
		}
		st.push(s);
	}

	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		boolean [][] a=new boolean[n+1][n+1];
		int[] degree=new int[n+1];
		int i,j,x,y,count=0;
		
		for(i=0;i<m;i++){
			String[] t=reader.readLine().split(" ");
			x=Integer.parseInt(t[0]);
			y=Integer.parseInt(t[1]);
			a[x][y]=true;
			a[y][x]=true;
			degree[x]++;
			degree[y]++;
		}
		for(i=1;i<=n;i++){
			if(degree[i]%2==1)
				count++;
		}
		if( (count!=0 && count!=2) || degree[1]%2==0 )
			writer.write("-1");
		else{
			dfs(1,n,a);
			writer.write(st.pop());
			while(!st.empty())
				writer.write(" "+st.pop());
		}
		writer.write("\n");
		writer.flush();
		reader.close();
	}
}