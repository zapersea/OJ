import java.io.*;
import java.util.*;

public class Leet26 {

	public static int[] nums={1,1,2,2};

    public static int removeDuplicates() {
		int cnt=0;
		for(int i=1;i<nums.length;i++){
			if(nums[i]!=nums[i-1])
				cnt++;
		}
		return cnt+1;
	}

	public static void main(String[] args){
		System.out.println(removeDuplicates());
	}

}