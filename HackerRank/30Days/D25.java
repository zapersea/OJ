import java.io.*;
import java.util.*;

public class D25 {

    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int data,i;
		boolean flag;
		while(T-->0){
			data=sc.nextInt();
			flag=true;
			if (data>1){
				for(i=2;i<Math.pow(data,1.0/2);i++){
				if(data%i==0)  
					flag=false; }
			}else flag=false;			// 1很特殊，它不是质数 ！！！
			if(flag) 
				System.out.println("Prime");
			else 
				System.out.println("Not prime");
	   }
	   sc.close();
	}
}