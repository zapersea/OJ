import java.io.*;
import java.util.*;
import java.text.*;

public class ccf13122{

	public static void main(String[] args) throws Exception{

		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")),"GBK"));
		String s=reader.readLine();
		int i,cnt=1,re=0;
		for(i=0;i<s.length()-1;i++){
			char c=s.charAt(i);
			if(c!='-'){
				int t=c-'0';
				re=re+t*cnt;
				cnt++;
			}
		}
		re=re%11;
		char check=s.charAt(s.length()-1);
		if(re==check-'0' || re==10 && check=='X' )
			System.out.println("Right");
		else if(re<10)
				System.out.println(s.substring(0,s.length()-1)+re);
		else 
			System.out.println(s.substring(0,s.length()-1)+'X');	// !!!别忘了这种情况，3个测试用例
		reader.close();
	}
}