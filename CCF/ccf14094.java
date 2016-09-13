//	2016/9/10	10:43
import java.io.*;
import java.util.*;
import java.text.*;

class  Zaper{
	int x;
	int y;
	int v;

	public Zaper(int x,int y,int v){
		this.x=x;
		this.y=y;
		this.v=v;
	}
}

public class ccf14094{
	
	public static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

	public static int BFS(Zaper s,boolean[][] shop,boolean[][] block,int n){
		int x0=s.x;
		int y0=s.y;
		int v0=s.v;
		boolean[][] visit=new boolean[n+1][n+1];
		Queue<Zaper> t=new LinkedList<Zaper>(); 
		t.add(new Zaper(x0,y0,0));
		visit[x0][y0]=true;
		while(t.size()!=0){
			Zaper a=t.poll();
			int x=a.x;
			int y=a.y;
			int cnt=a.v;
			if(shop[x][y]==true)
				return v0*a.v;
			else{
				for(int i=0;i<4;i++){
					int x1=x+dir[i][0];
					int y1=y+dir[i][1];
					//	x1>=1 && x1<=n && y1>=1 && y1<=n  must before  visit[x1][y1] and block[x1][y1]
					if(x1>=1 && x1<=n && y1>=1 && y1<=n && visit[x1][y1]==false && block[x1][y1]==false){
						t.add(new Zaper(x1,y1,cnt+1));
						visit[x1][y1]=true;
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args ) throws Exception{
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader (new FileInputStream(new File("D://data.txt")),"GBK"));

		String[] s =reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int k=Integer.parseInt(s[2]);
		int d=Integer.parseInt(s[3]);

		Queue<Zaper> cus=new LinkedList<Zaper>(); 
		boolean[][] shop=new boolean[n+1][n+1];
		boolean[][] block=new boolean[n+1][n+1];
		int x,y,v,re=0;

		while(m-->0){
			String[] t =reader.readLine().split(" ");
			x=Integer.parseInt(t[0]);
			y=Integer.parseInt(t[1]);
			shop[x][y]=true;
		}
		while(k-->0){
			String[] t =reader.readLine().split(" ");
			x=Integer.parseInt(t[0]);
			y=Integer.parseInt(t[1]);
			v=Integer.parseInt(t[2]);
			cus.add(new Zaper(x,y,v));
		}
		while(d-->0){
			String[] t =reader.readLine().split(" ");
			x=Integer.parseInt(t[0]);
			y=Integer.parseInt(t[1]);
			block[x][y]=true;
		}
		
		while(cus.size()!=0)
			re+=BFS(cus.poll(),shop,block,n);

		System.out.println(re);
		reader.close();

	}
}
//	11:10