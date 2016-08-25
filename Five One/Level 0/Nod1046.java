import java.io.*;
import java.util.*;

public class Nod1046
{	
	public static long powMod(long a,long b,long c){
		long res = 1;
		while(b>0){
			if((b&1)==1){
				res = (res*a)%c;
			}
			b >>= 1;
			a = (a*a)%c;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		long a = in.nextLong();
		long b = in.nextLong();
		long c = in.nextLong();
		long res = powMod(a,b,c);
		System.out.println(res);
	}
}
