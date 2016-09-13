import java.util.*;
import java.io.*;

public class ccf15094 {
	
	/*
	 * 
	 * 连通图 的应用
	 */
	@SuppressWarnings("unchecked")
	//public static Vector<Integer> []g = new Vector[10005];
	public static ArrayList<Integer> g[] = new ArrayList[10005];
	@SuppressWarnings("unchecked")
	public static ArrayList<Integer> component[] = new ArrayList[10005];
	
	
	public static int []STACK = new int[10005];
	static int TOP=0;    
    static boolean [] instack = new boolean[10005];    //用来标记哪些点当前在Stack中，从而不用遍历Stack判断
	static int []dfn = new int[10005];    
	static int []low = new int[10005];    
	static int index=1;    
	static int cnt=0; 
	static int ans=0;

	public static void main(String[] args) throws Exception
	{
		int n =0,m=0,x=0,y=0;
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/data.txt")),"GBK"));
		String[] s=reader.readLine().split(" ");
	    n = Integer.parseInt(s[0]);
	    m = Integer.parseInt(s[1]);
	    
	    for(int i = 0;i<n+1;i++)
	    {
	    	g[i] = new ArrayList<Integer>();
	    	
	    }
	    for(int i = 0;i<5000;i++)
	    {
	    	component[i] = new ArrayList<Integer>();
	    }
	    for(int i = 0;i<m;i++)
	    {
			String[] t=reader.readLine().split(" ");
	    	x=Integer.parseInt(t[0]);
	    	y=Integer.parseInt(t[1]);
	    	g[x].add(y);
	    }
	    for(int i=1;i<=n;i++){    
	        if(dfn[i]==0)
	        	tarjan(i);    
	    } 
		reader.close();
	    System.out.println(ans);
	     
	}
	
	static void tarjan(int x){    
	    dfn[x]=low[x]=index++;    
	    instack[x]=true;    
	    STACK[++TOP]=x;    
	    int j; 
	    
	    for(int i=0;i<g[x].size();i++){     //每个节点都只遍历了一次，节省了时间  
	        j=g[x].get(i);    
	        if(dfn[j]==0){    
	            tarjan(j);    
	            low[x]=Math.min(low[x],low[j]);    
	        }    
	        else if(instack[j]){    
	            low[x]=Math.min(low[x],dfn[j]);    
	        }    
	    }    
	    if(dfn[x]==low[x]){    
	            cnt++;
				int count=0;
	            do{    
	                j=STACK[TOP--];    
	                instack[j]=false;    
	                component[cnt].add(j);
					count++;
	            }while(x!=j);
				ans+=count*(count-1)/2;
	    }    
	}    
	

}