//  ArrayList
import java.io.*;
import java.util.*;

public class  Nod1073x
{
	public static void main(String[] args) throws IOException
	{	
		ArrayList<Integer> al=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		sc.close();
		int i=n,count=0;
		for(i=1;i<=n;i++)
			al.add(i);
		i=0;
		while(al.size()>1){
			count++;
			if(count==k){
				al.remove(i);
				count=0;
				i--;            //仔细思考这里-1为什么不用取余，如果是al的i=0的元素被remove了，怎么保证下一个访问的下标还是0，
			}					//对应i=size()-1被remove,保证下一个访问的下标是0
			i=(i+1)%al.size();
		}
		System.out.println(al.get(0));

	}
}