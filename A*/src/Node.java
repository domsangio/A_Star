/**
 * This class is used for the nodes in the graph. the location variable
 * is the "id" of the node, what distinguishes it
 * @author domsangio
 *
 */
public class Node {
	
	private int location,	//location
	gCost,					//g cost
	hCost,					//h cost
	fCost;					//f cost
	
	private Node cameFrom;

	public Node getCameFrom() {
		return this.cameFrom;
	}
	
	public void setCameFrom(Node cameFrom) {
		this.cameFrom = cameFrom;
	}
	
	public Node(int location) {
		this.location = location;
	}
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getGCost() {
		return gCost;
	}

	public void setGCost(int g) {
		this.gCost = g;
	}

	public int getHCost() {
		return hCost;
	}

	public void setHCost(int h) {
		this.hCost = h;
	}

	public int getFCost() {
		return fCost;
	}

	public void setFCost(int fCost) {
		this.fCost = fCost;
	}
	
	public String toString() {
		return "" + this.location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + location;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (location != other.location)
			return false;
		return true;
	}
	
	
	
}
