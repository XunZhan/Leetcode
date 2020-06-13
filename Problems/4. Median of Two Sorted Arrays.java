/********************************************************************************************
 * 1. Recursion
 *
 * Time:  O(log(m+n))
 * Space: O()
********************************************************************************************/
class Solution {
    int l1, l2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        l1 = nums1.length;
        l2 = nums2.length;

        if ((l1+l2) % 2 == 1)
            return findKthMin(nums1, nums2, 0, 0, (l1+l2+1)/2);

        return (findKthMin(nums1, nums2, 0, 0, (l1+l2+1)/2) + findKthMin(nums1, nums2, 0, 0, (l1+l2+2)/2)) / (double)2;

    }

    private int findKthMin(int[] a, int[] b, int start1, int start2, int k)
    {
        if (start1 >= l1) return b[start2 + k - 1];
        if (start2 >= l2) return a[start1 + k - 1];

        if (k == 1)
            return Math.min(a[start1], b[start2]);

        int mid1 = (start1 + k/2 -1 < l1) ? a[start1 + k/2 -1] : Integer.MAX_VALUE;
        int mid2 = (start2 + k/2 -1 < l2) ? b[start2 + k/2 -1] : Integer.MAX_VALUE;

        if (mid1 < mid2)
            return findKthMin(a,b,start1 + k/2, start2, k - k/2);
        return findKthMin(a,b,start1, start2 + k/2, k - k/2);
    }
}