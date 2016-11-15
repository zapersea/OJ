import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet168{
    public static  String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
		do{
		sb.append((char)((n-1)%26+'A'));	//������n%26-1 ,��������Ϊ��Z�������
		n=(n-1)/26;		//ͬ����n-1������n ,��������Ϊ��Z�������
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