
```Java
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
public class  Leet209
{
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] nums={3,2,1,0,4};
		int[][] matrix={{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,1,0,0}};
		System.out.println();
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
```
检查List<List>是否有相同值元素
```Java
private static boolean checkEqual(List<List<Integer>> z,int a,int b,int c,int d){
    if(z.size()==0)
        return false;
    int[] x={a,b,c,d};
    for(List<Integer> t:z){
        int cnt=0;
        boolean find=true;
        for(int y:t){
            if(y!=x[cnt])
                find=false;
            cnt++;
        }
        if(find)
            return true;
    }
    return false;
}
```

```Java
                if(!checkEqual(z,nums[i],nums[x],nums[y],nums[j])) 
        z.add(Arrays.asList(nums[i],nums[x],nums[y],nums[j]));
```
