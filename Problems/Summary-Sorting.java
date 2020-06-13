/********************************************************************************************
 *                                 Sorting
 * Problem: 75, 912
 *
 * Reference:
 *      https://blog.csdn.net/yyywww666/article/details/70482636
 *      https://en.wikipedia.org/wiki/Comparison_sort
 *
 ********************************************************************************************/

/********************************************************************************************
 * 1. Bubble Sort
 *
 * Compare adjacent elements  and swap them if they are in wrong order.
 * Find the largest number and put it at the tail, then find the second largest number and put
 * it before the largest number ... Iterate N-1 times and we will get the right order.
 *
 * Time:
 *      Best - O(N)  [0 swap + O(N) compare]
 *      Worst - O(N^2) [O(N^2) swap + O(N^2) compare]
 * Space: O(N)
 ********************************************************************************************/

// P75 Bubble Sort
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 0; i<n-1; i++)
        {
            for (int j = 1; j<n-i; j++)
            {
                if (nums[j] < nums[j-1])
                {
                    int tmp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] =  tmp;
                }
            }
        }
    }
}


/********************************************************************************************
 * 2. Selection Sort
 *
 * Find the smallest number in remaining unsorted array. Then swap it with the first unsorted
 * number. Iterate N-1 times.
 *
 * Time:
 *      Best - O(N^2)
 *      Worst- O(N^2)
 * Space: O(N)
********************************************************************************************/
// P75 Selection Sort
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for (int i = 0; i<n-1; i++)
        {
            int minIdx = i;
            for (int j = i+1; j<n; j++)
            {
                if (nums[j] < nums[minIdx])
                    minIdx = j;
            }

            int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
    }
}

/********************************************************************************************
 * 3. Merge Sort
 *
 * Divide the unsorted list into n sublists, each containing one element.
 * Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining
 *
 * Time:
 *      Best - O(NlogN)
 *      Worst- O(NlogN)
 * Space: O(N)
 ********************************************************************************************/
// P912 Merge Sort
class Solution {
    public int[] sortArray(int[] nums) {

        return MergeSort(nums, 0, nums.length-1);
    }

    private int[] MergeSort(int[] num, int start, int end)
    {
        int n = end-start+1;
        if (n<2)
            return new int[] {num[start]};

        int mid = (start+end)/2;
        int[] left = MergeSort(num, start, mid);
        int[] right = MergeSort(num, mid+1, end);

        return Merge(left, right);

    }

    private int[] Merge(int[] a, int[] b)
    {
        int len_a = a.length, len_b = b.length;
        int idx_a = 0, idx_b = 0, idx = 0;
        int[] ans = new int[len_a+len_b];

        while (idx_a < len_a || idx_b < len_b)
        {
            if (idx_b >= len_b || (idx_a < len_a && a[idx_a] < b[idx_b]))
            {
                ans[idx] = a[idx_a];
                idx++;
                idx_a++;
            }
            else
            {
                ans[idx] = b[idx_b];
                idx++;
                idx_b++;
            }
        }
        return ans;
    }
}




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);

        int level =  0;

        while (!queue.isEmpty() || !stack.isEmpty())
        {
            level ++;
            List<Integer> tmp = new LinkedList<>();
            if (level % 2 != 0)
            {
                int n = queue.size();
                for (int i=0; i<n; i++)
                {
                    TreeNode p  = queue.poll();
                    tmp.add(p.val);
                    if(p.left != null)
                        stack.push(p.left);
                    if (p.right!= null)
                        stack.push(p.right);
                }

            }
            else
            {
                int n = stack.size();
                for (int i=0; i<n; i++)
                {
                    TreeNode p = stack.pop();
                    tmp.add(p.val);
                    if(p.left != null)
                        queue.add(p.left);
                    if (p.right!= null)
                        queue.add(p.right);
                }
            }
            list.add(tmp);
        }

        return list;

    }
}