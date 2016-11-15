package com.zaper.sea.leet;

import java.util.*;

/**
 * Created by Zaper Ocean on 2016/10/19.
 */

public class leet104 {

    static class TreeDep{
        TreeNode t;
        int d;

        TreeDep(TreeNode t,int d){
            this.t=t;
            this.d=d;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return bfs(root);
    }

    public static int bfs(TreeNode root){
        Queue<TreeDep> z=new LinkedList<TreeDep>();
        int d=1;
        z.add(new TreeDep(root,d));
        while(!z.isEmpty()){
            TreeDep x=z.poll();
            TreeNode left=x.t.left;
            TreeNode right=x.t.right;
            d=x.d;
            if(left!=null)
                z.add(new TreeDep(left,d+1));
            if(right!=null)
                z.add(new TreeDep(right,d+1));
        }
        return d;
    }


}
