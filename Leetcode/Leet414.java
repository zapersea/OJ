package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/10/20.
 */
public class Leet414 {
    public static int thirdMax(int[] nums)
    {
        long first, second, third;
        first = second = third = Long.MIN_VALUE;
        for (int num : nums)
        {
            if (num == first || num == second || num == third) continue;
            if (num > first)
            {
                third = second;
                second = first;
                first = num;
            }
            else if (num > second)
            {
                third = second;
                second = num;
            }
            else if (num > third) third = num;
        }

        return (third == Long.MIN_VALUE) ? (int)first : (int)third;
    }

    public static void main(String[] args) {
        int[] nums={1,2,-2147483648};
        System.out.println(thirdMax(nums));
    }
}
