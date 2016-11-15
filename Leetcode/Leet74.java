import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet74
{
	public static boolean binarySearch(int[] a,int key){
		int low=0,hi=a.length-1;
		while(low<=hi){
			int mid=(low+hi)/2;
			if(a[mid]==key)
				return true;
			else if (key>a[mid])
				low=mid+1;
			else 
				hi=mid-1;
		}
		return false;
	}

    public static boolean searchMatrix(int[][] matrix, int target) {
        int i,j,len=matrix.length,wid=matrix[0].length;
		if(target<matrix[0][0] || target>matrix[len-1][wid-1])
			return false;
		i=1;
		while(i<len && matrix[i][0]<=target)
			i++;
		i--;
		return binarySearch(matrix[i],target);
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[][] matrix={{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println(searchMatrix(matrix,34));
		reader.close();
	}
}