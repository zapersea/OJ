import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet120
{
    public static int minimumTotal(List<List<Integer>> triangle) {
        int i,j,len=triangle.size();
		for(i=len-2;i>=0;i--){
			List old= triangle.get(i);
			List<Integer> t= new LinkedList<Integer>();
			int wi=old.size();
			for(j=0;j<wi;j++){
				int x=(Integer)old.get(j);
				if(triangle.get(i+1).get(j+1)<=triangle.get(i+1).get(j)) //triangle.get(i+1).get(j+1)肯定不越界
					x+=triangle.get(i+1).get(j+1);
				else
					x+=triangle.get(i+1).get(j);
				t.add(x);
			}
			triangle.remove(i);
			triangle.add(i,t);
		}
		return triangle.get(0).get(0);
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		List<List<Integer>> triangle=new LinkedList<List<Integer>>();
		List<Integer> t1=new LinkedList<Integer>();
		t1.add(2);
		triangle.add(t1);
		List<Integer> t2=new LinkedList<Integer>();
		t2.add(3);
		t2.add(4);
		triangle.add(t2);
		List<Integer> t3=new LinkedList<Integer>();
		t3.add(6);
		t3.add(5);
		t3.add(7);
		triangle.add(t3);
		System.out.println(minimumTotal(triangle));
		reader.close();
	}
}