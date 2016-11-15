import java.io.*;
import java.util.*;
import java.text.*;

public class  Leet58
{
    public static int lengthOfLastWord(String s) {
		String[] a=s.split(" ");
		System.out.println(a[a.length-1]);
		if(a.length>0)
			return a[a.length-1].length();
		else return 0;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		System.out.println(lengthOfLastWord(""));
		reader.close();
	}
}