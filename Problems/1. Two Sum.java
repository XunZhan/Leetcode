/********************************************************************************************
 * 1. HashMap
 *
 * Time:  O(N)
 * Space: O(N)
********************************************************************************************/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int []ans = new int[2];
        Map <Integer,Integer> map = new HashMap<>(); // key=number value  value =number index

        for (int i = 0; i<n; i++)
        {
            if (map.containsKey(target - nums[i]))
            {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }

        return ans;
    }
}


