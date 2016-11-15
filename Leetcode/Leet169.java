import java.io.*;
import java.util.*;
import java.text.*;

public class  Leet169
{
    public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		System.out.println();
		reader.close();

	}
}
 /*
  2 ©¥©¥©¥©¥©¥©¶¥®¥ê¥®¥ê¡á eye£¡
  3 ©·©³©·©³©·©§¥­¥ê¥­¥ê¡á mind£¡
  4 ©¿©»©¿©»©¿©§£Ü¡ð£¯
  5 ©·©³©·©³©·©§ /
  6 ©¿©»©¿©»©¿©§¥Î)
  7 ©·©³©·©³©·©§
  8 ©¿©»©¿©»©¿©§
  9 ©·©³©·©³©·©§
 10 ©¿©»©¿©»©¿©§
 11 ©·©³©·©³©·©§
 12 ©¿©»©¿©»©¿©§
 13 ©·©³©·©³©·©§
 14 ©§©§©§©§©§©§
 15 ©ß©ß©ß©ß©ß©ß
 16 */