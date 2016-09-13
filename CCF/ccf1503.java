//	2016/9/6	19:36
import java.io.*;
import java.util.*;
import java.text.*;

public class  ccf1503
{	
	static int[] dir={31,28,31,30,31,30,31,31,30,31,30,31};
	static int[] not={0,31,59,90,120,151,161,192,223,273,304,334};
	static int[] is={0,31,60,91,121,152,162,193,224,274,305,335}; 

	public static boolean isRun(int y){
		if(y%400==0 || ( y%4==0 && y%100!=0))	// Initially wrong with this....
			return true;   
		else 
			return false;
	}

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] t=reader.readLine().split(" ");
		int m=Integer.parseInt(t[0]);
		int w=Integer.parseInt(t[1]);
		int wd=Integer.parseInt(t[2]);
		int y1=Integer.parseInt(t[3]);
		int y2=Integer.parseInt(t[4]);
		int y,op,fd,sum=1;	// instead of - 6  ,user-case-9
		for(int i=1850;i<y1;i++){
			if(isRun(i))	sum+=366;
			else	sum+=365;
		}
		for(y=y1;y<=y2;y++){
			if(isRun(y)){
				dir[1]=29;
				op=(sum+is[m-1])%7;
				sum+=366;
			}
			else{
				dir[1]=28;
				op=(sum+not[m-1])%7;
				sum+=365;
			}
			if(wd<=op)
				fd=7+wd-op;
			else
				fd=wd-op;
			fd+=(w-1)*7;
			if(fd>dir[m-1])
				writer.write("none\n");
			else{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
				String ds=y+"/"+m+"/"+fd;
				Date dt=sdf.parse(ds);
				writer.write(sdf.format(dt)+"\n");
			}
		}
		writer.flush();
		reader.close();
	}
}