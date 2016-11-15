import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet152x
{
    public static int maxProduct(int[] nums) {
		if (nums.length==0)
            return 0;

        int res = nums[0];
        int product = 1;
        for (int i = 0; i < nums.length; i++){
            product *= nums[i];
            res = Math.max(res, product);
            if (nums[i] == 0)
                product = 1;
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            product *= nums[i];
            res = Math.max(res, product);
            if (nums[i] == 0)
                product = 1;
        }
        return res;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		//int[] nums={2,3,-2,4,-3,5,-1,4};
		int[] nums={0,2};
		System.out.println(maxProduct(nums));
		reader.close();
	}
}