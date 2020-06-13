/********************************************************************************************
 * 1. Brute-Force !!!WRONG!!! Time Exceeded Limit
 *
 * Explanation HERE
 *
 * Time:  O()
 * Space: O()
********************************************************************************************/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<List<Integer>> edge = new LinkedList<>();
        List<Integer> ans = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] height = new int[n];
        for (int i = 0; i<n; i++)
        {
            edge.add(new LinkedList<>());
        }


        for (int i = 0; i<edges.length; i++)
        {
            edge.get(edges[i][0]).add(edges[i][1]);
            edge.get(edges[i][1]).add(edges[i][0]);
        }

        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i<n; i++)
        {
            height[i] = 0;
            // init visited[]
            for (int j = 0; j<n; j++)
            {
                visited[j] = false;
            }

            // find Height for each root
            Queue<Integer> queue = new LinkedList<>();
            visited[i] = true;
            queue.add(i);
            while (!queue.isEmpty())
            {
                height[i]++;
                int size = queue.size();
                for (int j = 0; j<size; j++)
                {
                    int curNode = queue.poll();
                    // add its neighbours to queue
                    for (int k = 0; k<edge.get(curNode).size(); k++)
                    {
                        int neighbor = edge.get(curNode).get(k);
                        if (visited[neighbor]) continue;
                        queue.add(neighbor);
                    }
                    visited[curNode] = true;
                }
            }

            if (height[i] < minHeight)
                minHeight = height[i];
        }

        for (int i = 0; i<n; i++)
        {
            if (height[i] == minHeight)
                ans.add(i);
        }

        return ans;
    }
}