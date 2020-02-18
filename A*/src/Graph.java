import java.util.HashMap;
import java.util.HashSet;

/**
 * @author domsangio
 * Class that contains a graph implementation. This is a directed graph,
 * but unweighted (To add weighted feature, add in an Edge class)
 */
public class Graph {
	
	private HashMap<Integer, Node> nodes;
	private HashMap<Node, HashSet<Node>> graph;
	private int size;
	
	public Graph () {
		graph = new HashMap<>();
		nodes = new HashMap<>();
		size = 0;
	}
	
	public Graph(int size) {
		graph = new HashMap<Node, HashSet<Node>>();
		nodes = new HashMap<Integer, Node>();
		this.size = size;
		
		for(int i = 0; i < size; i++) {
			Node insert = new Node(i);
			nodes.put(i, insert);
			graph.put(insert, new HashSet<>());
		}
	}
	
	public void addNode(Node insert) {
		graph.put(insert, new HashSet<>());
		nodes.put(size, insert);
		size++;
	}
	
	public void addDirectedEdge(int start, int end) {
		graph.get(nodes.get(start)).add(nodes.get(end));
	}
	
	public void addDoubleEdge(int start, int end) {
		addDirectedEdge(start, end);
		addDirectedEdge(end, start);
	}
	
	public HashSet<Node> getAdjacentNodes(Node current) {
		return graph.get(current);
	}
	
	public int getSize() {
		return size;
	}
	
	public Node getNode(int id) {
		return nodes.get(id);
	}
	
}