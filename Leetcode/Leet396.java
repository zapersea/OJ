import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet396
{
    public static int maxRotateFunction(int[] A) {
		int i,len=A.length;
		int re=0,sum=0,max=0;
		for(i=0;i<len;i++){
			re+=i*A[i];
			sum+=A[i];
		}
		max=re;		//这个别忘了
		for(i=len-1;i>0;i--){
			re+=sum-A[i];
			re-=A[i]*(len-1);
			if(re>max)
				max=re;
		}
        return max;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] a={1,2,3,4,5,6,7,8,9,10};
		System.out.println(maxRotateFunction(a));
		reader.close();
	}
}