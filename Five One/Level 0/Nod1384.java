import java.io.*;
import java.util.*;

public class  Nod1384
{
	static List<String> L=new ArrayList<String>();
	static Set<String> S=new HashSet<String>();

	public static void swap(char[] c,int a,int b){
		char temp=c[a];
		c[a]=c[b];
		c[b]=temp;
	}

	public static void fullArray(char[] c,int cur ,int end){
		if(cur==end){
			String t=String.valueOf(c);
			if(!S.contains(t)){			//���� ͨ��HashSet��contains()�����ж���������Ƿ���֮ǰ�Ѿ��еģ�ȥ�ظ���
				S.add(t);
				L.add(t);
			}
		}
		else{
			for(int k=cur;k<=end;k++){
				swap(c,cur,k);   
				fullArray(c,cur+1,end);
				swap(c,cur,k);
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	    String s=reader.readLine();
		char[] c=s.toCharArray();
		fullArray(c,0,c.length-1);
		Collections.sort(L);
        for(String t :L){
			System.out.println(t);
		}
	}
}