//	2016/9/10	10:43
import java.io.*;
import java.util.*;
import java.text.*;

class  Zaper{
	int x;
	int y;
	int d;

	public Zaper(int x,int y,int d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
}

public class ccf14094x{
	
	public static int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String[] args ) throws Exception{
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader (new FileInputStream(new File("D://data.txt")),"GBK"));

		String[] s =reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int k=Integer.parseInt(s[2]);
		int dd=Integer.parseInt(s[3]);

		Queue<Zaper> q=new LinkedList<Zaper>(); 
		int[][] cus=new int[n+1][n+1];
		boolean[][] block=new boolean[n+1][n+1];
		boolean[][] visit=new boolean[n+1][n+1];
		int x,y,d,cnt=0,re=0;

		while(m-->0){
			String[] t =reader.readLine().split(" ");
			x=Integer.parseInt(t[0]);
			y=Integer.parseInt(t[1]);
			q.add(new Zaper(x,y,0));	// add all shops into queue
			visit[x][y]=true;			// mark visited
		}
		while(k-->0){
			String[] t =reader.readLine().split(" ");
			x=Integer.parseInt(t[0]);
			y=Integer.parseInt(t[1]);
			cus[x][y]+=Integer.parseInt(t[2]);		// !! 注意要+=因为顾客坐标可能重复 
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(cus[i][j]!=0)
					cnt++;
			}
		}
		while(dd-->0){
			String[] t =reader.readLine().split(" ");
			x=Integer.parseInt(t[0]);
			y=Integer.parseInt(t[1]);
			block[x][y]=true;
		}

		while(q.size()!=0 && cnt>0){  // cnt=0说明买家都已买到，可以提前结束
			Zaper shop=q.poll();
			x=shop.x;
			y=shop.y;
			d=shop.d;
			for(int i=0;i<4;i++){
				int x1=x+dir[i][0];
				int y1=y+dir[i][1];
				//	x1>=1 && x1<=n && y1>=1 && y1<=n  must before  visit[x1][y1] and block[x1][y1]
				if(x1>=1 && x1<=n && y1>=1 && y1<=n && visit[x1][y1]==false && block[x1][y1]==false){
					if(cus[x1][y1]!=0){
						re+=(d+1)*cus[x1][y1];
						cnt--;
					}
					q.add(new Zaper(x1,y1,d+1));
					visit[x1][y1]=true;
				}
			}
		}

		System.out.println(re);
		reader.close();

	}
}