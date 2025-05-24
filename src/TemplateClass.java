import java.util.*;

public class TemplateClass {
    private class Node{
        int v;
        int w;
        Node(int v,int w){
            this.v = v;
            this.w = w;
        }
    }
    private class Graph{
        private int numOfVertices = 0;
        private HashMap<Integer, List<Node>> adjList = null;
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
        public void addEdges(int[][] edges, int srcI, int destI, int wtI){
            if(edges.length == 0) return;
            if(edges[0].length > 2){
                for(int[] edge: edges) this.addEdge(edge[srcI],edge[destI],edge[wtI]);
            }else{
                for(int[] edge: edges) this.addEdge(edge[srcI],edge[destI],0);
            }
        }
        public void addEdges(int[][] edges){
            this.addEdges(edges,0,1,2);
        }
        public int[] simpleDijkstra(int src){
            if(numOfVertices == 0) return null;
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

            int[] dist = new int[this.numOfVertices];
            Arrays.fill(dist,Integer.MAX_VALUE);

            dist[src] = 0;
            Node node = new Node(src,0);
            pq.offer(node);

            while(!pq.isEmpty()){
                Node curr = pq.poll();
                int u = curr.v;
                int wt = curr.w;
                for(Node neighbour: this.adjList.get(u)){
                    int v = neighbour.v;
                    int w = neighbour.w;
                    if(dist[v] > dist[u] + w){
                        dist[v] = dist[u] + w;
                        Node temp = new Node(v,dist[v]);
                        pq.offer(temp);
                    }
                }
            }
            return dist;
        }
    }
}
