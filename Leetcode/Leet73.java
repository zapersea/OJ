import java.io.*;
import java.util.*;
import java.text.*;


@SuppressWarnings("unchecked")
public class  Leet73
{
    public static void setZeroes(int[][] matrix) {
        int i,j,k,len=matrix.length,wid=matrix[0].length;
		//�����������ǵ��ң�����һλ������Ԫ�ض�������Ԫ��1
		//�������İ� 1 ��Ϊ���ֵ
		for(i=0;i<len;i++){
			for(j=0;j<wid;j++)
				matrix[i][j]= matrix[i][j]<<1; 
		}
		for(i=0;i<len;i++){
			for(j=0;j<wid;j++){
				if(matrix[i][j]==0){
					for(k=0;k<len;k++)
						matrix[k][j]=1;
					for(k=0;k<wid;k++)
						matrix[i][k]=1;
				}
			}
		}
		// ��ԭ������1�ͱ��0����������һλ
		for(i=0;i<len;i++){
			for(j=0;j<wid;j++){
				if(matrix[i][j]==1)
					matrix[i][j]=0;
				else
					matrix[i][j]=matrix[i][j]>>1;

			}
		}
    }

	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[][] matrix={{-2147483647,   1,  1,  1},{1, 0, 1, 1},{1, 1, 1, 1}};
		setZeroes(matrix);
		for(int[] t:matrix){
			for(int x:t)
				System.out.print(x+" ");
			System.out.println();
		}
		reader.close();
	}
}