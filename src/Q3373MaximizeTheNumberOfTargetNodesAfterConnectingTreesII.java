import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Alternatively color each graphs as white or black
* Find the max of white/black nodes from graph2
* set ans1[i] = count of whites in ans1[i] if ans1[i] was white
* add max to ans1[i]
* return ans1[i]*/

/*
* other optimization is to keep the count of white and black nodes only in both the graphs*/

public class Q3373MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {
    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        List<List<Integer>> graph1 = returnAdjList(edges1);
        List<List<Integer>> graph2 = returnAdjList(edges2);
        System.out.println(graph1);
        System.out.println(graph2);
        int n = graph1.size();
        int m = graph2.size();

        int[] ans1 = solve(n,graph1);
        int[] ans2 = solve(m,graph2);
        int white = 0;
        int black = 0;
        for(int i: ans2){
            if(i == 0) black++;
            else white++;
        }
        int max = Math.max(white,black);
        white = 0;
        black = 0;
        for(int i: ans1){
            if(i == 0) black++;
            else white++;
        }
        for(int i = 0;i<n;i++){
            if(ans1[i] == 0) ans1[i] = black + max;
            else ans1[i] = white + max;
        }
        return ans1;
    }
    public static int[] solve(int v,List<List<Integer>> graph){
        int[] ans = new int[v];
        Arrays.fill(ans,-1); // -1 not coloured, 1 white, 0 black
        for(int i = 0; i < v;i++){
            if(ans[i] == -1)
                dfs_color(i,0,graph,ans);
        }
        return ans;
    }
    public static void dfs_color(int u,int u_color,List<List<Integer>> graph,int[] ans){
        if(ans[u] != -1) return;
        ans[u] = u_color;
        List<Integer> adjList = graph.get(u);
        for(int v: adjList){
            if(ans[v] == -1)
                dfs_color(v,(u_color+1) % 2,graph,ans);
        }
    }
    public static List<List<Integer>> returnAdjList(int[][] edges){
        List<List<Integer>> adjList = new ArrayList<>();
        int n = edges.length+1;
        for(int i = 0; i< n;i++)
            adjList.add(new ArrayList<>());
        for(int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return adjList;
    }

    public static void main(String[] args) {
        int[][] edges1 = new int[][]{{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = new int[][]{{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int[][] a = new int[][]{{0,1},{0,2},{0,3},{0,4}};
        int[][] b = new int[][]{{0,1},{1,2},{2,3}};
        int[][] c = new int[][]{{0,1}};
        int[][] d = new int[][]{{0,1}};
        int[] ans = maxTargetNodes(edges1,edges2);
        for(int i: ans) System.out.printf("%d ",i);
        System.out.println();
    }
}
