//	2016/8/23	11:53
import java.io.*;
import java.util.*;

public class Nod1009x
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long res = 0;
        long time = 1;
        while((long)n / time != 0){
            long cur = (n / time) % 10;
            long upper = n / time / 10;
            long lower = n - (n / time) * time;
            if(cur == 0)
                res += upper * time;
            else if(cur == 1)   
                res += upper * time + lower + 1;
            else
                res += (upper + 1) * time;
            time *= 10;
        }
        System.out.println(res);
    }
}
