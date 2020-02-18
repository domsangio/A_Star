import java.util.LinkedList;
import java.util.Set;

public interface A_Star<T> {
	
	public LinkedList<T> getShortestPath(T start, T end);
	public T findLowestFCost(Set<T> set);
	public int getHeuristicFunction(T start, T end);
	
}
