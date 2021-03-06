import java.util.LinkedList;

/**
 * SearchNode is a node used when completing
 *  searches (e.g. BFS, A* Search). Each node
 *  can be viewed as a state space.<br /><br />
 *  
 * A single object is contained within each node.
 * 
 * @author	Hayden Charles Smith, z3418003<br />
 * 			Last modified: 19th May 2013
 * 
 * @param <E> Object held within this node
 */
public interface SearchNode<E>
{
	
	/**
	 * Returns the object contained within the AsearchNode
	 * @return Object contained within the AsearchNode
	 */
	public E getNodeObj();
	
	/**
	 * Adds a SearchNode to the list of previously visited SearchNode's
	 *  contained within this node
	 * @param newVisited SearchNode to add to the visited list
	 */
	public void addVisited(SearchNode<E> newVisited);

	/**
	 * Get the number of SearchNodes that have been visited
	 * @return number of SearchNodes previously visited
	 */
	public int getNumNodesVisited();
	
	/**
	 * Given an Object, determines whether the current state
	 *  space has visited the object before
	 * @param obj Object to check if has been visited
	 * @return Whether the given object has been visited by
	 *  the current SearchNode (state space)
	 */
	public boolean hasVisitedObj(E obj);
	
	/**
	 * Returns a list of SearchNodes that have been visited
	 *  previously by current SearchNode (state space)
	 * @return LinkedList of SearchNodes that have been visited
	 */
	public LinkedList<SearchNode<E>> getNodesVisited();
	
	/**
	 * Returns a list of SearchNodes that have been visited
	 *  previously by the current SearchNode (state space)
	 * @return LinkedList each SearchNode that has been visited's object
	 */
	public LinkedList<E> getNodeObjsVisited();
		
	/**
	 * Returns cumulative external arbitrary distance the current state
	 *  space has traversed in order to reach it's current state
	 * @return Cumulative external distance traversed to current 
	 *  state
	 */
	public int getExternalDistanceTravelled();
	
	/**
	 * Returns estimated arbitrary distance remaining to goal state
	 * @return Estimated arbitrary distance remaining to goal state
	 */
	public int getEstimatedDistanceRemaining();
	
	/**
	 * Set estimated arbitrary distance remaining to goal state
	 * @param val Arbitrary distance remaining to goal state
	 */
	public void setEstimatedDistanceRemaining(int val);
	
	/**
	 * Returns estimate value determined by the heuristic that
	 *   reflects the arbitrary closeness to the goal state.
	 * @return Estimate value determined by heuristic that reflects
	 *  arbitrary closeness to goal state
	 */
	public int getHeuristicEstimate();
	
}