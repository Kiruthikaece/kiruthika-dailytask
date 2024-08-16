class TNode {

    TNode left;
    TNode right;
    int data;

    TNode(int data) {
        this.data=data;
    }
}

public class MaximumPathSum {
    public static void main(String[] args) {
        TNode root=new TNode(-10);
        root.left=new TNode(9);
        root.right=new TNode(20);
        root.right.left=new TNode(15);
        root.right.right=new TNode(7);

        int res=findMaximumPath(root);
        System.out.println(res);
    }

    private static int findMaximumPath(TNode root) {
       int[] max=new int[1];
       max[0]=Integer.MIN_VALUE;
       getMaxPath(root,max);
       return max[0];
    }

    private static int getMaxPath(TNode root, int[] max) {
       if(root==null)
       return 0;

        int leftTNode=Math.max(0,getMaxPath(root.left,max));
        int rightTNode=Math.max(0,getMaxPath(root.right,max));

        max[0]=Math.max(max[0],leftTNode+rightTNode+root.data);

        return root.data+Math.max(leftTNode,rightTNode);
    }
}
