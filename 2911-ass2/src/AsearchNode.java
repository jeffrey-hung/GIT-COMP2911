import java.util.LinkedList;

/**
 * Acts as a node that operates in an A* search. This acts
 *  as a state space by storing all previous nodes that
 *  have been visited upon reaching the current AsearchNode.<br /><br />
 *  
 *  A single object is contained within each node.
 * 
 * @author	Hayden Charles Smith, z3418003<br />
 * 			Last modified: 19th May 2013
 * 
 * @param <E> Object held within this node
 */
public class AsearchNode<E> implements SearchNode<E> {

	/**
	 * Creates an AsearchNode object
	 * @param nodeObj Object of type E contained within the AsearchNode
	 * @param externalDistance External distance traversed to get
	 *  to this state
	 */
	public AsearchNode(E nodeObj, int externalDistance)
	{
		this.nodeObj = nodeObj;
		this.externalDistanceTravelled = externalDistance;
		this.visited = new LinkedList<SearchNode<E>>();
	}
	
	/**
	 * Returns the object of type E contained within the AsearchNode
	 * @return The object of type E contained within the AsearchNode
	 */
	public E getNodeObj()
	{
		return this.nodeObj;
	}
	
	/**
	 * Adds an AsearchNode to the list of previously visited AsearchNode's
	 *  contained within this AsearchNode
	 * @param newVisited AsearchNode to add to the visited list
	 */
	public void addVisited(SearchNode<E> newVisited)
	{
		visited.addLast(newVisited);
	}
	
	/**
	 * Get the number of AsearchNodes that have been visited
	 * @return number of AsearchNodes previously visited
	 */
	public int getNumNodesVisited()
	{
		return visited.size();
	}
	
	/**
	 * Given an object of type E, determines whether the current state
	 *  space has visited the node before
	 * @param otherNode Object of type E to check if has been visited
	 * @return Whether the Object of type E object has been visited by
	 *  the current state space
	 */
	public boolean hasVisitedObj(E otherNode)
	{
		for (SearchNode<E> node : visited)
		{
			if (node.getNodeObj().equals(otherNode))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Returns a list of AsearchNodes that have been visited
	 *  previously by the current AsearchNode.
	 * @return LinkedList of AsearchNodes that have been visited
	 */
	public LinkedList<SearchNode<E>> getNodesVisited()
	{
		LinkedList<SearchNode<E>> path = new LinkedList<SearchNode<E>>();
		for (SearchNode<E> obj : visited)
		{
			path.add(obj);
		}
		return path;
	}
	
	/**
	 * Returns a list of AsearchNodes' objects of type E that have
	 *  been visited previously by the current node.
	 * @return LinkedList of AsearchNodes' objects of type E that
	 *  have been visited
	 */
	public LinkedList<E> getNodeObjsVisited()
	{
		LinkedList<E> path = new LinkedList<E>();
		for (SearchNode<E> obj : visited)
		{
			path.add(obj.getNodeObj());
		}
		return path;
	}
		
	/**
	 * Get the cumulative external distance the current state
	 *  space has traversed in order to reach it's current
	 *  state
	 * @return Cumulative external distance traversed to current 
	 *  state
	 */
	public int getExternalDistanceTravelled()
	{
		return this.externalDistanceTravelled;
	}
	
	/**
	 * Returns estimated arbitrary distance remaining to goal state
	 * @return Estimated arbitrary distance remaining to goal state
	 */
	public int getEstimatedDistanceRemaining()
	{
		return this.estimatedDistanceRemaining;
	}
	
	/**
	 * Set estimated arbitrary distance remaining to goal state
	 * @param val Arbitrary distance remaining to goal state
	 */
	public void setEstimatedDistanceRemaining(int val)
	{
		this.estimatedDistanceRemaining = val;
	}

	/**
	 * Returns estimate value determined by the heuristic that
	 *   reflects the arbitrary closeness to the goal state.
	 * @return Estimate value determined by heuristic that reflects
	 *  arbitrary closeness to goal state
	 */
	public int getHeuristicEstimate()
	{
		return this.estimatedDistanceRemaining + this.externalDistanceTravelled;
	}
	
	private LinkedList<SearchNode<E>> visited;
	private E nodeObj;
	private int externalDistanceTravelled;
	private int estimatedDistanceRemaining;
	
}