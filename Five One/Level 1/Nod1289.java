//	2016/8/24	15:52
import java.io.*;
import java.util.*;

public class Nod1289
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(reader.readLine());
		int i,cnt=0;
		int[] a=new int[n];
		Stack<Integer> st=new Stack<Integer>();
		for(i=0;i<n;i++){
			String[] s=reader.readLine().split(" ");
			a[i]=Integer.parseInt(s[0]);
			if(Integer.parseInt(s[1])==0)
				a[i]*=-1;
		}
		for(i=0;i<n;i++){
			int data=a[i];
			if(data<0){
				while(!st.empty()&& st.peek()>0 ){
					if(st.peek()<-data)
						st.pop();
					else
						break;	//�������st.peek()>0������Ҫpush data
				}
				if(st.empty() || st.peek()<0)	//ջ�ռ�������ߵ��㶼�����ˣ���ѹջ��
					st.push(data);
			}
			else
				st.push(data);
		}
		while(!st.empty()){
			st.pop();
			cnt++;
		}
		writer.write(cnt+"\n");
		writer.flush();
	}
}
//	17:45