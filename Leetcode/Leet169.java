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
  2 ���������������ꥮ��� eye��
  3 ���������������ꥭ��� mind��
  4 �������������ܡ�
  5 ������������ /
  6 ��������������)
  7 ������������
  8 ������������
  9 ������������
 10 ������������
 11 ������������
 12 ������������
 13 ������������
 14 ������������
 15 �ߩߩߩߩߩ�
 16 */