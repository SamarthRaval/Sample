public class SymmetricTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public boolean isSymmetric(TreeNode root)
    {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;

        return node1.val == node2.val &&
                isMirror(node1.left, node2.right) &&
                isMirror(node1.right, node2.left);
    }

    public static void main(String[] args)
    {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);

        root.left = n1;
        root.right = n2;
        root.left.left = n3;
        root.left.right = n5;
        root.right.right = n4;
        root.right.left = n6;

        if(symmetricTree.isSymmetric(root))
            System.out.println("This Tree is Symmetric Tree");
        else
            System.out.println("This Tree is not Symmetric Tree");
    }
}
