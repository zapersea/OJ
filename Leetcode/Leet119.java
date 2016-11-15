import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet119
{
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> t=new ArrayList<Integer>();
		int i,j,tmp,m;
		for(i=0;i<=rowIndex;i++);
			t.add(0);
		t.remove(0);
		t.add(0,1);
		if(rowIndex==0)
			return t;
		for(i=1;i<=rowIndex;i++){
			tmp=t.get(0);
			for(j=1;j<i;j++){
				//int cut=a.get(j);
				m=tmp+t.get(j);
				t.remove(j);
				t.add(j,m);
				//tmp=cur;
				tmp=t.get(j)-tmp;
			}
			t.add(i,1);
		}
		return t;
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		List<Integer> z=new  ArrayList	<Integer>();
		z=getRow(5);
		for(int t : z )
			System.out.print(t+" ");
		reader.close();
	}
}