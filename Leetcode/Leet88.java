import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet88
{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0,cnt=0;
		int[] t=new int[m+n];
		while(i<m && j<n){
			if(nums1[i]<=nums2[j]){
				t[cnt++]=nums1[i];
				i++;
			}
			else{
				t[cnt++]=nums2[j];
				j++;
			}
		}
		if(i==m){
			for(i=j;i<n;i++)
				t[cnt++]=nums2[i];
		}
		else if(j==n){
			for(j=i;j<m;j++)
			t[cnt++]=nums1[j];
		}
		for(i=0;i<m+n;i++)
			nums1[i]=t[i];
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums1={1,2,4,5,9,10,0,0,0,0,0,0,0,0};
		int[] nums2={3,6,7,8,11,15,19};
		int m=6;
		int n=7;
		merge(nums1, m, nums2, n);
		for(int i=0;i<nums1.length;i++)
			System.out.print(nums1[i]+" ");
		reader.close();
	}
}