package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/10/19.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Leet141 {
    public boolean hasCycle(ListNode head) {
        if (head==null)
            return true;
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next==head)
                return true;
            else {
                ListNode t=cur.next;
                cur.next=head;
                cur=t;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
