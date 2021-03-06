import java.util.ArrayList;

/**
 * Provides the interface for a graph implementation that provides
 *  functionality that includes the addition/deletion of nodes
 *  and the edges associated with those nodes. This interface also
 *  provides functionality that includes whether an object appears in
 *  the graph, if two objects have an edge between them, and providing
 *  the number of vertices/edges in the graph.
 * 
 * @author	Hayden Charles Smith, z3418003<br />
 * 			Last modified: 19th May 2013
 */
public interface DirectedGraph<E> {
	
	/**
	 * Adds a node to the graph
	 * @param e Object to add
	 */
	public void addNode(E e);
	
	/**
	 * Removes a node (and it's edges) from the adjacency
	 *  list graph
	 * @param e Object to remove
	 */
	public void removeNode(E e);
	
	/**
	 * Adds an edge between two nodes
	 * @param from Directed edge FROM this point
	 * @param to Directed edge TO this point
	 */
	public void addEdge(E from, E to);
	
	/**
	 * Determines if two vertices are connected
	 * @param from Node to test connection FROM
	 * @param to Node to test connection TO
	 * @return Whether it is connected
	 */
	public boolean isConnected(E from, E to);
	
	/**
	 * Removes an edge from a graph
	 * @param from Origin node of edge that is removed
	 * @param to Destination node of edge that is removed
	 */
	public void removeEdge(E from, E to);
	
	/**
	 * Determines whether a node is in a graph
	 * @param e Object to look for
	 * @return Whether a node is in a graph
	 */
	public boolean isInGraph(E e);
	
	/**
	 * Gets all nodes connected by surrounding edges
	 * @param e Object that's neighbours are looking for
	 * @return ArrayList of neighbouring objects/nodes
	 */
	ArrayList<E> getNeighbours(E e);
	
	/**
	 * Returns number of nodes in the graph
	 * @return number of nodes in the graph
	 */
	public int getNumNodes();
	
	/**
	 * Returns number of edges in the graph
	 * @return number of edges in the graph
	 */
	public int getNumEdges();
	
	/**
	 * Return an array list of all nodes in the graph
	 * @return ArrayList of all nodes in the graph
	 */
	public ArrayList<E> getNodes();
	
	/**
	 * Creates edges between every node in the graph
	 */
	public void connectAllNodes();
	
}
