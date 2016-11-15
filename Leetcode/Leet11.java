import java.io.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("unchecked")
public class  Leet11
{
    public static int maxArea(int[] height) {
        int i=0,j=height.length-1,s=0;
        while(i<j){
            s=Math.max(s,Math.min(height[i],height[j])*(j-i));
            int x=height[i],y=height[j];
            if(height[i]<height[j]){
                while(i<j&&height[i]<=x)
                    i++;
            }
            else {
                while(i<j&&height[j]<=y)
                    j--;
            }
        }
        return s;
    }

    public static void main(String[] args) throws Exception
    {
        int[] height={3,1,7,5,9,2,4,8,3};
        System.out.println(maxArea(height));
    }

    private static <T> void printLL(List<List<T>> z){
        System.out.println("-----------Print LL---------------");
        for(List<T> t:z){
            for(T x:t)
                System.out.print(x+" ");
            System.out.println();
        }
    }

	private static <T> void printheight(T... height){
		System.out.println("-----------Print height-------------");
		for(T x:height){
				System.out.print(x+" ");
		}
		System.out.println();
	}

}