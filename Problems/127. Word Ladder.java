/********************************************************************************************
 * 1. BFS
 *
 * BFS:
 *      Use a HashSet to store the wordList in case duplication.
 *      In each level, store all the results that could be transformed from all the words in
 *      the previous level. Also, delete the results from HashSet. Repeat until find.
 *
 * Time:  O()
 * Space: O()
********************************************************************************************/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 0;

        while (!queue.isEmpty())
        {
            int n = queue.size();
            step++;
            for (int i = 0; i<n; i++)
            {
                char[] prev = queue.poll().toCharArray();
                for (int j = 0; j<prev.length; j++)
                {
                    char org = prev[j];
                    for (char c = 'a'; c<='z'; c++)
                    {
                        prev[j] = c;
                        String tmp = String.valueOf(prev);
                        if (set.contains(tmp))
                        {
                            if (tmp.equals(endWord)) return step+1;
                            set.remove(tmp);
                            queue.add(tmp);
                        }
                    }
                    prev[j] = org;
                }
            }
        }
        return 0;

    }
}

/********************************************************************************************
 * 1. BFS - Acceleration
 *
 * Bi-direction Search:
 *      beginWord = "hit",
 *      endWord = "cog",
 *      wordList = ["hot","dot","dog","lot","log","cog"]
 *
 *      When the queue size of forward direction is greater than backward, we will try to
 *      extend the beackward queue.
 *
 *                 Forward                                    Backward
 *      "hit" -> "hot" -> "dot", "lot"                         "cog"
 *      "hit" -> "hot" -> "dot", "lot"                  "log", "dog" <- "cog"
 *      "hit" -> "hot" -> "dot", "lot" -> "log"    Stop, can find "log" in backward queue
 *
 * Time:  O()
 * Space: O()
 ********************************************************************************************/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        LinkedList<Set<String>> set = new LinkedList<>();
        set.add(new HashSet<>(wordList));
        set.add(new HashSet<>(wordList));

        LinkedList<Queue<String>> queue = new LinkedList<>();
        queue.add(new LinkedList<>());
        queue.add(new LinkedList<>());
        queue.get(0).add(beginWord);
        queue.get(1).add(endWord);

        int[] step = new int[2];
        step[0] = 0; step[1] = 0;

        while (!queue.get(0).isEmpty() && !queue.get(1).isEmpty())
        {
            int[] len = new int[2];
            len[0] = queue.get(0).size(); len[1] = queue.get(1).size();

            int extend, search;
            if (len[0] <= len[1])
            { extend = 0; search = 1;}
            else
            { extend = 1; search = 0;}

            step[extend]++;
            for (int i = 0; i<len[extend]; i++)
            {
                String str = queue.get(extend).poll();
                if (queue.get(search).contains(str))
                    return step[extend] + step[search];

                char[] cur = str.toCharArray();
                for (int j = 0; j<str.length(); j++)
                {
                    char org = cur[j];
                    for (char c = 'a'; c<='z'; c++)
                    {
                        if (c == org) continue;
                        cur[j] = c;
                        String newStr = String.valueOf(cur);
                        if (set.get(extend).contains(newStr))
                        {
                            queue.get(extend).add(newStr);
                            set.get(extend).remove(newStr);
                        }
                    }
                    cur[j] = org;
                }
            }
        }
        return 0;
    }
}
