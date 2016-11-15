import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet39
{
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> z=new LinkedList<List<Integer>>();
        count(z,new LinkedList<Integer>(),candidates,target,0);
        return z;
    }

    private static void count(List<List<Integer>> z,List<Integer> t,int[] candidates,int target,int cur){
        List<Integer> x=new LinkedList<Integer>();
        for(int i:t)
            x.add(i);
        if(cur==candidates.length-1){
            if(target%candidates[cur]==0){
                for(int i=0;i<target/candidates[cur];i++)
                    x.add(candidates[cur]);
                z.add(x);
            }
            return ;
        }
        for(int i=0;i*candidates[cur]<=target;i++){
            count(z,x,candidates,target-i*candidates[cur],cur+1);
            x.add(candidates[cur]);
        }
    }
    
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] candidates={2, 3, 6, 7};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		List<List<Integer>> z=combinationSum(candidates,7);
		for(List<Integer> t:z){
            for(int x:t)
                System.out.print(x+" ");
            System.out.println();
        }
		reader.close();
	}
}