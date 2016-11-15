import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet289{
	/* d=death, l=live
	0  d->d
	1  l->l		注意，这里1必须是l->x，这样无论是状态未改变的1还是l-x,真实前状态都是1
	2  l->d
	3  d->l
	1	0,1 ->0 die
	1	2,3  ->1 live
	1	4,5,6,7,8 ->0 die
	0	3 ->  1  live
	*/
	public static int[][] dir={{0,-1},{0,1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

    public static void gameOfLife(int[][] board) {
		int i,j,k,cnt;
		for(i=0;i<board.length;i++){
			for(j=0;j<board[0].length;j++){
				cnt=0;
				for(k=0;k<8;k++){
					int in=i+dir[k][0];
					int jn=j+dir[k][1];
					if(in>=0 && in<board.length && jn>=0 && jn<board[0].length){
						if(board[in][jn]==1||board[in][jn]==2)
							cnt++;
					}
				}
				if(board[i][j]==1 && (cnt<2||cnt>3))
						board[i][j]=2;
				else if(board[i][j]==0 && cnt==3)
					board[i][j]=3;
			}
		}
		// 还原
		for(i=0;i<board.length;i++){
			for(j=0;j<board[0].length;j++){
				if(board[i][j]==1||board[i][j]==3)
					board[i][j]=1;
				else
					board[i][j]=0;
			}
		}
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[][] board={{1,1,0},{0,0,0},{0,0,1}};
		gameOfLife(board);
		for(int[] t:board){
			for(int x:t )
				System.out.print(x+" ");
			System.out.println();
		}
		reader.close();
	}
}