import java.io.*;
import java.util.*;
import java.text.*;

class Zaper {
	public int i;
	public int p;
	public int a;
	
	public Zaper(int i,int p,int a){
		this.i=i;
		this.p=p;
		this.a=a;
	}
}

public class ccf16093 {
	public static void main(String[] args)throws Exception{
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(reader.readLine());
		Zaper[][] a=new Zaper[2][8];
		int[] pet=new int[2];
		boolean m;
		int i,j,me,you,win=2;
		
		for(i=0;i<8;i++){
			a[0][i]=new Zaper(-1,0,0);
			a[1][i]=new Zaper(-1,0,0);
		}
		a[0][0].i=0;
		a[0][0].p=30;
		a[1][0].i=0;
		a[1][0].p=30;
	
		//String[] s=reader.readLine().split(" ");
		String[] s;
		i=0;
		m=true;
		while(i<n){
			if(m==true){
				me=0;
				you=1;
				m=false;
			}
			else{
				me=1;
				you=0;
				m=true;
			}
			do{
				s=reader.readLine().split(" ");
				if(s[0].equals("summon")){
					int po=Integer.parseInt(s[1]);
					int at=Integer.parseInt(s[2]);
					int he=Integer.parseInt(s[3]);
					int cnt=0;
					for(j=1;j<po;j++){
						if(a[me][j].i!=-1)
							cnt++;
					}
					pet[me]++;
					for(j=7;j>po;j--){
						if(a[me][j-1].i!=-1){
						a[me][j].i=a[me][j-1].i+1;
						a[me][j].p=a[me][j-1].p;
						a[me][j].a=a[me][j-1].a;
						}
						else{
							a[me][j].i=-1;
							a[me][j].p=0;
							a[me][j].a=0;
						}
					}
					a[me][po].i=cnt+1;
					a[me][po].p=he;
					a[me][po].a=at;
				}
				else if(s[0].equals("attack")){
					int p1=Integer.parseInt(s[1]);
					int p2=Integer.parseInt(s[2]);
					for(j=0;j<=7;j++){
						if(a[me][j].i==p1)
							p1=j;
					}
					for(j=0;j<=7;j++){
						if(a[you][j].i==p2)
							p2=j;
					}
					a[me][p1].p-=a[you][p2].a;
					if(a[me][p1].p<=0){
						if(p1==0){
							win=you;
							break;
						}
						else{
							pet[me]--;
							for(j=p1;j<7;j++){
								if(a[me][j+1].i!=-1){
									a[me][j].i=a[me][j+1].i-1;
									a[me][j].p=a[me][j+1].p;
									a[me][j].a=a[me][j+1].a;
								}
								else
									a[me][j].i=-1;
							}
						}
					}
					a[you][p2].p-=a[me][p1].a;
					if(a[you][p2].p<=0){
						if(p2==0){
							win=me;
							break;
						}
						else{
							pet[you]--;
							for(j=p2;j<7;j++){
								if(a[you][j+1].i!=-1){
									a[you][j].i=a[you][j+1].i-1;
									a[you][j].p=a[you][j+1].p;
									a[you][j].a=a[you][j+1].a;
								}
								else
									a[you][j].i=-1;
							}
						}
					}
				}				
				i++;
			}while(!s[0].equals("end") && i<n);
		}
		if(win==0)
			win=1;
		else if(win==1)
			win=-1;
		else
			win=0;
		writer.write(win+"\n");
		for(j=0;j<=1;j++){
			writer.write(a[j][0].p+"\n"+pet[j]);
			for(i=1;i<=7;i++){
				if(a[j][i].i!=-1)
					writer.write(" "+a[j][i].p);
			}
			writer.write("\n");
		}
		writer.flush();
	}

}
