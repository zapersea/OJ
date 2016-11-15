import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet56
{
    public static class Interval {
    	int start;
      	int end;
      	Interval() { start = 0; end = 0; }
      	Interval(int s, int e) { start = s; end = e; }
    }

    public static class intervalStart implements Comparator<Interval>{
    	@Override
    	public int compare(Interval a,Interval b){
    		if(a.start!=b.start)
    			return a.start-b.start;
    		else
    			return b.end-a.end;
    	}
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new intervalStart());
        int index=0,cnt=0;
        for(int i=1;i<intervals.size();){
        	Interval t=intervals.get(i);
        	if(t.start<=intervals.get(index).end){
        		if(t.end>intervals.get(index).end)
        			intervals.get(index).end=t.end;
        		intervals.remove(i);
        	}
        	else{
        		index=i;
        		i++;
        	}
        }
        return intervals;
    }

	public static void main(String[] args) throws Exception
	{			
		List<Interval> z=new LinkedList<Interval>();
		z.add(new Interval(1,3));
		z.add(new Interval(2,6));
		z.add(new Interval(8,10));
		z.add(new Interval(15,18));
		List<Interval> re=merge(z);
        for(Interval t:re){
        	System.out.println(t.start+"  "+t.end);
        }
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