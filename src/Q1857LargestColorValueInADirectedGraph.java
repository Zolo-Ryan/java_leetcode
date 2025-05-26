import java.util.ArrayList;
import java.util.List;

public class Q1857LargestColorValueInADirectedGraph {
    private static final int INF = Integer.MAX_VALUE;
    public int largestPathValue(String colors, int[][] edges) {
        int v = colors.length();
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i< v;i++)
            adjList.add(new ArrayList<>());
        for (int[] edge : edges) adjList.get(edge[0]).add(edge[1]);

        int[][] count = new int[v][26]; // no of j-th color seen at i-th node
        int[] vis = new int[v]; // 0 -> unvisited, 1-> visiting, 2-> visited
        int ans = 0;

        for(int i = 0; i< v && ans != INF;i++)
            ans = Math.max(ans,dfs(i,colors,adjList,count,vis));
        return ans == INF ? -1 : ans;
    }
    private int dfs(int i,String colors,List<List<Integer>> adjList,int[][] count,int[] vis){
        if(vis[i] == 1) return INF;
        if(vis[i] == 2) return count[i][colors.charAt(i) - 'a'];
        vis[i] = 1;
        for(int nxt: adjList.get(i)){
            int res = dfs(nxt,colors,adjList,count,vis);
            if(res == INF)
                return INF;
            for(int c = 0; c < 26; c++)
                count[i][c] = Math.max(count[i][c],count[nxt][c]);
        }
        vis[i] = 2;
        count[i][colors.charAt(i) - 'a']++;
        return count[i][colors.charAt(i) - 'a'];
    }
}
