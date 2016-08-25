import java.io.*;
import java.util.*;

public class  Nod1264
{
	public static void main(String[] args) throws Exception
	{		
		Scanner sc=new Scanner(System.in);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=sc.nextInt();
		double[] x= new double[4];
		double[] y= new double[4];
		double[][] vect=new double[3][2];
		double[][] vect2=new double[3][2];
		int i;
		while(n-->0){
			for(i=0;i<4;i++){
				x[i]=sc.nextInt();
				y[i]=sc.nextInt();
			}
			for(i=0;i<3;i++){
				vect[i][0]=x[i+1]-x[0];
				vect[i][1]=y[i+1]-y[0];
				vect2[i][0]=x[i]-x[3];
				vect2[i][1]=y[i]-y[3];
			}
			//坐标范围10^8,所以乘后范围10^16，且可能分数，需要double类型
			double re1=vect[0][0]*vect[1][1]-vect[1][0]*vect[0][1];
			double re2=vect[0][0]*vect[2][1]-vect[2][0]*vect[0][1];
			double re3=vect2[2][0]*vect2[0][1]-vect2[0][0]*vect2[2][1];
			double re4=vect2[2][0]*vect2[1][1]-vect2[1][0]*vect2[2][1];
			//两点在线段的不同方向，或在线段上，则与该线段所在的直线必定相交
			//但与该线段不一定相交,满足两个至少有一个点的x坐标在线段c坐标范围内
			//所以，线段AB与线段CD相交的充分必要条件就是，线段AB与直线CD相交，直线AB与线段CD相交
			//也就是说C和D在直线AB的不同侧，同时A和B在直线CD的不同侧
			if(re1*re2<=0 && re3*re4<=0)	
				writer.write("YES\n");
			else 
				writer.write("NO\n");
		}
		writer.flush();
	}
}