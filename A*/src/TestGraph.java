import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author domsangio
 *
 */
class TestGraph {
	
	AStarRectangle astar;
	private Node start;
	private Node end;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		start = new Node(1);
		end = new Node(3);
		astar = new AStarRectangle(5, 5);
		
		/* add the edges to the graph for this specific graph */
		astar.getGraph().addDoubleEdge(0, 1);
		astar.getGraph().addDoubleEdge(0, 5);
		astar.getGraph().addDoubleEdge(5, 10);
		astar.getGraph().addDoubleEdge(10, 15);
		astar.getGraph().addDoubleEdge(15, 20);
		astar.getGraph().addDoubleEdge(20, 21);
		astar.getGraph().addDoubleEdge(21, 22);
		astar.getGraph().addDoubleEdge(22, 23);
		astar.getGraph().addDoubleEdge(23, 24);
		astar.getGraph().addDoubleEdge(22, 17);
		astar.getGraph().addDoubleEdge(17, 12);
		astar.getGraph().addDoubleEdge(12, 13);
		astar.getGraph().addDoubleEdge(14, 13);
		astar.getGraph().addDoubleEdge(14, 9);
		astar.getGraph().addDoubleEdge(4, 9);
		astar.getGraph().addDoubleEdge(4, 3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		astar = null;
	}

	@Test
	void test() {
		assertEquals("[0, 5, 10, 15, 20, 21, 22, 17, 12, 13, 14, 9, 4, 3]",astar.getShortestPath(start, end).toString());
	}

}
