/********************************************************************************************
 * 1. Brute-force
 *
 * Add up by bitwise
 * Time:  O(1)
 * Space: O(1)
 ********************************************************************************************/
class Solution {
    public int getSum(int a, int b) {

        int ans = 0;
        int p = 1;
        int addNext = 0;

        for (int i = 0; i < 32; i++)
        {
            int x = (a & p) >> i;
            int y = (b & p) >> i;
            int curr = x ^ y ^ (addNext);

            int one = 0;
            if (x == 1) one ++;
            if (y == 1) one ++;
            if (addNext == 1) one ++;

            addNext = (one >= 2) ? 1 : 0;

            ans += curr << i;
            p = p << 1;
        }
        return ans;
    }
}

/********************************************************************************************
 * 2. Simulation (More resonable)
 *
 * For Digit x and y
 *      Current Digit = x ^ y ^ addNext
 *      addNext = ((x & y == 1) || (x | y == 1 & addNext == 1)) ? 1 : 0
 *
 * Time:  O(1)
 * Space: O(1)
 ********************************************************************************************/
class Solution {
    public int getSum(int a, int b) {
        // ... make change to the solution above
            addNext = ((int)(x & y) == 1 ||( (int)(x | y) == 1 && addNext == 1)) ? 1 : 0;
       // ...
    }
}

class Solution {
    public int getSum(int a, int b) {

        // another solution that updates a and b in each iteration
        int result = 0;
        int addNext = 0;
        int i = 0;
        while (a != 0 || b != 0 || addNext > 0) {
            if (i >= 32) break;

            int sum = (a & 1) ^ (b & 1) ^ addNext;
            int abAND = (a & 1) & (b & 1);
            int abOR = (a & 1) | (b & 1);

            if (abAND == 1 || (abOR == 1 && addNext == 1))
                addNext = 1;
            else
                addNext = 0;

            result ^= (sum << i);
            a = a >>> 1;
            b = b >>> 1;
            ++i;
        }
        return result;
    }
}

/********************************************************************************************
 * 3. Recursive (More resonable)
 *
 * Reference:
 *      https://leetcode.com/problems/sum-of-two-integers/discuss/167728
 *
 * Time:  O(1)
 * Space: O(1)
 ********************************************************************************************/
class Solution {
    public int getSum(int a, int b)
    {
        int noCarryBits = a ^ b;  // where 1 ^ 0, 0 ^ 1, and 0 ^ 0
        int carryBits = a & b;    // where 1 ^ 1
        if (carryBits == 0) { // no carry created
            return noCarryBits;
        } else {
            return getSum(noCarryBits, carryBits << 1); // think about it
        }

    }
}