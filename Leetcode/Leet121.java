import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet121
{

    public static int maxProfit(int[] prices) {
        int i,len=prices.length,max=0;
		if(prices!=null){
			int min=prices[0];
			for(i=1;i<len;i++){
				if(prices[i]-min>max)
					max=prices[i]-min;
				if(prices[i]<min)
					min=prices[i];
			}
		}
		return max;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] a={7,1,5,3,6,4};
		System.out.println(maxProfit(a));
		reader.close();
	}
}