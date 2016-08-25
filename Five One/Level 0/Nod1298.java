import java.io.*;
import java.util.*;

public class  Nod1298
{
	// 计算两点之间的距离
	public static double countDotDis(double x1,double y1,double x2,double y2){
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
	
	// 计算点P到线段AB的距离
	public static double countEdgeDis(double xp,double yp,double xa,double ya,double xb,double yb){
		double xAB=xb-xa;
		double yAB=yb-ya;
		double xAP=xp-xa;
		double yAP=yp-ya;
		double AP=countDotDis(xa,ya,xp,yp);
		double BP=countDotDis(xb,yb,xp,yp);
		double AB=countDotDis(xa,ya,xb,yb);
		double r=(xAB*xAP+yAB*yAP)/(AB*AB);
		if(r>=1)	return BP;
		else if(r<=0)	return AP;
		else{ // 假如P在AB上的投影点是C，很明显这种情况C是在线段AB上的,可得 CP^2+AC^2=AP^2
			double AC=r*AB;
			double CP=Math.sqrt(AP*AP-AC*AC);
			return CP;
		}
	}

	// 检查圆与三角形是否相交
	public static boolean isIntesect(double rx,double ry,double r,double[] x,double[] y){
		int i,countDot=0,countEdge=0;
		for(i=0;i<3;i++){
			if(countDotDis(rx,ry,x[i],y[i]) <=r)
				countDot++;
		}
		if(countDot==1||countDot==2)	return true;
		else if(countDot==3)	return false;
		// 剩下所有点都在圆外的情况，讨论圆心到边线段的距离
		else{
			 // countDot满足前面的条件就不用计算边距离，所以不在前面for循环不和点距离一起算,提高效率
			for(i=0;i<3;i++){ 
				if(countEdgeDis(rx,ry,x[i],y[i],x[(i+1)%3],y[(i+1)%3]) <=r)
					countEdge++;
			}
			if(countEdge==0)	return false;
			else return true;
		}
	}
	
	public static void main(String[] args) throws Exception
	{	
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		double[] x=new double[3];
		double[] y=new double[3];
		while(n-->0){
			String[] s=reader.readLine().split(" ");
			double rx=Double.parseDouble(s[0]);
			double ry=Double.parseDouble(s[1]);
			double  r=Double.parseDouble(s[2]);
			for(int i=0;i<3;i++){
				String[] c=reader.readLine().split(" ");
				x[i]=Double.parseDouble(c[0]);
				y[i]=Double.parseDouble(c[1]);
			}
			if(isIntesect(rx,ry,r,x,y)==true)
				writer.write("YES\n");
			else writer.write("NO\n");
		}
		writer.flush();
	}

}