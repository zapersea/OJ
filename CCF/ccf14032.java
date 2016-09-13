//	2016/9/9	13:44
import java.io.*;
import java.util.*;
import java.text.*;

class Zaper{
	public int num;
	public int x1;
	public int y1;
	public int x2;
	public int y2;

	public Zaper(int num,int x1,int y1,int x2,int y2){
		this.num=num;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}
}

public class  ccf14032
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedList<Zaper> q=new LinkedList<Zaper>();	//这里不能用Queue<Zaper> ,否则会提示addFirst方法不存在
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int i,j;

		for(i=1;i<=n;i++){
			String[] t=reader.readLine().split(" ");
			//   addFirst ！！！！
			q.addFirst(new Zaper(i, Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]),Integer.parseInt(t[3])));
		}
		while(m-->0){
			String[] r=reader.readLine().split(" ");
			int x=Integer.parseInt(r[0]);
			int y=Integer.parseInt(r[1]);
			boolean f=false;
			for(i=0;i<q.size();i++){
				Zaper tmp=q.get(i);
				if(x>=tmp.x1 && x<=tmp.x2 && y>=tmp.y1 && y<=tmp.y2){
					writer.write(tmp.num+"\n");
					q.remove(i);
					q.addFirst(tmp);
					f=true;
					break;
				}
			}
			if(f==false)
				writer.write("IGNORED\n");
		}

		writer.flush();
		reader.close();
	}
}
//	14:10