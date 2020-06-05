/********************************************************************************************
 * 1. Recursion
 *
 * Time:  O(N)
 * Space:
 *      O(N) - unbalanced tree, worst case.
 *      O(logN) - balanced tree, best case.
********************************************************************************************/
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return Check(root.left, root.right);
    }

    private boolean Check(TreeNode a, TreeNode b)
    {
        if (a == null && b == null)
            return true;

        if (a == null || b == null)
            return false;

        return (a.val == b.val && Check(a.left, b.right) && Check(a.right, b.left));
    }
}


/********************************************************************************************
 * 1. Iteration
 *
 * Time:  O(N)
 * Space: O(N)
 ********************************************************************************************/
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}