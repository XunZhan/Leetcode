/********************************************************************************************
 * 1. Extend Palindrome Center
 *
 * Time:  O(N^2)
 * Space: O(1)
 ********************************************************************************************/
class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        if (n<=0)
            return 0;

        int count = 0;

        for (int i = 0; i<n; i++)
        {
            int left = i, right = i;

            // size = odd
            while (left>=0 && right<=n-1 && (s.charAt(left) == s.charAt(right)))
            {
                left--;
                right++;
                count++;
            }

            // size = even
            left = i; right = i+1;
            while (left>=0 && right<=n-1 && (s.charAt(left) == s.charAt(right)))
            {
                left--;
                right++;
                count++;
            }

        }

        return count;
    }
}

/********************************************************************************************
 * 2. DP
 *
 * isPalindrome[i][j]: if subString(i,j) is palindrome
 *
 * Time:  O(N^2)
 * Space: O(N^2)
 ********************************************************************************************/
class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        if (n<=0)
            return 0;

        boolean[][] isPalindrome = new boolean[n][n];
        int count = 0;

        // window size 1
        for (int i = 0; i < n; i++)
        {
            isPalindrome[i][i] = true;
            count++;
        }

        // window size 2
        for (int i = 0; i < n-1; i++)
        {
            if (s.charAt(i) == s.charAt(i+1))
            {
                isPalindrome[i][i+1] = true;
                count++;
            }
            else
                isPalindrome[i][i+1] = false;
        }

        // window size >= 3
        for (int size = 3; size <= n; size++)
        {
            for (int i = 0; i < n-(size-1);i++)
            {
                int j = i + size - 1;
                if (isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j))
                {
                    isPalindrome[i][j] = true;
                    count ++;
                }
                else
                    isPalindrome[i][j] = false;

            }
        }

        return count;
    }
}