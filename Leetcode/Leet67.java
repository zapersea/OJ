import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet67
{
    public static String addBinary(String a, String b) {
		int f=0,alen=a.length(),blen=b.length();
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<Math.min(alen,blen);i++){
			int x=a.charAt(alen-1-i)-'0';
			int sum=f+x+( b.charAt(blen-1-i)-'0');
			switch(sum){
				case 3:
					sb.insert(0,'1');
					f=1;
					break;
				case 2:
					sb.insert(0,'0');
					f=1;
					break;
				case 1:
					sb.insert(0,'1');
					f=0;
					break;
				case 0:
					sb.insert(0,'0');
					f=0;
					break;
				default:
			}
		}
		if(alen>=blen){
			for(int i=alen-1-blen;i>=0;i--){
				int sum=f+(a.charAt(i)-'0');
				if(sum==2)
					sb.insert(0,'0');
				else if(sum==1){
					sb.insert(0,'1');
					f=0;
				}
				else if(sum==0)
					sb.insert(0,'0');
			}
			if(f==1)
				sb.insert(0,'1');
		}
		else{
			for(int i=blen-1-alen;i>=0;i--){
				int sum=f+(b.charAt(i)-'0');
				if(sum==2)
					sb.insert(0,'0');
				else if(sum==1){
					sb.insert(0,'1');
					f=0;
				}
				else if(sum==0)
					sb.insert(0,'0');
			}
			if(f==1)
				sb.insert(0,'1');
		}
		return sb.toString();
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		System.out.println(addBinary("11","1"));
		reader.close();
	}
}