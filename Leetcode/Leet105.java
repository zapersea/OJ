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
public class  Leet105
{

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree( preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder,int ps,int pe,int is,int ie) {
		if(is>ie||ps>pe)
			return null;
		int i=0,left=-1,right=-1,index=0;
		TreeNode root=new TreeNode(preorder[ps]);
		for(i=is;i<=ie;i++){	//找根节点的位置
			if(inorder[i]==preorder[ps]){
				index=i;
				break;
			}
		}
		left=index-is;	//根据根节点在中序的位置得到，左子树中节点个数
		right=ie-index;	//根据根节点在中序的位置得到，右字数中节点个数
		if(left>0)
			root.left=buildTree(preorder, inorder,ps+1,ps+left,is,index-1);
		if(right>0)
			root.right=buildTree(preorder, inorder,pe-right+1,pe,index+1,ie);
		return root;
    }

	public static void search(TreeNode t){
		if(t==null)
			return ;
		search(t.left);
		search(t.right);
		System.out.print(t.val+" ");
	}
	public static void main(String[] args) throws Exception
	{			
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\data.txt")) ,"GBK") );
		int[] preorder ={1,2,4,6,7,5,3,8,9};
		int[] inorder ={6,4,7,2,5,1,8,3,9 };
		int[] postorder={6,7,4,5,2,8,9,3,1 };
		TreeNode t=buildTree(preorder,inorder);
		search(t);
		reader.close();
	}
}