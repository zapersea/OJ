import java.io.*;
import java.util.*;

public class ccf1643x
{
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		String base=reader.readLine();
		Stack<String> s1=new Stack<String>();
		Stack<String> s2=new Stack<String>();
		while(n-->0){
			String s=reader.readLine();
			if(s.length()==0){
				writer.write(base+"\n");
				continue;
			}
			if(s.charAt(0)!='/')
				s=base+"/"+s;
			String[] sx=s.split("/");	// 使用/分割新字符串 
			for(int i=0;i<sx.length;i++){
				if(sx[i].equals(".") || sx[i].equals(""))
					continue;
				else if(sx[i].equals("..")){
					if(!s1.empty())
						s1.pop();	}
				else
					s1.push(sx[i]);
			}
			// 倒序
			while(!s1.empty()){
				String tmp=s1.pop();
				s2.push(tmp);
			}
			s="";
			if(s2.empty())
				s="/";
			else{
				while(!s2.empty()){
					s+='/';
					s+=s2.pop();
				}
			}
			writer.write(s+"\n");
		}
		writer.flush();

	}
	
}