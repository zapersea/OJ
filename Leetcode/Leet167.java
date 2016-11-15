import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet167
{
    public static void nextPermutation(int[] nums) {
        int inc=0;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]>nums[i-1])
        		inc=i;
        }
        // case 1
        if(inc==0 ){
        	int i=0;
        	int j=nums.length-1;
        	while(i<j){
        		int x=nums[i];
        		nums[i++]=nums[j];
        		nums[j--]=x;
        	}
        	return ;
        }
        // case 3
        if(inc==nums.length-1){
        	int x=nums[inc];
        	nums[inc]=nums[inc-1];
        	nums[inc-1]=x;
        }
        // case 2
        else{
        	int x=nums[inc-1],min=inc;
        	while(min<nums.length && nums[min]>x)
        		min++;
        	min--; //exchane num
        	//System.out.println(inc+"***"+min);
        	nums[inc-1]=nums[min];
        	nums[min]=x;
        	int i=inc,j=nums.length-1;
        	while(i<j){
        		int y=nums[i];
        		nums[i++]=nums[j];
        		nums[j--]=y;
        	}
        }
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={2,2,7,5,4,3,2,2,1};
		int[] nums1={5,1,1};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		nextPermutation(nums1);
		printNums(nums1);
		reader.close();
	}

	private static void printNums(int[] nums){
		System.out.println("-----------Print Nums-------------");
		for(int x:nums){
				System.out.print(x+" ");
		}
		System.out.println();
	}

	private static <T> void printList(List<T> z){
		System.out.println("-----------Print List-------------");
		for(T x:z){
				System.out.print(x+" ");
		}
		System.out.println();
	}

	private static void printMatrix(int[][] matrix){
		System.out.println("-----------Print Matrix-------------");
		for(int[] t:matrix){
			for(int x:t)
				System.out.print(x+" ");
			System.out.println();
		}
	}

	private static <T> void printLL(List<List<T>> z){
	    System.out.println("-----------Print LL---------------");
	    for(List<T> t:z){
	        for(T x:t)
	            System.out.print(x+" ");
	        System.out.println();
	    }
	}
	
}