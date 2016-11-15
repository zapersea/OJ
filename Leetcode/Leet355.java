package com.zaper.sea.leet;

import java.util.*;
/**
 * Created by Zaper Ocean on 2016/11/13.
 */
public class Leet355 {
    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1,5);
        System.out.println(obj.getNewsFeed(1));
        obj.follow(1,2);
        obj.postTweet(2,6);
        System.out.println(obj.getNewsFeed(1));
        obj.unfollow(1,2);
        System.out.println(obj.getNewsFeed(1));
    }
}
