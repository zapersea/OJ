//	2016/9/9	20:39
import java.io.*;
import java.util.*;
import java.text.*;

public class  ccf14093
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a=reader.readLine();
		int f=Integer.parseInt(reader.readLine());
		int n=Integer.parseInt(reader.readLine());
		
		if(f==1){
			while(n-->0){
				String t=reader.readLine();
				if(t.contains(a))
					writer.write(t+"\n");
			}
		}
		else{
			int len=a.length();
			while(n-->0){
				String t=reader.readLine();
				for(int i=0;i<=t.length()-len;i++){
					if(t.substring(i,i+len).equalsIgnoreCase(a)){
						writer.write(t+"\n");
						break;
					}
				}
			}
		}

		writer.flush();
		reader.close();
	}
}
//	21:03