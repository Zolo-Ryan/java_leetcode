import java.util.*;

public class Q3372MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {
    private static final int INF = Integer.MAX_VALUE;
    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> graph1 = returnAdjList(edges1);
        List<List<Integer>> graph2 = returnAdjList(edges2);
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] ans1 = solve(n,graph1,k);
        int[] ans2 = solve(m,graph2,k-1);
        printArray(ans1);
        printArray(ans2);
        int max = ans2[0];
        for(int i = 1;i<ans2.length;i++) max = Math.max(max,ans2[i]);

        for(int i = 0;i<ans1.length;i++) ans1[i] += max;
        return ans1;
    }
    public static void printArray(int[] arr){
        System.out.println("\n=================\n");
        for(int a: arr) System.out.printf("%d ",a);
        System.out.println("\n=================\n");
    }
    public static int[] solve(int n,List<List<Integer>> adjList,int k){
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        if(k < 0) return ans;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            ans[i] = 1 + count(i,adjList,visited,k);
            Arrays.fill(visited,false);
        }
        return ans;
    }
    public static int count(int ele,List<List<Integer>> adjList,boolean[] visited,int k){
        k--;
        if(k < 0 || visited[ele]) return 0;
        int count = 0;
        List<Integer> adj = adjList.get(ele);
        visited[ele] = true;
        for(int v: adj){
            if(!visited[v]){
                count += 1 + count(v,adjList,visited,k);
            }
        }
        return count;
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
    public static void main(String[] args){
        int[][] edges1 = new int[][]{{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = new int[][]{{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int[][] a = new int[][]{{0,1},{0,2},{0,3},{0,4}};
        int[][] b = new int[][]{{0,1},{1,2},{2,3}};
        int[][] c = new int[][]{{0,1}};
        int[][] d = new int[][]{{0,1}};
        int k = 2;
        int[] ans = maxTargetNodes(c,d,0);
        for(int i: ans) System.out.printf("%d ",i);
        System.out.println();
    }
}
