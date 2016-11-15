import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet40x
{
    public static int max=100000;

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] c=new int[max+7];
        for(int i=0;i<candidates.length;i++)
            c[candidates[i]]++;
        int index=0;
        int[] cnt=new int[candidates.length];
        for(int i=0;i<max;i++){
            if(c[i]!=0){
                candidates[index]=i;
                cnt[index]=c[i];
                index++;
            }
        }
        List<List<Integer>> z=new LinkedList<List<Integer>>();
        count2(z,new LinkedList<Integer>(),candidates,cnt,target,0,index);
        return z;
    }

    private static void count2(List<List<Integer>> z,List<Integer> t,int[] candidates,int[] cnt,int target,int cur,int len){
        List<Integer> x=new LinkedList<Integer>();
        int n=target/candidates[cur];
        for(int i:t)
            x.add(i);
        if(cur==len-1){
            if(target%candidates[cur]==0 && n>=0 &&n<=cnt[cur]){
                for(int i=0;i<n;i++)
                    x.add(candidates[cur]);
                z.add(x);
            }
            return ;
        }
        for(int i=0;i<=cnt[cur]&&i*candidates[cur]<=target;i++){
            count2(z,x,candidates,cnt,target-i*candidates[cur],cur+1,len);
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
        int[] candidates1={1,1};
        int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
        printLL(combinationSum2(candidates1,2));
        reader.close();
    }
}