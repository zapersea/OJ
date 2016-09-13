import java.io.*;
import java.util.*;

public class  ccf15124x
{
	public static class Line {
		int s;
		int len;

		public Line(int s,int len){
			this.s=s;
			this.len=len;
		}

		@Override 
		public boolean equals(Object o) {
			if (this==o)	
				return true;
			if (o instanceof Line) {
				Line that = (Line) o;
				return (this.s == that.s && this.len == that.len);
			}
			else
				return false;
		}

		@Override 
		public int hashCode() {
			return (41 * (41 + s) + len);
		}
	}

	public static Stack<Integer> st=new Stack<Integer>();
	public static Stack<Line> sr=new Stack<Line>();

	public static boolean search(int ss,int n,boolean[][] a,int length){
		sr.push(new Line(ss,length));
		HashSet<Line> xy=new HashSet<Line>(); 
		int last=1;;
		while(!sr.empty()){
			Line cur=sr.pop();
			int s=cur.s;
			int len=cur.len;
			st.push(s);
			if(len==0)
				return true;
			xy.add(new Line(last,s));
			int count=0;
			for(int j=n;j>=1;j--){
				if(a[s][j] && !xy.contains(new Line(s,j)) && !xy.contains(new Line(j,s))){
					sr.push(new Line(j,len-1));
					count++;
				}
			}
			if(count==0){
				while(!st.empty())
					st.pop();
				sr.clear();
			}
			last=s;
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
			writer.write(st2.pop()+"");
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
//	18:05 同样超时，只有20分