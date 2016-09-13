//	2016/8/30	21:43
import java.io.*;
import java.util.*;

public class  ccf15093
{

	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s=reader.readLine().split(" ");
		int m=Integer.parseInt(s[0]);
		int n=Integer.parseInt(s[1]);
		String[] a=new String[m];
		String[] olds=new String[n];
		String[] store=new String[n];
		String[] news=new String[n];
		int i,j,op,ed;

		for(i=0;i<m;i++)
			a[i]=reader.readLine();
		for(i=0;i<n;i++){
			String[] t=reader.readLine().split(" ",2);
			olds[i]="{{ "+t[0]+" }}";
			String[] x=t[1].split("\"");
			news[i]=x[1];		// ²»ÊÇx[0] ????
			store[i]="***"+i+"***";
			//System.out.println(t[1]);
			//System.out.println(news[i]);
		}
		for(i=0;i<m;i++){
			StringBuilder sb=new StringBuilder(a[i]);
			for(j=0;j<n;j++){
				String ts=sb.toString();
				sb=new StringBuilder( ts.replace(olds[j],store[j]));
			}
			for(j=0;j<n;j++){
				String ts=sb.toString();
				sb=new StringBuilder( ts.replace(store[j],news[j]));
			}
			op=sb.indexOf("{{");
			ed=sb.indexOf("}}",op);
			while(op!=-1 && ed!=-1 ){
				boolean flag=false;
				for(j=0;j<n;j++){
					if(sb.indexOf(olds[j],op)!=-1){
						flag=true;
						break;
					}
				}
				if(flag==false)
					sb.delete(op,ed+2);
				op=sb.indexOf("{{",ed);
				ed=sb.indexOf("}}",op);
			}
			writer.write(sb.toString()+"\n");
		}
		writer.flush();
		reader.close();
	}
}
//	21:33