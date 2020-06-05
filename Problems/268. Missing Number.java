/********************************************************************************************
 * 1. Brute-force
 *
 * Time:  O(N^2)
 * Space: O(N)
********************************************************************************************/
class Solution {
    public int missingNumber(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i< nums.length; i++)
        {
            set.add(nums[i]);
        }

        for (int i = 0; i<= nums.length; i++)
        {
            if (!set.contains(i))
                return i;
        }

        throw new IllegalArgumentException();
    }
}

/********************************************************************************************
2. Bitwise
 *
 * Given a ^ b ^ b = a. So for 1^1 ^ 2^2 ^ ... ^ x^x ... ^ n^n = 0, if x is missing, we have:
 * 1^1 ^ 2^2 ^ ... ^ x^(x+1) ... ^ (n-1)^n
 * = x^(x+1) ... ^ (n-1)^n
 * = (x+1)^(x+1) ^ (x+2)^(x+2) ... (n-1)^(n-1) ^ x^n = x ^ n.
 * If we do n ^ (x ^ n), we then get n ^ (x ^ n) = x, which is the number we are looking for.
 *
 * Time: O(N)
 * Space O(1)
 ********************************************************************************************/
class Solution {
    public double myPow(double x, int n) {

        long N = n;
        if (N < 0)
        {
            x = 1 / x;
            N = -N;
        }

        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == 2) return x*x;

        if (n % 2 == 0)
            return myPow(myPow(x, (int)(N/2)),2);

        return x * myPow(myPow(x, (int)(N/2)),2);

    }
}

/********************************************************************************************
 3. Math (Gauss’ Formula)
 *
 * Sum of 0 to n = n*(n+1)/2;
 *
 * Time: O(N)
 * Space O(1)
 *
 * In discussion, people are arguing about overflow?
 * If nums[] = {Integer.MAX_VALUE, Integer.Max_VALUE - 1, ... , 1, 0}
 ********************************************************************************************/
class Solution {
    public int missingNumber(int[] nums) {

        int ans = 0;

        for (int i = 0; i< nums.length; i++)
        {
            ans = ans + nums[i] - i;
        }

        return - (ans - nums.length);
    }
}