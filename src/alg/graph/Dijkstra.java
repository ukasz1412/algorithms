package alg.graph;

import java.util.*;

public class Dijkstra {

    static class EdgeToNode {
        int id; //Node ID
        int edge; //edge length

        EdgeToNode(int id, int edge) {
            this.id = id;
            this.edge = edge;
        }

        @Override
        public boolean equals(Object obj) {
            return (obj instanceof EdgeToNode) ? (id == ((EdgeToNode) obj).id) : super.equals(obj);
        }
    }

    public int[] run(Map<Integer, List<EdgeToNode>> graph, int start) {
        int[] d = new int[graph.size()];
        for (int i = 0; i < d.length; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        //Set distance to start node as 0
        d[start] = 0;
        //Create a priority queue passing integer comparator for edges (min edge is the priority)
        Queue<EdgeToNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.edge));
        queue.offer(new EdgeToNode(start, d[start]));
        while (!queue.isEmpty()) {
            EdgeToNode current = queue.poll();
            int nodeId = current.id;
            for (EdgeToNode e : graph.get(nodeId)) {
                if (d[e.id] > d[nodeId] + e.edge) {
                    d[e.id] = d[nodeId] + e.edge;
                    EdgeToNode tmp = new EdgeToNode(e.id, d[e.id]);
                    queue.remove(tmp);
                    queue.offer(tmp);
                }
            }
        }
        return d;
    }
}
