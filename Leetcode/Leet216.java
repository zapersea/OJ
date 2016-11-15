import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet216
{
    public static List<List<Integer>> combinationSum3(int k,int n) {
        int[] candidates={1,2,3,4,5,6,7,8,9};
        List<List<Integer>> z=new LinkedList<List<Integer>>();
        count3(z,new LinkedList<Integer>(),n,1,k);
        return z;
    }

    private static void count3(List<List<Integer>> z,List<Integer> t,int target,int cur,int time){
        if(time==0 && target==0){
            z.add(new LinkedList(t));
            return;
        }
        if(target<0 || time<0 ||cur>=10)
            return;
        count3(z,t,target,cur+1,time);
        t.add(cur);
        count3(z,t,target-cur,cur+1,time-1);
        t.remove(t.size()-1);
    }

    private static void printLL(List<List<Integer>> z){
        System.out.println("-------------------------");
        for(List<Integer> t:z){
            for(int x:t)
                System.out.print(x+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception{           
        //BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
        int[] candidates={2, 3, 6, 7};
        int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
        List<List<Integer>> z=combinationSum3(3,9);
        printLL(z);
        reader.close();
    }
}