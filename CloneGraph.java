// Time Complexity: O(V + E) We iterate through each vertex and edges only once
// Space complexity O(V)
import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CloneGraph {
    public Node cloneGraph(Node node) {
        if( node == null) return null;

        // map to store original node to cloned node mapping
        Map<Node, Node> visited = new HashMap<>();

        // clone the root node
        Node clone = new Node(node.val);
        visited.put(node, clone); // puting the clone as value in the map for original node

        // use a queue for BFS
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while( ! queue.isEmpty()){
            Node current = queue.poll();

            // iterate through all the neighbours of the current node
            for( Node neighbour: current.neighbors){
                if(! visited.containsKey(neighbour)){
                    // clone the neighbour if it hasn;'t been cloned
                    Node neighbourClone = new Node(neighbour.val);
                    visited.put(neighbour,neighbourClone);
                    queue.add(neighbour); // add the original neighbour to the queue
                }

                // link the clone of the current bode to the clone of neighbour
                visited.get(current).neighbors.add(visited.get(neighbour));
            }
        }
        return clone;
    }
}