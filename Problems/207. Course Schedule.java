/********************************************************************************************
 * 1. BFS
 *
 * Topological Sort
 *
 * Time:  O()
 * Space: O()
********************************************************************************************/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int preNum = prerequisites.length;

        ArrayList[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        int count = 0;

        for (int i = 0; i<numCourses; i++)
        {
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<preNum; i++)
        {
            indegree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        Queue <Integer> queue = new LinkedList<>();
        for(int i = 0; i<numCourses; i++)
        {
            if (indegree[i] == 0)
            {
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty())
        {
            int cur = queue.poll();
            for (int j = 0; j<(int)graph[cur].size(); j++)
            {
                int next = (int)graph[cur].get(j);
                indegree[next] --;
                if (indegree[next] == 0)
                {
                    queue.add(next);
                    count ++;
                }
            }
        }


        return (count == numCourses);
    }
}

/********************************************************************************************
 * 1. DFS
 *
 * In dfs, need to go back to original status after the recursion.
 *
 * Time:  O()
 * Space: O()
 ********************************************************************************************/
class Solution {
    ArrayList[] graph;
    boolean[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int preNum = prerequisites.length;

        // init graph and visited
        graph = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i<numCourses; i++)
        {
            visited[i] = false;
            graph[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<preNum; i++)
        {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        // run dfs
        for(int i = 0; i<numCourses; i++)
        {
            if (!visited[i])
            {
                if (!dfs(i))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int node)
    {
        int size = graph[node].size();

        if (visited[node]) return false;
        visited[node] = true;

        for (int i = 0; i<size; i++)
        {
            if (!dfs((int)graph[node].get(i)))
                return false;
        }

        // go back to original status
        visited[node] = false;
        return true;
    }
}