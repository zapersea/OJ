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
			//���귶Χ10^8,���Գ˺�Χ10^16���ҿ��ܷ�������Ҫdouble����
			double re1=vect[0][0]*vect[1][1]-vect[1][0]*vect[0][1];
			double re2=vect[0][0]*vect[2][1]-vect[2][0]*vect[0][1];
			double re3=vect2[2][0]*vect2[0][1]-vect2[0][0]*vect2[2][1];
			double re4=vect2[2][0]*vect2[1][1]-vect2[1][0]*vect2[2][1];
			//�������߶εĲ�ͬ���򣬻����߶��ϣ�������߶����ڵ�ֱ�߱ض��ཻ
			//������߶β�һ���ཻ,��������������һ�����x�������߶�c���귶Χ��
			//���ԣ��߶�AB���߶�CD�ཻ�ĳ�ֱ�Ҫ�������ǣ��߶�AB��ֱ��CD�ཻ��ֱ��AB���߶�CD�ཻ
			//Ҳ����˵C��D��ֱ��AB�Ĳ�ͬ�࣬ͬʱA��B��ֱ��CD�Ĳ�ͬ��
			if(re1*re2<=0 && re3*re4<=0)	
				writer.write("YES\n");
			else 
				writer.write("NO\n");
		}
		writer.flush();
	}
}