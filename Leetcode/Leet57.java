import java.io.*;
import java.util.*;
import java.text.*;

class Interval {
	int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

@SuppressWarnings("unchecked")
public class  Leet57
{
	public class Interval {
		int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
    }

	private static enum region{
		LEFT,
		IN
	}

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	int start=newInterval.start,end=newInterval.end,i=0,j=0;
    	region sRe=region.LEFT,eRe=region.LEFT;
    	for(i=0;i<intervals.size();i++){
			if(start<intervals.get(i).start)
    			break;
    		else if(start>=intervals.get(i).start && start<=intervals.get(i).end){
    			sRe=region.IN;
    			break;
    		}
    	}
    	for(j=i;j<intervals.size();j++){
    		if(end<intervals.get(j).start)
    			break;
    		else if(end>=intervals.get(j).start && end<=intervals.get(j).end){
    			eRe=region.IN;
    			break;
    		}
    	}
    	if(sRe==region.LEFT && eRe==region.LEFT);
    	else if(sRe==region.LEFT && eRe==region.IN){
    		end=intervals.get(j).end;
    		intervals.remove(j);
    	}
    	else if(sRe==region.IN && eRe==region.LEFT){
    		start=intervals.get(i).start;
    	}
     	else if(sRe==region.IN && eRe==region.IN){
    		start=intervals.get(i).start;
    		end=intervals.get(j).end;
    		intervals.remove(j);
    	} 
		for(int k=j-1;k>=i;k--)
			intervals.remove(k);  	
    	intervals.add(i,new Interval(start,end));
    	return intervals;
    }
        
    

	public static void main(String[] args) throws Exception
	{			
		List<Interval> intervals=new LinkedList<Interval>();
		Interval newInterval=new Interval(4,9);
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		intervals=insert(intervals,newInterval);
		for(Interval x:intervals){
			System.out.print(x.start+" "+x.end);
			System.out.println();
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
