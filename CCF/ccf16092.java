import java.io.*;
import java.util.*;
import java.text.*;

public class ccf16092 {
	public static void main(String[] args)throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[][] a=new boolean[20][5];
		int[] f=new int[20];
		int n=Integer.parseInt(reader.readLine());
		int i,j,k;
		for(j=0;j<20;j++)
			f[j]=5;

		String[] s=reader.readLine().split(" ");
		for(i=0;i<n;i++){
			int c=Integer.parseInt(s[i]);
			boolean find=false;
			int index=0;
			for(j=0;j<20;j++){
				if(f[j]>=c){
					index=j;
					f[j]-=c;
					find=true;
					break;
				}
			}
			if(find){
				j=0;
				while(j<5 && c>0){
					if(a[index][j]==false){
						a[index][j]=true;
						c--;
						if(c>=1)
							writer.write((index*5+j+1)+" ");
						else
							writer.write((index*5+j+1)+"\n");				}
					j++;
				}
			}
			else{
				for(j=0;i<20;j++){
					if(find)
						break;
					for(k=0;k<5;k++){
						if(a[j][k]==false){
							a[j][k]=true;
							c--;
							f[j]--;
							if(c>=1)
								writer.write((j*5+k+1)+" ");
							else if(c==0){
								writer.write((j*5+k+1)+"\n");
								find=true;
								break;
							}
						}
					}
				}
			}
		}
		
		writer.flush();
	}

}
