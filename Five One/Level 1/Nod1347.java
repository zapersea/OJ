//	2016/8/24	13:17
import java.io.*;
import java.util.*;

public class Nod1347
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		String s=reader.readLine();
		int length=s.length();
		if(length%2==0){
			int mid=length/2;
			boolean flag=true;
			for(int i=0;i<mid;i++){
				if(s.charAt(i)!=s.charAt(i+mid)){
					flag=false;
					break;
				}
			}
			if(flag==true)
				writer.write("YES\n");
			else
				writer.write("NO\n");
		}
		else
			writer.write("NO\n");
		writer.flush();
	}
}
//	13:26