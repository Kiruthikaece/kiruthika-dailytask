class Dnode {
    Dnode left;
    Dnode right;
    int data;

    Dnode(int data) {
        this.data=data;
    }
}

class HBinaryTree {
        Dnode root;

        public int heightTree(Dnode root) {

            if(root==null)
            return 0;

            int DepthL= heightTree(root.left);
            int DepthR= heightTree(root.right);

            if(DepthL>DepthR)
            return DepthL+1;
            else
            return DepthR+1;
        }
}


public class HeightBinaryTree {

    public static void main(String[] args) {
        HBinaryTree t=new HBinaryTree();
        t.root=new Dnode(1);
        t.root.left=new Dnode(2);
        t.root.left.left=new Dnode(4);
        t.root.left.right=new Dnode(3);
        t.root.left.left.left=new Dnode(5);

        System.out.println("Height of Binary tree:"+t.heightTree(t.root));
    }
}
