import java.io.*;
import java.util.*;
import java.text.*;

class Zaper implements Comparable{
	int v;
	int i;

	public Zaper(int v,int i){
		this.v=v;
		this.i=i;
	}

	@Override
	public int compareTo(Object other){
		Zaper o=(Zaper)other;
		return this.v-o.v;
	}
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
@SuppressWarnings("unchecked")
public class  Leet237
{
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { 
	    	val = x; 
	    }
	}

    public void deleteNode(ListNode node) {
    	node.val=node.next.val;
    	node.next=node.next.next;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={3,2,1,0,4};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		System.out.println(intToRoman(38));
		reader.close();
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