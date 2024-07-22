class TNode {
    TNode left;
    TNode right;
    int data;

    TNode(int data) {
        this.data=data;
    }

} 

class Binarytree {
    TNode root;

    Binarytree(int data) {
        root = new TNode(data);
    }

    public void insertLeft(TNode parent, int data) {
        if (parent != null) {
            parent.left = new TNode(data);
        } else {
            System.out.println("Parent node is null. Cannot insert left child.");
        }
    }

    public void insertRight(TNode parent, int data) {
        if (parent != null) {
            parent.right = new TNode(data);
        } else {
            System.out.println("Parent node is null. Cannot insert right child.");
        }
    }

    public void preorder(TNode root) {
         if(root==null)
         return;
         else {
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
         }
    }
}

public class PreOrder {
    public static void main(String[] args) {
        
        Binarytree t=new Binarytree(1);
       
    t.insertLeft(t.root,2);
    t.insertRight(t.root,3);
    t.insertLeft(t.root.left,4);
    t.insertRight(t.root.right,5);

    t.preorder(t.root);

    }
}
