//	2016/9/9	15:15
import java.io.*;
import java.util.*;
import java.text.*;

public class  ccf14033
{
	public static void main(String[] args) throws Exception
	{	
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
	
		String f=reader.readLine();
		int[] a=new int[26];
		int i,j;

		for(i=0;i<f.length();i++){
			char c=f.charAt(i);
			if(c!=':'){
				if(i<f.length()-1){
					if(f.charAt(i+1)==':')
						a[c-'a']=2;		// 2---> with
					else
						a[c-'a']=1;		// 1---> without
				}
				else 
					a[c-'a']=1;
			}
		}

		int n=Integer.parseInt(reader.readLine());
		for(i=0;i<n;i++){
			writer.write("Case "+(i+1)+":");   // i+1 而不是 i，刚开始没注意 0分。。。。
			int[] b=new int[26];
			String[] e=new String[26];
			String[] s=reader.readLine().split(" ");
			for(j=1;j<s.length;j++){
				String t=s[j];
				if(t.length()==2 && t.charAt(0)=='-' && t.charAt(1)>='a' && t.charAt(1)<='z'){
					int c=t.charAt(1)-'a';
					if(a[c]==0)
						break;
					else if(a[c]==1)
						b[c]=1;
					else if(a[c]==2){ 
						b[c]=2;
						if(j+1<s.length){	// 测试用例10 ！！！
							j++;
							e[c]=s[j];
						}
					}	
				}
				else
					break;
			}
			for(j=0;j<26;j++){
				char tmp=(char)('a'+j);
				if(b[j]==1)
					writer.write(" -"+tmp);
				else if(b[j]==2)
					writer.write(" -"+tmp+" "+e[j]);
			}
			writer.write("\n");
		}

		writer.flush();
		reader.close();
	}
}
//	17:07