import java.io.*;
import java.util.*;

public class  Nod1089
{	
	public static int longestPalindrome(String s) {
		int n=s.length();
		int i,j;
		// 1.构造新的字符串
		// 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
		StringBuilder news =new StringBuilder("#");
		for(i=0;i<n;i++)
			news.append(s.charAt(i)+"#");
		n=news.length();
		int[] rad=new int[n];	 // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
		int maxRight=0,pos=0; // maxRight和pos表示已知的回文中，最右的边界的坐标和中点坐标
		// 2.计算所有的rad
		// 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
		for(i=0;i<n;i++){
			 // 2.1.确定一个最小的半径
			if(i<maxRight)
				rad[i]=Math.min(rad[2*pos-i],maxRight-i);
			else rad[i]=1;
			// 2.2.尝试更大的半径
			// i-rad[i]+1是当前回文串的最左，所以往外扩展的第一个左边是i-rad[i],同理i+rad[i]
			while(i-rad[i]>=0 && i+rad[i]<n && news.charAt(i-rad[i])==news.charAt(i+rad[i]))
				rad[i]++;
			// 2.3.更新边界和回文中心坐标
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