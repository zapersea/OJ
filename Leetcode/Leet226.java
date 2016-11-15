package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/11/5.
 */

public class Leet226 {
    public TreeNode invertTree(TreeNode root) {
        exchangeLeftRight(root);
        return root;
    }

    private void exchangeLeftRight(TreeNode root){
        if(root==null)
            return ;
        TreeNode x=root.left;
        root.left=root.right;
        root.right=x;
        exchangeLeftRight(root.left);
        exchangeLeftRight(root.right);
    }

}
