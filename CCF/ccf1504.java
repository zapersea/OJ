import java.io.*;
import java.util.*;

class Zaper implements Comparable {
	public int i;
	public int de;
	public int rad;

	public Zaper(int i,int de,int rad){
		this.i=i;
		this.de=de;
		this.rad=rad;
	}

	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper) other;
		return o.rad-this.rad;
	}
}

@SuppressWarnings("unchecked")
public class  ccf1504
{
	public static void dfs(ArrayList<Integer>[] a,Zaper[] z,int i){
		if(a[i].size()==0 )	return;
		int s=a[i].size();
		int[] b=new int[s];
		int j,k;
		for(j=0;j<s;j++){
			k=a[i].get(j);
			if(k==-1)
				b[j]=0;
			else{
				dfs(a,z,k);
				b[j]=z[k].de;
			}
		}
		Arrays.sort(b);
		z[i].de=b[s-1]+1;
		if(s>1)
			z[i].rad=b[s-1]+b[s-2]+2;
		else
			z[i].rad=b[s-1]+1;
	}
	
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		ArrayList<Integer> []a=new ArrayList[n+1];
		Zaper[] z=new Zaper[n+1]; 
		int i,j;

		for(i=0;i<=n;i++){
			a[i]=new ArrayList<Integer>();
			z[i]=new Zaper(i,0,0);
		}
		String[] s1=reader.readLine().split(" ");
		for(i=0;i<n-1;i++){
			int x=Integer.parseInt(s1[i]);
			a[x].add(i+2);
		}
		String[] s2=reader.readLine().split(" ");
		for(i=0;i<m;i++){
			int x=Integer.parseInt(s2[i]);
			a[x].add(-1);
		}

		dfs(a,z,1);
		Arrays.sort(z);
		writer.write(z[0].rad+"\n");
		writer.flush();
		reader.close();
	}
}