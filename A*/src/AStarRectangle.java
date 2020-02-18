import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class AStarRectangle implements A_Star<Node> {

	private Graph graph;
	
	private final int width;		//width of a rectangular grid
	private final int height;		//height of the rectangular grid
	
	public AStarRectangle(int width, int height) {
		this.width = width;
		this.height = height;
		
		graph = new Graph(width * height);
	}
	
	public Graph getGraph() {
		return graph;
	}


	/**
	 * Gets the shortest path from point a to point b in a rectangular grid
	 */
	@Override
	public LinkedList<Node> getShortestPath(Node start, Node end) {
		Set<Node> openSet = new HashSet<>();
		Set<Node> closedSet = new LinkedHashSet<>();
		
		openSet.add(start);
		
		while(!openSet.isEmpty()) {
			
			Node current = findLowestFCost(openSet);
			
			/* If we are at the end*/
			if(current.equals(end)) {
				
				/* Loops through until at the beginning to find the path */
				LinkedList<Node> path = new LinkedList<>();
				while(current != start) {
					path.addFirst(current);
					current = current.getCameFrom();
				}
				return path;
			}
			
			/* removes the node being evaluated and adds it to the set
			 * that has been evaluated already
			 */
			openSet.remove(current);
			closedSet.add(current);
			
			for(Node neighbor: graph.getAdjacentNodes(current)) {
				if(!closedSet.contains(neighbor)) {
					int tentativeGScore = neighbor.getGCost() + 1;
					
					//if we already been there check if its lower
					if(openSet.contains(neighbor)) {
						if(tentativeGScore < neighbor.getGCost()) {
							neighbor.setGCost(tentativeGScore);
						}
					}
					//if we are the first one there then we know its lowest
					else {
						neighbor.setGCost(tentativeGScore);
						openSet.add(neighbor);
					}
					/* This is the heart and soul of A* */
					neighbor.setHCost(getHeuristicFunction(neighbor, end));
					neighbor.setFCost(neighbor.getFCost() + neighbor.getGCost());
					
					neighbor.setCameFrom(current);
				}
			}
		}
		return new LinkedList<Node>();
	}

	@Override
	public Node findLowestFCost(Set<Node> set) {
		Node lowest = null;
		
		for(Node n: set) {
			if(lowest == null)
				lowest = n;
			if(n.getFCost() < lowest.getFCost()) {
				lowest = n;
			}
		}
		return lowest;
	}

	/**
	 * Because we know that our graph is a 5x5, we can use 
	 * the modulus operator in order to find the distance
	 * @return the euclidean distance between two nodes
	 */
	private int EuclideanHeuristic(Node n1, Node n2) {
		int y1 = n1.getLocation() % height;
		int x1 = n1.getLocation() / width;
		
		int y2 = n2.getLocation() % height;
		int x2 = n2.getLocation() / width;
		
		return (int) Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow((x2-x1), 2));
	}

	/**
	 * returns the heuristic function
	 */
	@Override
	public int getHeuristicFunction(Node start, Node end) {
		return EuclideanHeuristic(start, end);
	}
}