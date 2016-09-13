//	2016/8/28	15:45
import java.io.*;
import java.util.*;

public class  ccf15124
{
	
	public static Stack<Integer> st=new Stack<Integer>();
	
	public static boolean search(int s,int n,boolean[][] a,int len){
		if(len==0)
			return true;
		for(int j=1;j<=n;j++){
			if(a[s][j]){
				a[s][j]=false;
				a[j][s]=false;
				st.push(j);
				boolean re=search(j,n,a,len-1);
				if(re)	return true;
				else{
					a[s][j]=true;
					a[j][s]=true;
					st.pop();
				}
			}
		}
		return false;
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
		int i,j,x,y;
		int len=m;
		
		for(i=0;i<m;i++){
			String[] t=reader.readLine().split(" ");
			x=Integer.parseInt(t[0]);
			y=Integer.parseInt(t[1]);
			a[x][y]=true;
			a[y][x]=true;
		}
		
		boolean ans=search(1,n,a,len);

		if(ans){
			Stack<Integer> st2=new Stack<Integer>();
			while(!st.empty()){
				int temp=st.pop();
				st2.push(temp);
			}
			writer.write("1");
			while(!st2.empty())
				writer.write(" "+st2.pop());
		}
		else
			writer.write("-1");
		writer.write("\n");
		writer.flush();
		reader.close();
	}
}
//	16:49  50·Ö	16:55 70·Ö