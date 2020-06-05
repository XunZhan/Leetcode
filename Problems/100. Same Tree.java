/********************************************************************************************
 * 1. Recursion
 *
 * Time:  O(N)
 * Space: O(logN)
********************************************************************************************/


/********************************************************************************************
2. Iteration - DFS
 *
 * Time: O(N)
 * Space O(logN)
 ********************************************************************************************/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        Stack<TreeNode> stackp = new Stack<>();
        Stack<TreeNode> stackq = new Stack<>();

        stackp.push(p);
        stackq.push(q);

        // DFS
        while (!stackp.isEmpty()  && !stackq.isEmpty())
        {

            TreeNode pp = stackp.pop();
            TreeNode qq = stackq.pop();

            if (pp.val != qq.val) return false;

            if (pp.right != null)
                stackp.push(pp.right);
            if (qq.right != null)
                stackq.push(qq.right);
            if (stackp.size() != stackq.size())
                return false;

            if (pp.left != null)
                stackp.push(pp.left);
            if (qq.left != null)
                stackq.push(qq.left);
            if (stackp.size() != stackq.size())
                return false;

        }

        return stackp.size() == stackq.size();
    }
}


/********************************************************************************************
 3. Iteration - BFS
 *
 * Time: O(N)
 * Space O(logN)
 ********************************************************************************************/
