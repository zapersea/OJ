import java.io.*;
import java.util.*;

public class Nod1006
{
	public static char[][] writeTable(char[] a,char[] b){
		int al=a.length+1;
		int bl=b.length+1;
		int[][] c=new int[al][bl];
		char[][] f=new char[al][bl];
		/*对矩阵的常规初始，不过其实java在new int数组的时候已经全部初始化为0，所以这部分不是必要的
		int i;
		for(i=0;i<al;i++) c[i][0]=0;
		for(i=0;i<bl;i++) c[0][0]=0;    */
		for(int i=1;i<al;i++){
			for(int j=1;j<bl;j++){
				if (a[i-1]==b[j-1]) 	{
					c[i][j]=c[i-1][j-1]+1;
					f[i][j]='*'; }
				else if(c[i-1][j]>=c[i][j-1]){
					c[i][j]=c[i-1][j];
					f[i][j]='^'; }
				else {
					c[i][j]=c[i][j-1];
					f[i][j]='<'; }
			}
		}
		return f;  
	}

	public static void getLCS1(Stack<Character> L,char[] a,char[][] f,int i,int j){
		if(i==0||j==0) {
			return ;
		}
		else {
			if(f[i][j]=='*') {
				L.push(a[i-1]);
				getLCS1(L,a,f,i-1,j-1);
			}
			else if(f[i][j]=='^')  getLCS1(L,a,f,i-1,j);
			else getLCS1(L,a,f,i,j-1);
		}
	}

	public static void getLCS2(char[] a,char[][] f,int i,int j){
		if(i==0||j==0) {
			return ;
		}
		else {
			if(f[i][j]=='*') {
				getLCS2(a,f,i-1,j-1);
				System.out.print(a[i-1]);  //注意，这里的print是放在递归后面
			}
			else if(f[i][j]=='^')  getLCS2(a,f,i-1,j);
			else getLCS2(a,f,i,j-1);
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String as=sc.next();
		String bs=sc.next();
		char[] a=as.toCharArray() ;
		char[] b=bs.toCharArray();
		char[][] f=writeTable(a,b);
		getLCS2(a,f,as.length(),bs.length());
		System.out.println(); 
		Stack<Character> L=new Stack<Character>();
		getLCS1(L,a,f,as.length(),bs.length());
		while(!L.empty())
			System.out.print(L.pop()); 
		System.out.println(); 
	}
}
