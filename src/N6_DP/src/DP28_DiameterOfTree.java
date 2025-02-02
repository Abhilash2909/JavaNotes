// Diameter of a Binary Tree
// Maximum Path Sum | From any node to any node
// Maximum Path sum | From leaf node to leaf node

public class DP28_DiameterOfTree {
    static int solve(Node root, int res) {
        if(root == null) {
            return 0;
        }

        int left = solve(root.left, res);
        int right = solve(root.right, res);

        int temp = Math.max(left, right) + 1;
        int ans = Math.max(res, left + right + 1);
        res = Math.max(res, ans);

        return temp;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(8);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(9);

        int res = solve(root, Integer.MIN_VALUE);

        System.out.println(res);
    }
}
