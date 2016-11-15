import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet15
{

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> z=new LinkedList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++){
            if(i>0){
                while(i<nums.length-2 && nums[i]==nums[i-1])
                    i++;
                if(i>=nums.length-2)
                    break;
            }
            int target=-nums[i];
            int j=nums.length-1;
            // !! 去掉下面几行continue情况预判，就会TLE
            while(j>i && nums[j]*2<target)
                j--;
            if(j==i)
                continue;
            int k=i+1;
            while(k<j && nums[k]*2>target)
                k++;
            if(k==j)
                continue;
            while(k<j){
                if(nums[k]+nums[j]==target){
                    z.add(Arrays.asList(nums[i],nums[k++],nums[j--]));
                    while(k<j && nums[k]==nums[k-1])
                        k++;
                    while(k<j && nums[j]==nums[j+1])
                        j--;
                }
                else if(nums[k]+nums[j]<target)
                        k++;
                else j--;
            }
        }
        return z;
    }

    public static void main(String[] args) throws Exception
    {
        int[] nums={0,0,0,0,0,0};
        List<List<Integer>> z=threeSum(nums);
        printLL(z);
    }

    private static <T> void printLL(List<List<T>> z){
        System.out.println("-----------Print LL---------------");
        for(List<T> t:z){
            for(T x:t)
                System.out.print(x+" ");
            System.out.println();
        }
    }

	private static <T> void printNums(T... nums){
		System.out.println("-----------Print Nums-------------");
		for(T x:nums){
				System.out.print(x+" ");
		}
		System.out.println();
	}

}