package Backtracking.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pathSum2 {

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

    int height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;

        return Math.max(leftHeight, rightHeight);
    }

    public void findAllPaths(Node root, List<List<Integer>> list, int[] arr, int index, int targetSum) {
        if (root == null)
            return;

        arr[index] = root.val;
        index++;

        if (root.left == null && root.right == null && targetSum == root.val) {
            var path = new ArrayList<Integer>();

            for (int i = 0; i < index; i++)
                path.add(arr[i]);

            list.add(path);
            return;
        }

        findAllPaths(root.left, list, arr, index, targetSum - root.val);
        findAllPaths(root.right, list, arr, index, targetSum - root.val);
    }

    public List<List<Integer>> pathSum(Node root, int targetSum) {
        int treeHeight = height(root);
        int[] arr = new int[treeHeight];
        List<List<Integer>> list = new ArrayList<>();

        findAllPaths(root, list, arr, 0, targetSum);

        return list;
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

        pathSum2 pathSum2 = new pathSum2();
        List<List<Integer>> paths = pathSum2.pathSum(root, targetSum);

        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
//class Solution {
//    List<List<Integer>> ans = new ArrayList<>();
//    public void solve(Node root, int t, int sum, ArrayList<Integer> li) {
//        if(root == null) {
//            return;
//        }
//        sum += root.val;
//        li.add(root.val);
//        if(root.left == null && root.right == null) {
//            if(sum == t) {
//                ans.add(new ArrayList<>(li));
//                li.remove(li.size()-1);
//                return;
//            }
//        }
//        solve(root.left, t, sum, li);
//        solve(root.right, t, sum, li);
//        li.remove(li.size()-1);
//        return;
//    }
//    public List<List<Integer>> pathSum(Node root, int targetSum) {
//        if(root == null) {
//            return new ArrayList<>();
//        }
//        solve(root, targetSum, 0, new ArrayList<>());
//        return ans;
//    }
//}