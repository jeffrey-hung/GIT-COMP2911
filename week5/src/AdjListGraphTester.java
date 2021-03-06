import java.util.ArrayList;

public class AdjListGraphTester {

	public static void main(String argv[])
	{
		Graph<String> g = new AdjListGraph<String>();
		g.addNode("A");
		g.addNode("B");
		g.addNode("C");
		g.addNode("D");
		g.addNode("E");
		g.addNode("F");
		g.removeNode("F");
		
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("C", "B");
		g.addEdge("C", "D");
		g.addEdge("C", "E");
		g.addEdge("E", "A");
		g.removeEdge("E", "A");
		
		System.out.println("Is A in graph? " + g.isInGraph("A"));
		System.out.println("Is B in graph? " + g.isInGraph("B"));
		System.out.println("Is C in graph? " + g.isInGraph("C"));
		System.out.println("Is D in graph? " + g.isInGraph("D"));
		System.out.println("Is E in graph? " + g.isInGraph("E"));
		System.out.println("Is CAT in graph? " + g.isInGraph("CAT"));
		System.out.println("Is F in graph? " + g.isInGraph("F"));
		System.out.println();
		
		System.out.println("THESE SHOULD BE TRUE");
		System.out.println("Is A connected to B? " + g.isConnected("A", "B"));
		System.out.println("Is B connected to C? " + g.isConnected("B", "C"));
		System.out.println("Is C connected to B? " + g.isConnected("C", "B"));
		System.out.println("Is C connected to D? " + g.isConnected("C", "D"));
		System.out.println("Is C connected to E? " + g.isConnected("C", "E"));
		System.out.println();
		
		System.out.println("THESE SHOULD BE FALSE");
		System.out.println("Is A connected to C? " + g.isConnected("A", "C"));
		System.out.println("Is E connected to A? " + g.isConnected("E", "A"));
		System.out.println("Is B connected to D? " + g.isConnected("B", "D"));
		System.out.println("Is C connected to A? " + g.isConnected("C", "A"));
		System.out.println();
		
		System.out.print("Printing neighbours of C... ");
		ArrayList<String> neighbours = g.getNeighbours("C");
		for (String item : neighbours) 
		{
			System.out.print(item + " | ");
		}
		System.out.println();
		
		System.out.println("Number of vertices (should be 5): " + g.getNumVertices());
		System.out.println("Number of Edges (should be 5): " + g.getNumEdges());
		
		g.printGraph();
		
		System.out.println("Removing Node C");
		g.removeNode("C");
		g.printGraph();
		
	}
}
