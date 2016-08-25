import java.io.*;
import java.util.*;

public class  Nod1089
{	
	public static int longestPalindrome(String s) {
		int n=s.length();
		int i,j;
		// 1.�����µ��ַ���
		// Ϊ�˱����������ĺ�ż�����ĵĲ�ͬ�������⣬��ԭ�ַ����в���'#'�������л��ı����������
		StringBuilder news =new StringBuilder("#");
		for(i=0;i<n;i++)
			news.append(s.charAt(i)+"#");
		n=news.length();
		int[] rad=new int[n];	 // rad[i]��ʾ��iΪ���ĵĻ��ĵ����뾶��i����Ϊ1�������ַ�����
		int maxRight=0,pos=0; // maxRight��pos��ʾ��֪�Ļ����У����ҵı߽��������е�����
		// 2.�������е�rad
		// ����㷨��O(n)�ģ���Ϊrightֻ���������while�ĵ�����������������١�
		for(i=0;i<n;i++){
			 // 2.1.ȷ��һ����С�İ뾶
			if(i<maxRight)
				rad[i]=Math.min(rad[2*pos-i],maxRight-i);
			else rad[i]=1;
			// 2.2.���Ը���İ뾶
			// i-rad[i]+1�ǵ�ǰ���Ĵ�����������������չ�ĵ�һ�������i-rad[i],ͬ��i+rad[i]
			while(i-rad[i]>=0 && i+rad[i]<n && news.charAt(i-rad[i])==news.charAt(i+rad[i]))
				rad[i]++;
			// 2.3.���±߽�ͻ�����������
			if(i+rad[i]-1>maxRight){
				maxRight=i+rad[i]-1;
				pos=i;
			}
		}
		Arrays.sort(rad);
		return rad[n-1]-1;
	}

	public static void main(String[] args) throws Exception {		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String s=reader.readLine();
		writer.write(longestPalindrome(s)+"\n");
		writer.flush();
	}
}