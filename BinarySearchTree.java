/**
This program implements a Binary Search Tree (BST) with functionalities for inserting nodes,
 * resetting the root of the tree, and displaying the tree in a structured format.
 * It also provides methods to traverse the tree in different orders: inorder, preorder, and postorder.
 
 
Owner: Abhilash Joshi;
Date: 12/11/2024;
*/
import java.util.Scanner;

/**Represents a node in the binary search tree.
* Constructor to create a new tree node.
* @param item The integer value of the node.
*/
class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;
    int[] nodes; 
    int nodeCount;

    public BinarySearchTree() {
        root = null;
        nodes = new int[100]; 
        nodeCount = 0;
    }
	
	/**
     * Inserts a key into the binary search tree.
     * @param key The integer key to insert.
     */
    void insert(int key) {
        root = insertRec(root, key);
        nodes[nodeCount++] = key; 
    }
	
	/**
     * Helper method for inserting a key recursively in the tree.
     * @param root The root node of the tree.
     * @param key The key to insert.
     * @return The root node after insertion.
     */

    TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.val) {
            root.left = insertRec(root.left, key);
        } else if (key > root.val) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
	
	/**
     * Calculates the height of a given tree node.
     * @param node The tree node to calculate height for.
     * @return The height of the node.
     */

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }
	
	 /**
     * Computes the power of a base raised to an exponent.
     * @param base The base integer.
     * @param exp The exponent integer.
     * @return The result of base raised to the power of exp.
     */

    private int power(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
	
	 /**
     * Prints the binary search tree in a structured format.
     */
    public void printTree() {
        int height = getHeight(root);
        int width = power(2, height + 1);

        String[][] levels = new String[height][width];
        fillLevels(root, 0, 0, width - 1, levels);

        for (String[] level : levels) {
            for (String node : level) {
                System.out.print(node == null ? " " : node);
            }
            System.out.println();
        }
    }
	
	 /**
     * Fills the levels array with tree node values to structure the print layout.
     * @param node The current tree node.
     * @param level The level in the tree.
     * @param left The left boundary.
     * @param right The right boundary.
     * @param levels The 2D array to store node values by level.
     */

    private void fillLevels(TreeNode node, int level, int left, int right, String[][] levels) {
        if (node == null) return;

        int mid = (left + right) / 2;
        levels[level][mid] = String.valueOf(node.val);

        if (node.left != null) {
            for (int i = mid - 1; i > (left + mid) / 2; i--) {
                levels[level][i] = "_";
            }
        }
        if (node.right != null) {
            for (int i = mid + 1; i < (right + mid) / 2; i++) {
                levels[level][i] = "_";
            }
        }

        fillLevels(node.left, level + 1, left, mid - 1, levels);
        fillLevels(node.right, level + 1, mid + 1, right, levels);
    }
	
	/**
     * Performs an inorder traversal of the tree and prints the node values.
     */
    public void inorder() {
        System.out.print("Inorder Traversal: ");
        inorderRec(root);
        System.out.println();
    }
	
	/**
     * Helper method for recursively performing inorder traversal.
     * @param node The current tree node.
     */
    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.val + " ");
            inorderRec(node.right);
        }
    }

    public void preorder() {
        System.out.print("Preorder Traversal: ");
        preorderRec(root);
        System.out.println();
    }
	
	/**
     * Helper method for recursively performing preorder traversal.
     * @param node The current tree node.
     */
    private void preorderRec(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public void postorder() {
        System.out.print("Postorder Traversal: ");
        postorderRec(root);
        System.out.println();
    }
	
	 /**
     * Helper method for recursively performing postorder traversal.
     * @param node The current tree node.
     */
    private void postorderRec(TreeNode node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.val + " ");
        }
    }
	
	 /**
     * Resets the tree with a new root and reconstructs the tree structure.
     * @param newRoot The integer value of the new root node.
     */
    public void resetTree(int newRoot) {
        TreeNode newTree = null; 
        newTree = insertRec(newTree, newRoot);
        for (int i = 0; i < nodeCount; i++) {
            if (nodes[i] != newRoot) {
                newTree = insertRec(newTree, nodes[i]);
            }
        }
        root = newTree; 
    }
	
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter values to insert into the Binary Search Tree: ");
        String[] input = scanner.nextLine().split(" ");
        
        for (int i = 0; i < input.length; i++) {
            int key = Integer.parseInt(input[i]);
            bst.insert(key);
        }
        
        System.out.println("Binary Search Tree:");
        bst.printTree();
		
		bst.inorder();
		 
		bst.preorder();
		 
		bst.postorder();
		
		
        while (true) {
            System.out.print("Do you want to change the root node? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
            System.out.print("Enter the new root node value: ");
            int newRoot = Integer.parseInt(scanner.nextLine());

            bst.resetTree(newRoot);

            System.out.println("Binary Search Tree with new root:");
            bst.printTree();
			
			bst.inorder();
		 
			bst.preorder();
		 
			bst.postorder();
        }
    }
}





    
   