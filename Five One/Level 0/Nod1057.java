import java.io.*;
import java.util.*;
import java.math.*;

public class Nod1057
{
	public static void main(String[] args) throws IOException{
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(reader.readLine());
		double intlen=0;
		for(int i=1;i<=N;i++){
			intlen+=Math.log10(i);		
		}
		System.out.println((int)intlen+1);
	}
}