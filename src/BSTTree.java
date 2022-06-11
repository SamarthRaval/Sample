// BST Tree with the insert method

import java.util.Scanner;

public class BSTTree {

    static class Tree {
        int val;
        Tree left;
        Tree right;
        Tree(int val)
        {
            this.val = val;
        }
    }

    // Method to insert in BST
    static Tree insert(Tree root, int val)
    {
        Tree node = root;
        while(node != null)
        {
            // Insert into right subtree
            if(val > node.val)
            {
                // insert now
                if(node.right == null)
                {
                    node.right = new Tree(val);
                    return root;
                }
                else
                {
                    node = node.right;
                }
            }
            // Insert into left subtree
            else
            {
                // insert now
                if(node.left == null)
                {
                    node.left = new Tree(val);
                    return root;
                }
                else
                {
                    node = node.left;
                }
            }
        }
        return new Tree(val);
    }

    static Tree insertRecursion(Tree root, int val)
    {
        if(root == null)
        {
            return new Tree(val);
        }
        else if(val > root.val)
        {
            root.right = insertRecursion(root.right, val);
        }
        else {
            root.left = insertRecursion(root.left, val);
        }

        return root;
    }

    static Tree insertIterative(Tree root, int val)
    {
        Tree node = root;
        while(node != null)
        {
            // insert on to right subtree
            if(val > node.val)
            {
                if(node.right == null)
                {
                    node.right = new Tree(val);
                    return root;
                }
                else
                {
                    node = node.right;
                }
            }
            // insert onto left subtree
            else
            {
                if(node.left == null)
                {
                    node.left = new Tree(val);
                    return root;
                }
                else
                    node = node.left;
            }
        }

        return new Tree(val);
    }
    public static void main(String[] args)
    {
        Tree root = null;
//        root = insert(root, 50);
//        insert(root, 30);
//        insert(root, 20);
//        insert(root, 40);
//        insert(root, 70);
//        insert(root, 60);
//        insert(root, 80);

        root = insertIterative(root, 50);
        root = insertIterative(root, 30);
        root = insertIterative(root, 20);
        root = insertIterative(root, 40);
        root = insertIterative(root, 70);
        root = insertIterative(root, 60);
        root = insertIterative(root, 80);

        // To print the BST
        System.out.println("Our BST is: ");
        inorder(root);

        System.out.print("\n Search element = ");
        Scanner scan = new Scanner(System.in);
        int search = scan.nextInt();

        if(search(root, search))
            System.out.println("We have found the number");
        else
            System.out.println("Number is not found");
    }

    static boolean search(Tree node, int val)
    {
        if(node == null || val == node.val)
            return val == node.val;

        if(val > node.val)
            search(node.right, val);
        else
            search(node.left, val);

        return false;
    }
    // Inorder is just to print the nodes
    static void inorder(Tree root)
    {
        if(root == null)
            return;
        else{
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }

    }
}
