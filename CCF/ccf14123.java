import java.io.*;
import java.util.*;
import java.text.*;

class Zaper implements Comparable{
	public boolean f; 
	public double p;
	public int n;

	public Zaper(boolean f,double p,int n){
		this.f=f;
		this.p=p;
		this.n=n;
	}
	
	//  Price Increase
	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper) other;
		double t=this.p-o.p;
		if(t==0) return 0;
		else if(t>0) return 1;
		else return -1;
	}
}

public class ccf14123{
	public static void main(String[] args ) throws Exception{
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader (new FileInputStream(new File("D://data.txt")),"GBK"));
		Zaper[] z=new Zaper[5000];
		int i,j,index,cnt=0,len=0;
		long sum=0,tb=0,ts=0;

		//Input
		for(i=0;i<5000;i++)
			z[i]=new Zaper(false,Double.MAX_VALUE,0);
		String s=reader.readLine();
		while(s!=null){
			char c=s.charAt(0);
			String[] t=s.split(" ");
			if(c=='c'){
				j=Integer.parseInt(t[1]);
				if(z[j-1].f==true)
					tb-=z[j-1].n;
				else
					ts-=z[j-1].n;
				z[j-1].p=Double.MAX_VALUE;
				z[j-1].n=0;
				len--;	// len是为了计数有效行数，刚开始这里直接用cnt--,很明显错了，会串行
			}
			else {
				z[cnt].p=Double.parseDouble(t[1]);
				z[cnt].n=Integer.parseInt(t[2]);
				if(c=='b'){
					z[cnt].f=true;
					tb+=z[cnt].n;
				}
				else
					ts+=z[cnt].n;
			}
			cnt++;
			len++;
			s=reader.readLine();
		}
		//System.out.println(tb);
		// Search
		Arrays.sort(z);
		i=0;
		index=0;
		long r1=tb,r2=0,t1=0,t2=0,max=0;
		while(i<=len){
			r1-=t1;  //这里的操作顺序一定要想明白，遍历到某个值的时候，t1减去上一个值的t1，t2加上自己的r2
			t1=0;
			t2=0;
			do{
				if(z[i].f==true)
					t1+=z[i].n;
				else
					t2+=z[i].n;
				i++;
			}while(i<=len && z[i].p==z[i-1].p); // judge "i<=cnt" firstly !! otherwise OutOfBounder Wrong
			r2+=t2;
			if(Math.min(r1,r2)>=max && z[i-1].p<=10000){
				max=Math.min(r1,r2);
				index=i-1;
			}
			//System.out.println(r1+" "+r2);
		}
		System.out.printf("%.2f %d\n",z[index].p,max);
		reader.close();

	}
}