package com.zaper.sea.leet;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Zaper Ocean on 2016/11/20.
 */
public class Leet94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> re=new LinkedList<Integer>();
        if(root==null)
            return re;
        List<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        for(int i=0;i<queue.size();i++){
            TreeNode t=queue.get(i);
            //必须先处理Right，因为处理left可能改变i的值
            if(t.right!=null){
                queue.add(i+1,t.right);
                t.right=null;
            }
            if(t.left!=null){
                queue.add(i,t.left);
                i--;
                t.left=null;
            }
        }
        for(TreeNode t:queue)
            re.add(t.val);
        return re;
    }
}
