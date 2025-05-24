import java.util.*;

public class DijkstraAlgorithm {
    public class Node{
        int v;
        int w;
        public Node(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    private class Graph{
        private int numOfVertices;
        private HashMap<Integer, List<Node>> adjList;
        public Graph(int numOfVertices){
            this.numOfVertices = numOfVertices;
            this.adjList = new HashMap<>();
            for(int i = 0 ; i < numOfVertices;i++)
                adjList.put(i,new LinkedList<Node>());
        }
        public void addEdge(int src,int dest,int wt){
            Node node = new Node(dest,wt);
            this.adjList.get(src).add(node);
        }
        public List<Node> getNeighbors(int vertex){
            return this.adjList.get(vertex);
        }
        public int getNumOfVertices(){return this.numOfVertices;}
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        Graph graph = new Graph(V);
        for (int[] edge : edges) graph.addEdge(edge[0], edge[1], edge[2]);
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));
        ArrayList<Integer> start = new ArrayList<Integer>();
        start.add(0);
        start.add(src);
        pq.offer(start);

        while(!pq.isEmpty()){
            ArrayList<Integer> curr = pq.poll();
            int d = curr.get(0);
            int u = curr.get(1);
            for(Node node :graph.adjList.get(u)){
                int v = node.v;
                int w = node.w;
                if(dist[v] > dist[u] + w){
                    dist[v] = dist[u] + w;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(dist[v]);
                    temp.add(v);
                    pq.offer(temp);
                }
            }
        }
        return dist;
    }


}
