import java.util.ArrayList;
import java.util.Arrays;

public class Q2359FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dist1[node1] = 0;
        dist2[node2] = 0;

        boolean[] visit1 = new boolean[n];
        boolean[] visit2 = new boolean[n];

        dfs(node1,edges,dist1,visit1);
        dfs(node2,edges,dist2,visit2);

        int minDistNode = -1, minDistTillNow = Integer.MAX_VALUE;
        for(int currNode = 0; currNode < n; currNode++){
            if(minDistTillNow > Math.max(dist1[currNode],dist2[currNode])){
                minDistNode = currNode;
                minDistTillNow = Math.max(dist1[currNode],dist2[currNode]);
            }
        }
        return minDistNode;
    }
    public ArrayList<Integer> pathFrom(int[] edges,int u){
        boolean[] visited = new boolean[edges.length];
        ArrayList<Integer> path = new ArrayList<>();
        int next = u;
        while(next != -1 && !visited[next]){
            path.add(next);
            visited[next] = true;
            next = edges[next];
        }
        return path;
    }
    public void dfs(int node,int[] edges,int[] dist,boolean[] visit){
        visit[node] = true;
        int neighbour = edges[node];
        if(neighbour != -1 && !visit[neighbour]){
            dist[neighbour] = 1 + dist[node];
            dfs(neighbour,edges,dist,visit);
        }
    }
}
