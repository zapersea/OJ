import java.io.*;
import java.util.*;

public class  Nod1174
{
	public static int maxone(int a,int b){
		return a>b?a:b;
	}

	public static void main(String[] args) throws IOException
	{	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=(int)(Math.log(n)/Math.log(2));
		int[] a=new int[n+1];
		int[][] max=new int[n+1][k+1];
		int i,m,nn,x,y;
		for(i=1;i<=n;i++){
			a[i]=sc.nextInt();
			max[i][0]=a[i];				//max[i][0]，对应只有第i个元素的情况，最大值自然是i	
		}
		for(int j=1;j<=k;j++){
			for(i=1;i<=n;i++){
				if(i+Math.pow(2,j)-1<=n){
					//System.out.println(" "+(int)(Math.pow(2,j-1)));
					max[i][j]=maxone(max[i][j-1],max[i+(int)(Math.pow(2,j-1))][j-1]);
				}
			}
		}
		int q=sc.nextInt();
		for(i=1;i<=q;i++){
			m=sc.nextInt()+1;
			nn=sc.nextInt()+1;
			x=(int)(Math.log(nn-m+1)/Math.log(2));
			y=nn-(int)(Math.pow(2,x))+1;
			System.out.println( maxone(max[m][x],max[y][x]) );
		}
		sc.close();
	}
}