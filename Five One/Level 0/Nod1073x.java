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
				i--;            //��ϸ˼������-1Ϊʲô����ȡ�࣬�����al��i=0��Ԫ�ر�remove�ˣ���ô��֤��һ�����ʵ��±껹��0��
			}					//��Ӧi=size()-1��remove,��֤��һ�����ʵ��±���0
			i=(i+1)%al.size();
		}
		System.out.println(al.get(0));

	}
}