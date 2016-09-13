//	2016/8/30	21:43
import java.io.*;
import java.util.*;

public class  ccf15093x
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
			news[i]=x[1];		// ²»ÊÇx[0] ,x[0]ÊÇ¿Õ×Ö·û
			store[i]="***"+i+"***";
		}
		for(i=0;i<m;i++){
			for(j=0;j<n;j++)
				a[i]=a[i].replace(olds[j],store[j]);
			StringBuilder sb=new StringBuilder(a[i]);
			op=sb.indexOf("{{");
			ed=sb.indexOf("}}",op);
			while(op!=-1 && ed!=-1 ){
				sb.delete(op,ed+2);
				op=sb.indexOf("{{",ed);
				ed=sb.indexOf("}}",op);
			}
			a[i]=sb.toString();
			for(j=0;j<n;j++)
				a[i]=a[i].replace(store[j],news[j]);
			writer.write(a[i]+"\n");
		}
		writer.flush();
		reader.close();
	}
}
//	21:33