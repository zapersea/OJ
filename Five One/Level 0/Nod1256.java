import java.io.*;
import java.util.*;

public class  Nod1256
{
	static int x,y;

	//��չŷ������㷨
	public static int extend_gcd(int a,int b){
		if(b==0){
			x=1;
			y=0;
			return a;
		}
		int ret=extend_gcd(b,a%b);
		int temp=x-a/b*y;
		x=y;
		y=temp;
		return ret;
	}

	public static void main(String[] args) throws Exception
	{	
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int m=Integer.parseInt(s[0]);
		int n=Integer.parseInt(s[1]);
		extend_gcd(m,n);
		if(x<0) x+=n;	//��ĿҪ����С�����⣬��һ��һ��������
		writer.write(x+"\n");	
		writer.flush();
	}
}