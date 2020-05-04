class TreeNodeSpl{
    public int data;
    public TreeNodeSpl parent;
    public TreeNodeSpl left;
    public TreeNodeSpl right;
    public TreeNodeSpl(int data){
        this.data=data;
        this.left = null;
        this.right=null;
        this.parent=null;
    }
}

public class InorderSuccessor{
    private static TreeNodeSpl leftMost(TreeNodeSpl root){
        if(root == null)
            return root;
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    private static TreeNodeSpl nextParent(TreeNodeSpl root){
        TreeNodeSpl parent = root.parent;
        while(parent.left != root){
            root = root.parent;
            parent= root.parent;
        }
        return parent;
    }
    public static TreeNodeSpl nextElement(TreeNodeSpl root){
        if(root== null)
            return null;
        if(root.right != null){
            return leftMost(root.right);
        }
        return nextParent(root);
    }
    public static void main(String[] args) {
        TreeNodeSpl root = new TreeNodeSpl(1);
        TreeNodeSpl n1 = new TreeNodeSpl(2);
        TreeNodeSpl n2 = new TreeNodeSpl(3);
        TreeNodeSpl n3 = new TreeNodeSpl(4);
        TreeNodeSpl n4 = new TreeNodeSpl(5);
        TreeNodeSpl n5 = new TreeNodeSpl(6);
        TreeNodeSpl n6 = new TreeNodeSpl(7);
        TreeNodeSpl n7 = new TreeNodeSpl(8);
        TreeNodeSpl n8 = new TreeNodeSpl(9);
        root.left = n1;
        root.right = n2;
        n1.parent = root;
        n2.parent= root;
        n1.left=n3;
        n1.right=n4;
        n3.parent = n1;
        n4.parent= n1;
        n2.left = n5;
        n2.right = n6;
        n5.parent = n2;
        n6.parent = n2;
        n6.right = n7;
        n7.parent = n6;
        n7.left = n8;
        n8.parent = n7;
        
        TreeNodeSpl node = nextElement(n6);
        System.out.println("Inorder Successor of "+n6.data+" is "+node.data);

    }
}