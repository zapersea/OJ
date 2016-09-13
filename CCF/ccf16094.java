import java.io.*;
import java.util.*;
import java.text.*;

class Zaper implements Comparable{
	int i;
	int d;
	int p;
	int len;
	
	public Zaper(int i,int d,int p,int len){
		this.i=i;
		this.d=d;
		this.p=p;
		this.len=len;
	}
	
	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper) other;
		if(this.d!=o.d)
			return this.d-o.d;
		else
			return this.len-o.len;
	}
}

public class ccf16094 {
	public static void main(String[] args)throws Exception{
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")),"GBK"));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] xx=reader.readLine().split(" ");
		int n=Integer.parseInt(xx[0]);
		int m=Integer.parseInt(xx[1]);
		int[][] a=new int[n+1][n+1];
		int[] sp=new int[n+1];
		int[] dis=new int[n+1];
		int i,j,x,y,c,d,p,re=0;
		
		for(i=1;i<=n;i++){
			for(j=1;j<=n;j++)
				a[i][j]=Integer.MAX_VALUE;
			dis[i]=Integer.MAX_VALUE;
		}
		for(i=0;i<m;i++){
			String[] s=reader.readLine().split(" ");
			x=Integer.parseInt(s[0]);
			y=Integer.parseInt(s[1]);
			c=Integer.parseInt(s[2]);
			a[x][y]=c;
			a[y][x]=c;
			if(c<dis[x])
				dis[x]=c;
			if(c<dis[y])
				dis[y]=c;
		}
		
		LinkedList<Zaper> z=new LinkedList<Zaper>();
		z.add(new Zaper(1,0,1,0));
		a[1][1]=0;
		for(i=2;i<=n;i++)
			z.add(new Zaper(i,Integer.MAX_VALUE,-1,dis[i]));
		while(z.size()!=0){
			Zaper t=z.poll();
			x=t.i;
			d=t.d;
			p=t.p;
			re+=a[x][p];
			for(i=0;i<z.size();i++){
				y=z.get(i).i;
				if(d+a[x][y]<z.get(i).d || d+a[x][y]==z.get(i).d && a[x][y]<z.get(i).len ){
					z.get(i).d=d+a[x][y];
					z.get(i).p=x;
					z.get(i).len=a[x][y];
				}
			}
			Collections.sort(z);
		}
			
		writer.write(re+"\n");	
		writer.flush();
	}

}
