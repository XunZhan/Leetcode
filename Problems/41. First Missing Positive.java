/********************************************************************************************
 * 1. Simulation of Hash
 *
 * Reference:
 *      https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
 *
 * 1) Numbers greater then n can be ignored because the missing integer must be in the range 1..n+1
 * 2) If each cell in the array were to contain positive integers only, we can use the negative of the stored number
 * as a flag to mark something (in this case the flag indicates this index was found in some cell of the array)
 *
 * Time:  O(N)
 * Space: O(1)
********************************************************************************************/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;


        // 1. mark numbers (num <= 0) and (num > n) with a special marker number (n+1)
        for (int i = 0; i<n; i++)
        {
            if (nums[i] <= 0 || nums[i] > n)
                nums[i] = n+1;
        }
        // note: all numbers are in range [1, n+1] after this step

        // 2. for each i, nums[i] < 0 means the number (i+1) exists in the array
        //    otherwise, not exist.
        for (int i = 0; i<n; i++)
        {
            int idx = Math.abs(nums[i])-1;
            if (idx >= n)
                continue;

            // note: prevent negative operation doing several times to make it positive
            if (nums[idx] > 0)
                nums[idx] *= -1;

        }

        // 3. find the first nums[i] that is positive
        for (int i = 0; i<n; i++)
        {
            if (nums[i] > 0)
                return i+1;
        }

        return (n+1);
    }
}
