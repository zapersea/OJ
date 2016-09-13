import java.io.*;
import java.util.*;

public class ccf1641 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(reader.readLine());
		String[] s=reader.readLine().split(" ");
		int cnt=0;

		for(int i=1;i<n-1;i++){	 //日了狗，从1开始写成从2开始
			int last=Integer.parseInt(s[i-1]);
			int cur=Integer.parseInt(s[i]);
			int next=Integer.parseInt(s[i+1]);
			if((cur-last)*(next-cur)<0)
				cnt++;
		}
		System.out.println(cnt);
	}
}
