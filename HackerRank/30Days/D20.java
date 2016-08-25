import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class D20 {

	static int allSwaps=0;
	
	public static void swap(int[] a,int j)
	{
		int temp=a[j];
		a[j]=a[j+1];
		a[j+1]=temp;
	}

	public static void bubbleSort(int n,int[] a)
	{
		for (int i = 0; i < n; i++) {
			int numberOfSwaps = 0;
			
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a,j);
					numberOfSwaps++;
				}
			}
			allSwaps+=numberOfSwaps;
			if (numberOfSwaps == 0) {
				break;
			}
		}	
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
		in.close();
		bubbleSort(n,a);
		System.out.println("Array is sorted in "+allSwaps+" swaps.");
		System.out.println("First Element: "+a[0]);
		System.out.println("Last Element: "+a[n-1]);
    }
}
