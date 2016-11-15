import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet242
{
    public static boolean isAnagram(String s, String t) {
		int i;
        int[] a=new int[26];
		for(i=0;i<s.length();i++)
			a[s.charAt(i)-'a']++;
		for(i=0;i<t.length();i++)
			a[t.charAt(i)-'a']--;
		for(i=0;i<26;i++){
			if(a[i]!=0)	 //绝对不能单纯判断 i>0
				return false;
		}
		return true;   
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		System.out.println(isAnagram( "a","ab"));
		reader.close();
	}
}