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
			//	while(current=null){				�������Ҫ���������ж�currentΪ�գ�Ȼ��Կյ�current��newһ��Node
			//	current = current.next;				����ж�current,��ô����while��ʱ��,current��һ��null,��һ��nullԪ��new��ʱ��
			//	}									��������������ַ,�Ӷ���������һ��Nodeʧȥ����
			//	current = new Node(data);

			while(current.next!=null){				//�������Ҫ��һ��Ҫ�Ƕ�current.next�����ж�
				current = current.next;				
			}
			current.next = new Node(data);          //��current.next��newһ��Node,�������Ա�֤�½ڵ����һ�ڵ�����ӹ�ϵ
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