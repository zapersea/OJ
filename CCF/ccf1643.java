import java.io.*;
import java.util.*;

public class ccf1643 {

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
			String sx="";
			int len=s.length();
			for(int i=0;i<=len;i++){
				if(i==len ||  s.charAt(i)=='/' ){ // 判断i放前面，防止charAt(i)访问越界
					if(!sx.equals(".") && !sx.equals("")){
						if(sx.equals("..")){
							if(!s1.empty())
								s1.pop();
						}else
							s1.push(sx);
					}
					sx="";
				}else
					sx+=s.charAt(i);
			}
			
			while(!s1.empty()){
				sx=s1.pop();
				s2.push(sx);
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
