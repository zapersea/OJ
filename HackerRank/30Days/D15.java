import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

public class D15 {
	    public static  Node insert(Node head,int data) {
        //Complete this method
		if (head==null) {
			head = new Node(data);
			return head;
		}else{
		    Node current =head;
			//	while(current=null){				这里很重要，绝不能判断current为空，然后对空的current新new一个Node
			//	current = current.next;				如果判断current,那么跳出while的时候,current是一个null,对一个null元素new的时候
			//	}									会给它分配随机地址,从而与它的上一个Node失去连接
			//	current = new Node(data);

			while(current.next!=null){				//这里很重要，一定要是对current.next进行判断
				current = current.next;				
			}
			current.next = new Node(data);          //对current.next新new一个Node,这样可以保证新节点和上一节点的连接关系
		}
		return head;
    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}