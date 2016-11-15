import java.io.*;
import java.util.*;

public class Leet80 {

	public static int[] nums={1,1,1,2,2,3};

    public static int removeDuplicates(int[] nums) {
		int i,cnt=0,n=1,len=nums.length;
		for(i=1;i<len;i++){
			//nums[i]==nums[i-1]有n>=1,又n<2，所以n=1
			if(nums[i]==nums[i-1] && n==1){ 
				nums[++cnt]=nums[i];
				n++;
			}
			else if(nums[i]!=nums[i-1]) {
				nums[++cnt]=nums[i];
				n=1;
			}
		}
        return cnt+1; //cnt需要+1
    }

	public static void main(String[] args){
		System.out.println(removeDuplicates(nums));
		for(int i=0;i<nums.length;i++);
			//System.out.println(nums[i]+" ");
	}

}