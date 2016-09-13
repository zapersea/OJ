import java.io.*;
import java.util.*;

public class ccf1644
{
	static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
	static class Node{
		public int t;
		public int x;
		public int y;

		public Node(int t,int x,int y){
			this.t=t;
			this.x=x;
			this.y=y;
		}
	}
	
	public static void countTime(int n,int m,int[][] op,int[][] ed,boolean[][][] visit){
		if(n==1&&m==1){
			System.out.println(0);
			return; }
		Queue<Node> s=new LinkedList<Node>();
		s.offer(new Node(0,1,1));
		while(s.size()!=0){
			Node cur=s.poll();
			int t=cur.t;
			int x=cur.x;
			int y=cur.y;
			if((x+1==n&&y==m) || (x==n&&y+1==m)){
				System.out.println(t+1);
				return ;	}
			for(int i=0;i<4;i++){
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(nx<=n && nx>=1 && ny<=m && ny>=1 && visit[nx][ny][t+1]==false && ( t+1<op[nx][ny] || t+1>ed[nx][ny])){
					s.offer(new Node(t+1,nx,ny));
					visit[nx][ny][t+1]=true;
				}
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);	//日了野狗。。。刚开始s[1]和s[2]全写成s[0]
		int t=Integer.parseInt(s[2]);
		int[][] op=new int[n+1][m+1];
		int[][] ed=new int[n+1][m+1];
		boolean[][][] visit=new boolean[n+1][m+1][400];
		while(t-->0){
			String[] c=reader.readLine().split(" ");
			int x=Integer.parseInt(c[0]);
			int y=Integer.parseInt(c[1]);
			op[x][y]=Integer.parseInt(c[2]);
			ed[x][y]=Integer.parseInt(c[3]);
		}

		countTime(n,m,op,ed,visit);

	}
	
}