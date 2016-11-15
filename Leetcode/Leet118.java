import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet118
{
    public static List<List<Integer>> generate(int numRows) {
		int i,j;
        List<List<Integer>> z=new LinkedList<List<Integer>>();
		List<Integer> t=new LinkedList<Integer>();
		if(numRows==0)
			return z;
		t.add(1);
		z.add(t);
		for(i=1;i<numRows;i++){
			List<Integer> x=new LinkedList<Integer>();
			x.add(1);
			for(j=1;j<i;j++)
				x.add(z.get(i-1).get(j-1)+z.get(i-1).get(j));
			x.add(1);
			z.add(x);
		}
		return z;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		List<List<Integer>> z=new  LinkedList<List<Integer>>();
		z=generate(5);
		for(List<Integer> z1 : z){
			for(int t : z1 )
				System.out.print(t+" ");
			System.out.println();
		}
		reader.close();
	}
}