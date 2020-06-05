/********************************************************************************************
 * 1. Brute-force
 * !!! WRONG ANSWER !!! on leetcode
 *
 * When input is (1.00000, 2147483647) -> Time Limit Exceed
 * Time:  O(N)
 * Space: O(1)
********************************************************************************************/
class Solution {
    public double myPow(double x, int n) {

        long N = n;
        if (N < 0)
        {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;

        for (int i = 0; i< N; i++)
            ans = ans * x;

        return ans;
    }
}

/********************************************************************************************
2. Recursion
 *
 * Time: O(logN)
 * Space O(logN)
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
 3. Bitwise
 * !!! WRONG ANSWER !!! on leetcode
 *
 * x^(52) = x^(0011 0100) = x^(0010 0000) * x^(0001 0000) * x^(0000 0100)
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

        int p = 1;
        double ans = 1, curr = x;

        while (p <= N)
        {
            if ((p & N) > 0)
            {
                ans *= curr;
            }
            curr *= curr;
            p = p << 1;
        }

        return ans;
    }
}