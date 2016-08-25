import java.util.*;
import java.io.*;
public class Nod1174x {

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        SegmentTree st = new SegmentTree(nums);

        int Q = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            int start = scanner.nextInt(), end = scanner.nextInt();
            sb.append(st.query(start, end)).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);		//去掉最后一个 '\n'

        System.out.println(sb.toString());
    }

    private static class SegmentTree {
        SegmentTreeNode root;

        public SegmentTree(int[] arr) {
            root = build(0, arr.length - 1, arr);
        }

        private SegmentTreeNode build(int start, int end, int[] arr) {
            if (start == end) {
                return new SegmentTreeNode(start, end, arr[start]);
            }
            int mid = start + (end - start) / 2;
            SegmentTreeNode left = build(start, mid, arr);				//递归
            SegmentTreeNode right = build(mid + 1, end, arr);
            SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
            node.max = Math.max(left.max, right.max);
            node.left = left;
            node.right = right;

            return node;
        }

        public int query(int start, int end) {
            return query(root, start, end);
        }

        private int query(SegmentTreeNode node, int start, int end) {
            if (start > end || node == null) {
                return -1;
            }
            if (start <= node.start && node.end <= end) {		//这一步很关键
                return node.max;
            }
            int mid = (node.start + node.end) / 2;

            int res = Integer.MIN_VALUE;

            if (start <= mid) {				//一共有三种可能
                res = Math.max(res, query(node.left, start, Math.min(end, mid)));
            }
            if (end > mid) {
                res = Math.max(res, query(node.right, Math.max(start, mid + 1), end));
            }

            return res;
        }

    }

    private static class SegmentTreeNode {
        int max;
        SegmentTreeNode left;
        SegmentTreeNode right;
        int start;
        int end;

        public SegmentTreeNode(int s, int e, int v) {
            left = right = null;
            max = v;
            start = s;
            end = e;
        }
    }

}