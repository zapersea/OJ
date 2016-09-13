//	2016/9/6	19:36
import java.io.*;
import java.util.*;

public class  ccf1503
{	
	static int[] dir={31,28,31,30,31,30,31,31,30,31,30,31};
	static int[] not={0,31,59,90,120,151,161,192,223,273,304,334};
	static int[] is={0,31,60,91,121,152,162,193,224,274,305,335}; 

	public static boolean isRun(int y){
		if(y%400==0) return true;
		else if(y%4==0||y%100!=0)
			return true;
		else 
			return false;
	}
	public static int count(int y){
		int d=0;
		for(i=1850;i<y;i++){
			if(isRun(i))
				d+=366;
			else
				d+=365;
		}
		return d;


	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int m=Integer.parseInt(t[0]);
		int w=Integer.parseInt(t[1]);
		int wd=Integer.parseInt(t[2]);
		int y1=Integer.parseInt(t[3]);
		int y2=Integer.parseInt(t[4]);
		int i,op,fd,sum=count(y1-1);
		int y;
		
		for(y=y1;y<=y2;y++){
			boolean flag=isRun(y);
			if(flag){
				op=(sum+is[m-1])%7;
				if(d<op)
					fd=7-op+d;
				else
					fd=7-op-d+1;
				while(w-->1)
					fd+=7;
				if((m!=2 && fd>dir[m-1]) ||( m=2 && fd>29))
					writer.write("none\n");
				else
					writer.wrie(y+"/"+m+"/"+fd);
				sum+=366;
			}
			else{
				op=(sum+not[m-1])%7;
				if(d<op)
					fd=7-op+d;
				else
					fd=7-op-d+1;
				while(w-->1)
					fd+=7;
				if(fd>dir[m-1])
					writer.write("none\n");
				else
					writer.wrie(y+"/"+m+"/"+fd);
				sum+=365;
			}
		}
		writer.flush();
		reader.close();
	}
}