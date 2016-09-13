import java.io.*;
import java.util.*;

public class ccf1642 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] a=new int[15][10];
		int[][] b=new int[4][4];
		int i,j,high=0,low=3;

		for(i=14;i>=0;i--){
			String[] s=reader.readLine().split(" ");
			for(j=0;j<10;j++)
				a[i][j]=Integer.parseInt(s[j]);
		}
		for(i=3;i>=0;i--){
			String[] s=reader.readLine().split(" ");
			for(j=0;j<4;j++){
				b[i][j]=Integer.parseInt(s[j]);
				if(b[i][j]==1){
					if(i>high)
						high=i;
					if(i<low)
						low=i;
				}
			}
		}
		int n=Integer.parseInt(reader.readLine());
		int len=high-low,cnt=12; // 一定要从上到下匹配
		boolean flag=true;

		while(flag==true){
			if(--cnt<0)
				break;
			for(i=0;i<=len;i++){
				for(j=0;j<4;j++){
					if(a[i+cnt][j+n-1]+b[i+low][j] == 2)
						flag=false;
				}
			}
		}
		cnt++;
		for(i=0;i<=len;i++){
			for(j=0;j<4;j++)
				a[i+cnt][j+n-1]+=b[i+low][j];
		}

		for(i=14;i>=0;i--){
			for(j=0;j<9;j++)
				writer.write(a[i][j]+" ");
			writer.write(a[i][9]+"\n");
		}
		writer.flush();
	}


}
