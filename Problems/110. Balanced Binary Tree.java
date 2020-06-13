/********************************************************************************************
 * 1. Recursion
 *
 * Worst Case: Balanced Tree: T(n) = 2T(n/2) + O(1)
 * Using Master Theroem: a = 2, b = 2, c = log_a{b} = 1, f(n) = 1
 *                       f(n) = n^c, thus O(NlogN)
 *
 * Time:  O(NlogN)
 * Space: O(N)
********************************************************************************************/
class Solution {
    boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        check(root);
        return isBalance;
    }

    private int check(TreeNode p)
    {
        if (!isBalance)
            return -1;

        if (p.left == null && p.right == null)
            return 0;

        int left = (p.left == null) ? 0 : (check(p.left) + 1);
        int right = (p.right == null) ? 0 : (check(p.right) + 1);

        if (Math.abs(right - left) > 1)
        {
            isBalance = false;
            return -1;
        }
        return Math.max(left,right);
    }
}