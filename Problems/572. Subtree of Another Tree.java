/********************************************************************************************
 * 1. String Comparsion
 *
 * Use String to represent a tree.
 *
 * Time:  O(m^2 + n^2 + m*n)
 * Space: O()
********************************************************************************************/
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (t == null)
            return true;
        if (s == null)
            return false;

        String a = PreOrder(s);
        String b = PreOrder(t);
        return (a.indexOf(b) >= 0);
    }

    String PreOrder (TreeNode a)
    {
        if (a == null)
            return "null";

        // Note: the construction of the string is VERY important
        // Previously, I use:
        //         return  String.valueOf(a.val) + "#" + PreOrder(a.left) + "#" + PreOrder(a.right);
        // this will result in WRONG answers if input is [12], [2]
        return "#" + String.valueOf(a.val) + "#" + PreOrder(a.left) + "#" + PreOrder(a.right);
    }
}

