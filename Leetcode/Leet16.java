import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet16
{
    public static int threeSumClosest(int[] nums, int target) {
        int closest=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0){
                while(i<nums.length-2 && nums[i]==nums[i-1])
                    i++;
                if(i>=nums.length-2)
                    break;
            }
            int k=i+1,j=nums.length-1,sum2=target-nums[i];           
            if(nums[j]+nums[j-1]<sum2||nums[k]+nums[k+1]>sum2){
                int temp=0;
                int t1=nums[i]+nums[j]+nums[j-1];
                int t2=nums[i]+nums[k]+nums[k+1];
                if(Math.abs(target-t1)<Math.abs(target-t2))
                    temp=t1;
                else
                    temp=t2;
                if(Math.abs(target-temp)<Math.abs(target-closest))
                    closest=temp;
                continue;
            }
            while(k<j){
                if(nums[k]+nums[j]==sum2)
                    return target;
                else{
                    int t3=nums[i]+nums[k]+nums[j];
                    if(Math.abs(target-t3)<Math.abs(target-closest))
                        closest=t3;
                    if(nums[k]+nums[j]<sum2)
                            k++;
                    else j--;
                }
            }
        }
        return closest;       
    }

    public static void main(String[] args) throws Exception
    {
        int[] nums={-3,-2,-5,3,-4};
        System.out.println(threeSumClosest(nums,-1));
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