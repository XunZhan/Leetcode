/********************************************************************************************
 * 1. MonoQueue
 *
 * MonoQueue:
 *      a data structure the elements from the front to
 *      the end is strictly either increasing or decreasing.
 *
 * monoq:
 *      stores the start index x that for x0 = monoq[0], x1 = monoq[1] .... We have P[x0] < P[x1] < ...
 *
 * In the for loop, y is for finding the end index. The first while loop: Remove P[index] that is greater
 * than P[y] will keep the queue monotonic. The second while loop : Get the qualified P[index] and remove
 * them. Because we dont need to use them in next iteration.
 *
 * Time:  O(N)
 * Space: O(N)
********************************************************************************************/
class Solution {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] P = new long[N+1];
        for (int i = 0; i < N; ++i)
            P[i+1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
}