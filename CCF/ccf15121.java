//	2016/8/27	20:49
import java.io.*;
import java.util.*;

public class ccf15121 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		String s=reader.readLine();
		char[] c=s.toCharArray();
		int ans=0;
		for(int i=0;i<c.length;i++)
			ans+=c[i]-'0';
		System.out.println(ans);
	}
}
//	20:52