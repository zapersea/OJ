import java.io.*;
import java.util.*;

public class  Nod1265
{
	public static void main(String[] args) throws Exception
	{		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		int[] x= new int[4];
		int[] y= new int[4];
		int[] z= new int[4];
		int[][] vect=new int[3][3];
		int i,value;
		while(n-->0){
			for(i=0;i<4;i++){
				String[] s=reader.readLine().split(" ");
				x[i]=Integer.parseInt(s[0]);
				y[i]=Integer.parseInt(s[1]);
				z[i]=Integer.parseInt(s[2]);
			}
			for(i=0;i<3;i++){
				vect[i][0]=x[i+1]-x[i];
				vect[i][1]=y[i+1]-y[i];
				vect[i][2]=z[i+1]-z[i];
			}
			value=vect[0][0]*(vect[1][1]*vect[2][2]-vect[2][1]*vect[1][2])-
				vect[0][1]*(vect[1][0]*vect[2][2]-vect[2][0]*vect[1][2])+vect[0][2]
				*(vect[1][0]*vect[2][1]-vect[2][0]*vect[1][1]);
			if(value==0)
				writer.write("Yes\n");
			else writer.write("No\n");
		}
		writer.flush();
	}
}