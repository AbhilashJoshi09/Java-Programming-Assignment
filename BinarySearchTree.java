import java.util.Scanner;

public class BinarySearchTree {
    /**
     * This class represents a Node in the binary search tree.
     */
    private class Node {
        int value;
        Node left, right;
        /**
         * Constructor to create a new node.
         * @param value the value of the node.
         */
        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

     /**
     * Recursive helper function to insert a value into the tree.
     * @param node the current node in the tree.
     * @param value the value to be inserted.
     * @return the updated node after insertion.
     */
    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    /**
     * Removes a value from the binary search tree.
     * @param value the value to be removed.
     */
    public void remove(int value) {
        root = removeRecursive(root, value);
    }

    /**
     * Recursive helper function to remove a value from the tree.
     * @param node the current node in the tree.
     * @param value the value to be removed.
     * @return the updated node after removal.
     */
    private Node removeRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = removeRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = removeRecursive(node.right, value);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.value = findMin(node.right);
            node.right = removeRecursive(node.right, node.value);
        }
        return node;
    }

     /**
     * Finds the minimum value in a subtree.
     * @param node the starting node of the subtree.
     * @return the minimum value in the subtree.
     */
    private int findMin(Node node) {
        int min = node.value;
        while (node.left != null) {
            min = node.left.value;
            node = node.left;
        }
        return min;
    }

    /**
     * Computes the height of the binary search tree.
     * @param node the current node in the tree.
     * @return the height of the tree.
     */
    public int getHeight(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * Returns a string representation of the binary search tree.
     * @return a string representation of the binary search tree.
     */
    @Override
    public String toString() {
        if (root == null) {
            return "Tree is empty.";
        }
        int height = getHeight(root);
        int width = (1 << height) * 4;
        int rows = height * 4;
        String[][] treeDisplay = new String[rows][width];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < width; j++) {
                treeDisplay[i][j] = " ";
            }
        }
        fillTreeDisplay(root, treeDisplay, 0, 0, width);
        StringBuilder result = new StringBuilder();
        for (String[] row : treeDisplay) {
            int lastNonSpace = row.length - 1;
            while (lastNonSpace >= 0 && row[lastNonSpace].equals(" ")) {
                lastNonSpace--;
            }
            for (int i = 0; i <= lastNonSpace; i++) {
                result.append(row[i]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * Fills a 2D array to represent the tree visually.
     * @param node the current node in the tree.
     * @param treeDisplay the 2D array representing the tree.
     * @param row the current row in the tree display.
     * @param col the current column in the tree display.
     * @param width the width of the tree display.
     */
    private void fillTreeDisplay(Node node, String[][] treeDisplay, int row, int col, int width) {
        if (node == null)
            return;
        String nodeValue = String.valueOf(node.value);
        int nodeWidth = nodeValue.length();
        int center = col + width / 2;
        int start = center - nodeWidth / 2;

        for (int i = 0; i < nodeWidth; i++) {
            if (start + i < treeDisplay[row].length) {
                treeDisplay[row][start + i] = String.valueOf(nodeValue.charAt(i));
            }
        }

        int nextWidth = width / 2;

        if (node.left != null) {
            int leftCenter = col + nextWidth / 2;
            for (int i = leftCenter + 1; i < center; i++) {
                if (i < treeDisplay[row + 1].length) {
                    treeDisplay[row + 1][i] = "_";
                }
            }
            if (row + 2 < treeDisplay.length && leftCenter < treeDisplay[row + 2].length) {
                treeDisplay[row + 2][leftCenter] = "/";
            }
            fillTreeDisplay(node.left, treeDisplay, row + 3, col, nextWidth);
        }

        if (node.right != null) {
            int rightCenter = col + width - nextWidth / 2;
            for (int i = center + 1; i < rightCenter; i++) {
                if (i < treeDisplay[row + 1].length) {
                    treeDisplay[row + 1][i] = "_";
                }
            }
            if (row + 2 < treeDisplay.length && rightCenter < treeDisplay[row + 2].length) {
                treeDisplay[row + 2][rightCenter] = "\\";
            }
            fillTreeDisplay(node.right, treeDisplay, row + 3, col + width / 2, nextWidth);
        }
    }

    /**
     * Compares two binary trees to check if they are identical.
     * @param root1 the root of the first binary tree.
     * @param root2 the root of the second binary tree.
     * @return true if both trees are identical, false otherwise.
     */
    public static boolean areTreesEqual(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.value == root2.value) &&
                areTreesEqual(root1.left, root2.left) &&
                areTreesEqual(root1.right, root2.right);
    }

    /**
     * Adds a value to all child nodes (except the root) in the tree.
     * @param value the value to be added to the child nodes.
     */
    public void addValueToChildNodes(int value) {
        addValueToChildNodesRecursive(root, value);
    }

     /**
     * Recursive helper function to add a value to all child nodes in the tree.
     * @param node the current node in the tree.
     * @param value the value to be added to the child nodes.
     */
    private void addValueToChildNodesRecursive(Node node, int value) {
        if (node == null) {
            return;
        }

        if (node != root) {
            node.value += value;
        }

        addValueToChildNodesRecursive(node.left, value);
        addValueToChildNodesRecursive(node.right, value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        BinarySearchTree bst1 = new BinarySearchTree();
        System.out.println(Constant.FIRST_BST );
        String[] values1 = scanner.nextLine().split(" ");
        for (String value : values1) {
            bst1.insert(Integer.parseInt(value));
        }
       
        BinarySearchTree bst2 = new BinarySearchTree();
        System.out.println(Constant.SECOND_BST);
        String[] values2 = scanner.nextLine().split(" ");
        for (String value : values2) {
            bst2.insert(Integer.parseInt(value));
        }
       
        boolean running = true;
        while (running) {
            System.out.println(Constant.CHOOSE_OPTION);
            System.out.print(Constant.SELECT_OPTION);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(Constant.FIRST_BST);
                    System.out.println(bst1);
                    break;
                case 2:
                    System.out.println(Constant.SECOND_BST);
                    System.out.println(bst2);
                    break;
                case 3:
                    System.out.print(Constant.REMOVE_FIRST_BST);
                    int remove1 = scanner.nextInt();
                    bst1.remove(remove1);
                    System.out.println(Constant.REMOVED_UPDATED_FIRST_BST);
                    System.out.println(bst1);
                    break;
                case 4:
                    System.out.print(Constant.REMOVE_SECOND_BST);
                    int remove2 = scanner.nextInt();
                    bst2.remove(remove2);
                    System.out.println(Constant.REMOVED_UPDATED_SECOND_BST);
                    System.out.println(bst2);
                    break;
                case 5:
                    boolean areEqual = areTreesEqual(bst1.root, bst2.root);
                    System.out.println(Constant.COMPARE_BST + areEqual);
                    break;

                case 6:
                    System.out.print(Constant.ADD_FIRST_BST);
                    int addValue1 = scanner.nextInt();
                    bst1.addValueToChildNodes(addValue1);
                    System.out.println(Constant.UPDATED_FIRST_BST);
                    System.out.println(bst1);
                    break;

                case 7:
                    System.out.print(Constant.ADD_SECOND_BST);
                    int addValue2 = scanner.nextInt();
                    bst2.addValueToChildNodes(addValue2);
                    System.out.println(Constant.UPDATED_SECOND_BST);
                    System.out.println(bst2);
                    break;
                    
                case 8:
                    running = false;
                    break;

                default:
                    System.out.println(Constant.INVALID_CHOICE);
            }
        }

        scanner.close();
    }
}
