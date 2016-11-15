import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet66
{
    public static int[] plusOne(int[] digits) {
        int i,j,len=digits.length;
		boolean stop=false;
		for(i=len-1;i>=0;i--){
			digits[i]++;
			if(digits[i]==10)
				digits[i]=0;
			else{
				stop=true;
				break;
			}
		}
		if(stop)
			return digits;
		else{
			int[] re=new int[len+1];
			re[0]=1;
			return re;
		}
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] digits={9,9,9,9};
		int[] re=plusOne(digits);
		for(int i=0;i<re.length;i++)
			System.out.print(re[i]+" ");
		reader.close();
	}
}