public class DP29_MaxPathSumAnyToAny {

    static int solve(Node root, int res) {
        if(root == null) {
            return 0;
        }

        int left = solve(root.left, res);
        int right = solve(root.right, res);

        int temp = Math.max(Math.max(left, right) + root.val, root.val);
        int ans = Math.max(res, left + right + root.val);
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

        int res = Integer.MIN_VALUE;
        solve(root, res);

        System.out.println(res);
    }
}
