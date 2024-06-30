package Backtracking.src;
import java.util.Scanner;

public class pathSum1 {
    static class Node {
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean solve(Node root, int t, int sum) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == t) {
                return true;
            }
        }
        return solve(root.left, t, sum) || solve(root.right, t, sum);
    }

    public boolean hasPathSum(Node root, int targetSum) {
        return solve(root, targetSum, 0);
    }

    public static Node createTree(Scanner scanner) {
        String input = scanner.next();
        if (input.equals("null")) {
            return null;
        }
        int val = Integer.parseInt(input);
        Node node = new Node(val);
        node.left = createTree(scanner);
        node.right = createTree(scanner);
        return node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = createTree(scanner);
        int targetSum = scanner.nextInt();
        pathSum1 pathSum1 = new pathSum1();
        boolean hasPath = pathSum1.hasPathSum(root, targetSum);
        System.out.println(hasPath);
    }
}
