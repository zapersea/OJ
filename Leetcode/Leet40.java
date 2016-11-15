import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet40
{
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] cnt=new int[candidates.length];
        int index=0,num=1;
        for(int i=1;i<candidates.length;i++){
            if(candidates[i]==candidates[i-1])
                num++;
            else{
                candidates[index]=candidates[i-1];
                cnt[index]=num;
                num=1;
                index++;
            }
        }
        candidates[index]=candidates[candidates.length-1];
        cnt[index]=num;
        int[] newCandidates=new int[index+1];
        int[] newCnt=new int[index+1];
        for(int i=0;i<=index;i++){
            newCandidates[i]=candidates[i];
            newCnt[i]=cnt[i];
        }
        List<List<Integer>> z=new LinkedList<List<Integer>>();
        count2(z,new LinkedList<Integer>(),newCandidates,newCnt,target,0);
        return z;
    }

    private static void count2(List<List<Integer>> z,List<Integer> t,int[] candidates,int[] cnt,int target,int cur){
        List<Integer> x=new LinkedList<Integer>();
        for(int i:t)
            x.add(i);
        if(cur==candidates.length-1){
            int re=target/candidates[cur];
            if(target%candidates[cur]==0 &&re>=0 && re<=cnt[cur]){
                for(int i=0;i<re;i++)
                    x.add(candidates[cur]);
                z.add(x);
            }
            return ;
        }
        for(int i=0;i<=cnt[cur];i++){
            count2(z,x,candidates,cnt,target-i*candidates[cur],cur+1);
            x.add(candidates[cur]);
        }
    }

    private static void printLL(List<List<Integer>> z){
        for(List<Integer> t:z){
            for(int x:t)
                System.out.print(x+" ");
            System.out.println();
        }
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] candidates={10, 1, 2, 7, 6, 1, 5};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		printLL(combinationSum2(candidates,8));
		reader.close();
	}
}