//	2016/9/10	20:13
import java.io.*;
import java.util.*;
import java.text.*;

class Zaper implements Comparable{
	public int i;
	public int d;
	public int cnt;

	public Zaper(int i,int d,int cnt){
		this.i=i;
		this.d=d;
		this.cnt=cnt;
	}

	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper) other;
		return this.d-o.d;
	}
}

@SuppressWarnings("unchecked")
public class  ccf14034
{

	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int k=Integer.parseInt(s[2]);
		int r=Integer.parseInt(s[3]);

		boolean[][] a=new boolean[n+m][n+m];
		int[][] z= new int[n+m][2];
		LinkedList<Zaper> q=new LinkedList<Zaper>();
		int i,j,x1,y1,x2,y2,re=0;

		for(i=0;i<n+m;i++){
			String[] t=reader.readLine().split(" ");
			z[i][0]=Integer.parseInt(t[0]);
			z[i][1]=Integer.parseInt(t[1]);
			q.add(new Zaper(i,Integer.MAX_VALUE,k));
		}
		for(i=0;i<n+m;i++){
			x1=z[i][0];
			y1=z[i][1];
			for(j=i+1;j<n+m;j++){
				x2=z[j][0];
				y2=z[j][1];
				long t=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)-r*r;
				if(t<=0){
					a[i][j]=true;
					a[j][i]=true;
				}
			}
		}
		
		boolean find=false;
		q.get(0).d=0;
		while(find==false && q.size()!=0){
			Zaper t=q.poll();
			for(j=0;j<q.size();j++){
				if(q.get(j).i<=n-1 ||( q.get(j).i>n-1 && t.cnt>0) ){
					if(a[t.i][q.get(j).i]==true ){
						if(q.get(j).i==1){		// 1 instead of 2
							re=t.d;	
							find=true;
							break;
						}
						else if(t.d+1<q.get(j).d)
							q.get(j).d=t.d+1;
					}
				}
			}
			Collections.sort(q);
			if(q.get(0).i>n-1)
				q.get(0).cnt=t.cnt-1;
		}
		System.out.println(re);
		reader.close();
	}
}