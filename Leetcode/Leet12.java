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

@SuppressWarnings("unchecked")
public class  Leet12
{
	public static String[] I={"I","II","III","IV","V","VI","VII","VIII","IX"};
	public static String[] X={"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
	public static String[] C={"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
	public static String[] M={"M","MM","MMM"};

    public static String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        if(num/1000>0)
        	sb.append(M[num/1000-1]);
        num=num%1000;
        if(num/100>0)
        	sb.append(C[num/100-1]);
        num=num%100;
        if(num/10>0)
        	sb.append(X[num/10-1]);
        num=num%10;
        if(num>0)
        	sb.append(I[num-1]);
        return sb.toString();
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