import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet122
{

    public static int maxProfit(int[] prices) {
        int i,len=prices.length,re=0;
		if(prices.length>0){
			int min=prices[0];
			for(i=1;i<len;i++){
				if(prices[i]<prices[i-1]){
					if(prices[i-1]-min>0)
						re+=prices[i-1]-min;
					min=prices[i];
				}
			}
			if(len-2>=0 && prices[len-1]>=prices[len-2])
				re+=prices[len-1]-min;
		}
		return re;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] a={1,9,6,9,1,7,1,1,5,9,9,9};
		System.out.println(maxProfit(a));
		reader.close();
	}
}