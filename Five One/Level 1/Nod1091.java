//	2016/8/25	9:14
import java.io.*;
import java.util.*;

public class  Nod1091
{
	public static class Seg{
		public int x;
		public int y;

		public Seg(){
			this.x=0;
			this.y=0;
		}

		public Seg(int s,int e){
			this.x=s;
			this.y=e;
		}
	}

	public static void swmp(Seg[] a,int s,int e){
		Seg m=a[s];
		a[s]=a[e];
		a[e]=m;
	}

	public static void quick_sort(Seg[] a,int s,int e){
		if(a.length<1||a==null||s>=e)
			return;
		int low=s,high=e,key=a[s].x,key2=a[s].y;
		boolean flag=true;
		while(low<high){
			if(flag){
				//	当x相等的时候，y按倒序排列。
				if(a[high].x<key||(a[high].x==key && a[high].y>key2)){ 
					swmp(a,low,high);
					flag=false;
				}else 
					high--;
			}else{
				if(a[low].x>key||(a[low].x==key && a[low].y<key2)){
					swmp(a,low,high);
					flag=true;
				}else 
					low++;
			}
		}
		quick_sort(a,s,low-1);
		quick_sort(a,high+1,e);
	}

	public static void main(String[] args) throws Exception
	{			
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(reader.readLine());
		Seg[] lines=new Seg[n];
		for(int i=0;i<n;i++){
			String[] s=reader.readLine().split(" ");
			lines[i]=new Seg(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		quick_sort(lines,0,n-1);
		//for(int i=0;i<n;i++)
		//	System.out.println(lines[i].x+" "+lines[i].y);
		int cur=0,max=0;
		for(int i=1;i<n;i++){
			if(lines[i].x>=lines[cur].y)
				cur=i;
			else if(lines[i].y>lines[cur].y){
				if(lines[cur].y-lines[i].x>max)
					max=lines[cur].y-lines[i].x;
				cur=i;
			}
			else{
				if(lines[i].y-lines[i].x>max)
					max=lines[i].y-lines[i].x;
			}
		}
		System.out.println(max);
	}
}