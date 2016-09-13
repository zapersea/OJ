//	2016/8/27	21:29
import java.io.*;
import java.util.*;

public class ccf15123 {

	public static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};

	public static void line(int x1,int y1,int x2,int y2,char[][] a){
		int s,e;
		if(x1==x2){
			if(y1<y2){
				s=y1;
				e=y2;
			}else{
				s=y2;
				e=y1;
			}
			for(int i=s;i<=e;i++){
				if(a[i][x1]=='-')
					a[i][x1]='+';
				else if(a[i][x1]=='+') ;  //可能有相交（部分重合）的竖直线
				else
					a[i][x1]='|';
			}
		}
		else{
			if(x1<x2){
				s=x1;
				e=x2;
			}else{
				s=x2;
				e=x1;
			}
			for(int j=s;j<=e;j++){
				if(a[y1][j]=='|')
					a[y1][j]='+';
				else if(a[y1][j]=='+') ; //可能有相交（部分重合）的水平线
				else
					a[y1][j]='-';
			}
		}

	}

	public static class Node{
		public int x;
		public int y;

		public Node(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void extend(int nx,int ny,char c,char[][] a,int n,int m) {
		Queue<Node> q=new LinkedList<Node>();
		q.offer(new Node(nx,ny));
		while(q.size()!=0){
			Node cur=q.poll();
			for(int i=0;i<4;i++){
				int x=cur.x+dir[i][0];
				int y=cur.y+dir[i][1];
				// 注意是a[y][x] ,而且别忘了判断a[y][x]!=c (不能通过坐标是否被访问过判断)，否则无限循环
				if(x>=0 && x<m && y>=0 && y<n ){ 
					char tmp=a[y][x];
					if(tmp!=c && tmp!='-' && tmp!='|' && tmp!='+' ){
						a[y][x]=c;
						q.offer(new Node(x,y));
					}
				}
			}
		}

	}

	public static void main(String[] args) throws Exception{
		
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[1]);
		int m=Integer.parseInt(s[0]);
		int q=Integer.parseInt(s[2]);
		char[][] a=new char[n][m];
		int i,j;
		// 初始化画板
		for(i=n-1;i>=0;i--){
			for(j=0;j<m;j++)
				a[i][j]='.';
		}

		while(q-->0){
			String[] t=reader.readLine().split(" ");
			if(t[0].equals("0")){
				int x1=Integer.parseInt(t[1]);
				int y1=Integer.parseInt(t[2]);
				int x2=Integer.parseInt(t[3]);
				int y2=Integer.parseInt(t[4]);
				line(x1,y1,x2,y2,a);
			}
			else{
				int x1=Integer.parseInt(t[1]);
				int y1=Integer.parseInt(t[2]);
				char[] tmp=t[3].toCharArray();
				extend(x1,y1,tmp[0],a,n,m);
			}
		}
		
		// 打印
		for(i=n-1;i>=0;i--){
			for(j=0;j<m;j++)
				writer.write(a[i][j]);
			writer.write("\n");
		}
		writer.flush();
	}

}

//	22:29	90分
//	22:56	100分