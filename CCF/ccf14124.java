//	2016/9/9	18:42
import java.io.*;
import java.util.*;
import java.text.*;

class Zaper implements Comparable{
	int i;
	int d;

	public Zaper(int i,int d){
		this.i=i;
		this.d=d;
	}

	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper) other;;
		return this.d-o.d;
	}
}

@SuppressWarnings("unchecked")
public class  ccf14124
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		
		List<Zaper> z=new ArrayList<Zaper>();
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int i,j,k,d=0;
		int[][] a=new int[n+1][n+1];
		// Initial and Input
		for(i=0;i<=n;i++){
			for(j=0;j<=n;j++)
				a[i][j]=10001;
		}
		for(i=0;i<m;i++){
			String[] t=reader.readLine().split(" ");
			int x=Integer.parseInt(t[0]);
			int y=Integer.parseInt(t[1]);
			int v=Integer.parseInt(t[2]);
			a[x][y]=v;
			a[y][x]=v;
		}
		for(i=2;i<=n;i++)
			z.add(new Zaper(i,a[1][i]));

		// Prime算法计算最小生成树
		Collections.sort(z);
		while(z.size()!=0){
			i=z.get(0).i;
			d+=z.get(0).d;
			for(j=1;j<z.size();j++){
				k=z.get(j).i;
				if(a[i][k]<z.get(j).d)
					z.get(j).d=a[i][k];
			}
			z.remove(0);
			Collections.sort(z);
		}

		System.out.println(d);
		reader.close();
	}
}
//	19:13