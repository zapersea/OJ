import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet79
{
	public static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};

	public static boolean bfs(char[][] board,int i,int j,String word,int k,boolean[][] visit){
		if(k==word.length())
			return true;
		boolean flag=false;
		for(int m=0;m<4;m++){  //四周搜索
			int ix=i+dir[m][0];
			int jx=j+dir[m][1];
			if(ix>=0 && ix<board.length && jx>=0 && jx<board[0].length){ //边界判断
				if(board[ix][jx]==word.charAt(k) && visit[ix][jx]==false){ //比较
					visit[ix][jx]=true;	  //标记！！！
					flag=bfs(board,ix,jx,word,k+1,visit);
					if(flag==false)
						visit[ix][jx]=false;  //回溯！！！
				}
			}
			if(flag)
				break;
		}
		return flag;
	}

    public static boolean exist(char[][] board, String word) {
		if(word.length()>board.length*board[0].length) //长度超出，肯定false
			return false;
		boolean flag=false;
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==word.charAt(0)){
					boolean[][] visit=new boolean[board.length][board[0].length];
					visit[i][j]=true;
					flag=bfs(board,i,j,word,1,visit);
					if(flag)
						break;
					else
						visit[i][j]=false; //这里也要回溯
				}
			}
			if(flag)
				break;
		}
		return flag;
    }
	
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		//char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		//String word="ABCB";
		char[][] board={{'a','a','a'},{'a','b','b'},{'a','b','b'},{'b','b','b'},{'b','b','b'},{'a','a','a'},{'b','b','b'},
			{'a','b','b'},{'a','a','b'},{'a','b','a'}};
		String word="aabaaaabbb";
		System.out.println(exist(board,word));
		reader.close();
	}
}