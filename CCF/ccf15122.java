//	2016/8/27	20:53
import java.io.*;
import java.util.*;

public class ccf15122 {

	public static void main(String[] args) throws Exception{
		
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s=reader.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int[][] a=new int[n][m];
		int[][] b=new int[n][m];
		int i,j;
		// 输入
		for(i=0;i<n;i++){
			String[] t=reader.readLine().split(" ");
			for(j=0;j<m;j++)
				a[i][j]=Integer.parseInt(t[j]);
		}
		// 消除,标记
		for(i=0;i<n;i++){
			for(j=0;j<m;j++){
				int count=1;
				int x=i-1;
				while(x>=0 && a[x][j]==a[i][j]){ //上向扩展
					count++;
					x--;
				}
				x=i+1;
				while(x<n &&a [x][j]==a[i][j]){ //向下扩展
					count++;
					x++;
				}
				if(count>=3)
					b[i][j]=1;
				else{
					count=1;
					int y=j-1;
					while(y>=0 && a[i][y]==a[i][j]){ //向左扩展
						count++;
						y--;
					}
					y=j+1;
					while(y<m &&a [i][y]==a[i][j]){	//向右扩展
						count++;
						y++;
					}
					if(count>=3)
						b[i][j]=1;
				}
			}
		}
		// 输出
		for(i=0;i<n;i++){
			for(j=0;j<m-1;j++){
				if(b[i][j]==0)
					writer.write(a[i][j]+" ");
				else
					writer.write("0 ");
			}
			if(b[i][m-1]==0)
				writer.write(a[i][m-1]+"\n");
			else
				writer.write("0\n");
		}
		writer.flush();
	}

}
//	21:20