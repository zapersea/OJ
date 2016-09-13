//	2016/8/30	21:16
import java.io.*;
import java.util.*;

public class  ccf15092
{
	public static int[] month={31,28,31,30,31,30,31,31,30,31,30,31};

	public static boolean judge(int y){
		if( y%400==0  || ( y%4==0 && y%100!=0 ))
			return true;
		else return false;
	}

	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int y=Integer.parseInt(reader.readLine());
		int d=Integer.parseInt(reader.readLine());
		int i=0,m=0;
		if(judge(y) && d>59)
			d--;
		while(d>0){
			d-=month[i];
			m++;
			i++;
		}
		i--;
		d+=month[i];
		writer.write(m+"\n"+d+"\n");
		writer.flush();
		reader.close();
	}
}
//	21:33