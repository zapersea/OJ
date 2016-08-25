import java.io.*;
import java.util.*;

public class  Nod1384x
{
	static char[] c;
	static char[] ans;
	static int[] used;
	static int leng;

	public static void DFS(int de)  {  //depth & length
		if(de==leng)
			System.out.println(ans);
		else{
			for(int i=0;i<leng;i++){
				if(used[i]==0){
					used[i]=1;
					ans[de]=c[i];
					DFS(de+1);
					used[i]=0;
					while(i<leng-1 && c[i]==c[i+1])  i++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	    String s=reader.readLine();
		c=s.toCharArray();
		leng=c.length;
		ans=new char[leng];
		used=new int[leng];		//默认初始值为0
		Arrays.sort(c);			//用于去重复，同时由于枚举参考字符数组是字典序，枚举出来的多个字符串彼此也是字典序
		DFS(0);
	}
}