import java.io.*;
import java.util.*;

public class  Nod1088
{	
	 public static int longestPalindrome(String s) {
		 int n=s.length();
		 boolean[][] pal=new boolean[n][n];
		 //pal[i][j] 表示s[i...j]是否是回文串
		 int maxLen=0;
		 for (int i=0;i<n;i++){  // i作为终点
			 int j=i;    //j作为起点
			 while (j>=0){
				 // 由于可能j+1>i-1,即i-j<2，这时候pal[j+1][i-1]很明显没有值
				 // 但分析可知，i-j<2只有1和0两种情况，这两种基本情况很显然符合回文
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