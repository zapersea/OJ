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
		used=new int[leng];		//Ĭ�ϳ�ʼֵΪ0
		Arrays.sort(c);			//����ȥ�ظ���ͬʱ����ö�ٲο��ַ��������ֵ���ö�ٳ����Ķ���ַ����˴�Ҳ���ֵ���
		DFS(0);
	}
}