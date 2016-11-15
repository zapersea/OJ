import java.util.*;
import java.io.*;
import java.text.*;

public class Leet54{

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> z=new LinkedList<Integer>();
        if(matrix.length==0)
        	return z;
        int len=matrix.length,wid=matrix[0].length;
        int x=0,y=0;
        boolean[][] visit=new boolean[len][wid];
        while(true){
        	visit[x][y]=true;
        	z.add(matrix[x][y]);
        	while(y+1<wid&&visit[x][y+1]==false){
        		y++;
        		visit[x][y]=true;
        		z.add(matrix[x][y]);
        	}
        	while(x+1<len&&visit[x+1][y]==false){
        		x++;
        		visit[x][y]=true;
        		z.add(matrix[x][y]);
        	}
        	while(y-1>=0&&visit[x][y-1]==false){
        		y--;
        		visit[x][y]=true;
        		z.add(matrix[x][y]);
        	}
        	while(x-1>=0&&visit[x-1][y]==false){
        		x--;
        		visit[x][y]=true;
        		z.add(matrix[x][y]);
        	}
        	if(y+1<wid && visit[x][y+1]==false)
        		y++;
        	else 
        		break;
        }
        return z;
    }
    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++)
                res.add(matrix[rowBegin][j]);
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++)
                res.add(matrix[j][colEnd]);
            colEnd--;
            
            // Traverse Left
            for (int j = colEnd; j >= colBegin; j --) 
                res.add(matrix[rowEnd][j]);
            rowEnd--;

            // Traver Up
            for (int j = rowEnd; j >= rowBegin; j --) 
                res.add(matrix[j][colBegin]);
            colBegin ++;
        }
        
        return res;
    }
	public static void main(String[] args) throws Exception{
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")),"GBK"));
		int[][] matrix={{2,3},{4,5,6},{7,8,9}};
		List<Integer> z=spiralOrder1(matrix);
		for(int t:z)
			System.out.print(t+" ");
	}
}
