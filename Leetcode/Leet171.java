import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet171{
    public static int titleToNumber(String s) {
        int i,ans=0,len=s.length();
		for(i=0;i<len;i++){
			int x=s.charAt(i)-'A'+1;
			ans+=x*(int)Math.pow(26,(len-1-i));
		}
		return ans;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		System.out.println(titleToNumber("AAB"));
		reader.close();
	}
}