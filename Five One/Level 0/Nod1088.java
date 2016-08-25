import java.io.*;
import java.util.*;

public class  Nod1088
{	
	 public static int longestPalindrome(String s) {
		 int n=s.length();
		 boolean[][] pal=new boolean[n][n];
		 //pal[i][j] ��ʾs[i...j]�Ƿ��ǻ��Ĵ�
		 int maxLen=0;
		 for (int i=0;i<n;i++){  // i��Ϊ�յ�
			 int j=i;    //j��Ϊ���
			 while (j>=0){
				 // ���ڿ���j+1>i-1,��i-j<2����ʱ��pal[j+1][i-1]������û��ֵ
				 // ��������֪��i-j<2ֻ��1��0��������������ֻ����������Ȼ���ϻ���
				 if (s.charAt(j)==s.charAt(i)&&(i-j<2||pal[j+1][i-1])){
					 pal[j][i]=true;
					maxLen=Math.max(maxLen, i-j+1);
				 }
				 j--;
			 }
		 }
		 return maxLen;
    }

	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		String s=reader.readLine();
		writer.write(longestPalindrome(s)+"\n");
		writer.flush();
	}
}