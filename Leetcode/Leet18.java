import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet18
{

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> z=new LinkedList<List<Integer>>();
        boolean[][] visit=new boolean[nums.length][nums.length];
        Arrays.sort(nums);
        countSum4(z,nums,visit,target,0,nums.length-1);
        return z;
    }

    private static void countSum4(List<List<Integer>> z,int[] nums,boolean[][] visit,int target,int i,int j){
        if(i+1>=j-1 || visit[i][j])
            return ;
        visit[i][j]=true;
        int x=i+1;
        int y=j-1;
        int sum2=nums[i]+nums[j];
        int sum=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        while(x<y){
            sum=nums[x]+nums[y];
            min=Math.min(min,sum);
            max=Math.max(max,sum);
            if(sum==target-sum2 ){
                if(!checkEqual(z,nums[i],nums[x],nums[y],nums[j])) 
                    z.add(Arrays.asList(nums[i],nums[x],nums[y],nums[j]));
                x++;
                y--;
            }
            else if(sum>target-sum2)
                y--;
            else if(sum<target-sum2)
                x++;
        }
        if(max+sum2<target)
            countSum4(z,nums,visit,target,i+1,j);
        else if(min+sum2>target)
            countSum4(z,nums,visit,target,i,j-1);
        else{
            countSum4(z,nums,visit,target,i+1,j);
            countSum4(z,nums,visit,target,i,j-1);
        }
    }

    private static boolean checkEqual(List<List<Integer>> z,int a,int b,int c,int d){
        if(z.size()==0)
            return false;
        int[] x={a,b,c,d};
        for(List<Integer> t:z){
            int cnt=0;
            boolean find=true;
            for(int y:t){
                if(y!=x[cnt])
                    find=false;
                cnt++;
            }
            if(find)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception
    {
        int[] nums={-1,-5,-5,-3,2,5,0,4};
        List<List<Integer>> z=fourSum(nums,-7);
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