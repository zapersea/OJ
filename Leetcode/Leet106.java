import java.io.*;
import java.util.*;
import java.text.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
 }

@SuppressWarnings("unchecked")
public class  Leet106
{
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, postorder,0,inorder.length-1,0,postorder.length-1);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder,int is,int ie,int ps,int pe) {
		if(is>ie||ps>pe)
			return null;
		int i=0,left=-1,right=-1,index=0;
		TreeNode root=new TreeNode(postorder[pe]);
		for(i=is;i<=ie;i++){	//找根节点的位置
			if(inorder[i]==postorder[pe]){
				index=i;
				break;
			}
		}
		left=index-is;	//左子树中节点个数
		right=ie-index;	//右字数中节点个数
		if(left>0)
			root.left=buildTree(inorder, postorder,is,index-1,ps,ps+left-1);
		if(right>0)
			root.right=buildTree(inorder, postorder,index+1,ie,pe-right,pe-1);
		return root;
    }

	public static void search(TreeNode t){
		if(t==null)
			return ;
		System.out.print(t.val+" ");
		search(t.left);
		search(t.right);
	}
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] inorder ={6,4,7,2,5,1,8,3,9 };
		int[] postorder={6,7,4,5,2,8,9,3,1 };
		TreeNode t=buildTree(inorder,postorder);
		search(t);
		reader.close();
	}
}