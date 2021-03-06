import java.util.Comparator;

/**
 * Main class, generating the Directed Graph
 * @author Timothy Wiley
 */
public class Main {
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		// Generate Graph
		DirectedStringGraph graph = generateGraph();
		Comparator<DSGEdge> comparator = new Comparator<DSGEdge>() {
		    public int compare(DSGEdge e1, DSGEdge e2) { 
		    	if (e1.getWeight() > e2.getWeight()) return -1;
		    	if (e1.getWeight() < e2.getWeight()) return 1;
		    	else return 0;
		    }
		};
		BFS bfs = new BFS(graph);
		String path = bfs.findPath("Arad", "Bucharest", comparator);
		System.out.println(path);
		System.out.println(graph);
	}

	private static DirectedStringGraph generateGraph() {
		DirectedStringGraph graph = new DirectedStringGraph();
		
		// Nodes
		graph.addNode("Arad");
		graph.addNode("Bucharest");
		graph.addNode("Cralova");
		graph.addNode("Dobreta");
		graph.addNode("Eforle");
		graph.addNode("Fagaras");
		graph.addNode("Glurglu");
		graph.addNode("Hirsova");
		graph.addNode("Iasl");
		graph.addNode("Lugoj");
		graph.addNode("Mehadia");
		graph.addNode("Neamt");
		graph.addNode("Oradea");
		graph.addNode("Pitesti");
		graph.addNode("Rimnicu Vilcea");
		graph.addNode("Sibiu");
		graph.addNode("Timisoara");
		graph.addNode("Urziceni");
		graph.addNode("Vaslui");
		graph.addNode("Zerlnd");
		
		// Links
		// TODO: Implement weighted edges. When implemented the following code will work
		
		addLink(graph, "Arad", "Zerlnd", 75);
		addLink(graph, "Arad", "Timisoara", 118);
		addLink(graph, "Arad", "Sibiu", 140);
		addLink(graph, "Bucharest", "Pitesti", 101);
		addLink(graph, "Bucharest", "Fagaras", 211);
		addLink(graph, "Bucharest", "Urziceni", 85);
		addLink(graph, "Bucharest", "Glurglu", 90);
		addLink(graph, "Cralova", "Pitesti", 138);
		addLink(graph, "Cralova", "Rimnicu Vilcea", 146);
		addLink(graph, "Cralova", "Dobreta", 120);
		addLink(graph, "Dobreta", "Mehadia", 75);
		addLink(graph, "Eforle", "Hirsova", 86);
		addLink(graph, "Fagaras", "Sibiu", 99);
		addLink(graph, "Hirsova", "Urziceni", 98);
		addLink(graph, "Iasl", "Neamt", 87);
		addLink(graph, "Iasl", "Vaslui", 92);
		addLink(graph, "Lugoj", "Mehadia", 70);
		addLink(graph, "Lugoj", "Timisoara", 111);
		addLink(graph, "Oradea", "Sibiu", 151);
		addLink(graph, "Oradea", "Zerlnd", 71);
		addLink(graph, "Pitesti", "Rimnicu Vilcea", 97);
		addLink(graph, "Rimnicu Vilcea", "Sibiu", 80);
		addLink(graph, "Urziceni", "Vaslui", 142);
		
		
		return graph;
	}
	
	
	private static void addLink(DirectedStringGraph graph, String n1, String n2, int weight) {
		graph.addEdge(n1, n2, weight);
		graph.addEdge(n2, n1, weight);
	}
	
}
