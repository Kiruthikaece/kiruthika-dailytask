class Tree {
    Tree left;
    Tree right;
    int data;
    Tree(int data) {
        this.data=data;
    }
}

public class DiameterTree {
    public static void main(String[] args) {
        
        Tree root=new Tree(1);
        root.left=new Tree(2);
        root.right=new Tree(3);
        root.right.left=new Tree(4);
        root.right.right=new Tree(5);

        int res=findDiameter(root);
        System.out.println("Diameter of the tree:"+res);
    }

    static int diameter=0;
    private static int findDiameter(Tree root) {
       findDiameterTree(root);
       return diameter;
    }
    private static int findDiameterTree(Tree root) {
        if(root==null)
        return 0;

        int left=findDiameterTree(root.left);
        int right=findDiameterTree(root.right);

        diameter=Math.max(diameter,(left+right));

        return 1+Math.max(left,right);
    }
}
