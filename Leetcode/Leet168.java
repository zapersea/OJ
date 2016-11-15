import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet168{
    public static  String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
		do{
		sb.append((char)((n-1)%26+'A'));	//不能用n%26-1 ,考虑输入为“Z”的情况
		n=(n-1)/26;		//同样的n-1而不是n ,考虑输入为“Z”的情况
		}while(n>0);
		sb.reverse();
		return sb.toString();
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		System.out.println(convertToTitle(704));
		reader.close();
	}
}