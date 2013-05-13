import java.util.LinkedList;

public class AsearchNode<E> implements SearchNode<E> {

	public AsearchNode(E nodeObj, int distanceTravelled)
	{
		this.nodeObj = nodeObj;
		this.distanceTravelled = distanceTravelled;
		this.visited = new LinkedList<AsearchNode<E>>();
	}
	
	public boolean equals(Object nodeObj)
	{
		if (nodeObj == this.nodeObj)
		{
			return true;
		}
		return false;
	}
	
	public E getNodeObj()
	{
		return this.nodeObj;
	}
	
	public void addVisited(AsearchNode<E> newVisited)
	{
		visited.add(newVisited);
	}
	
	public int getNumNodesVisited()
	{
		return visited.size();
	}
	
	public boolean hasVisited(E otherNode)
	{
		for (AsearchNode<E> node : visited)
		{
			if (node.getNodeObj().equals(otherNode))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public LinkedList<AsearchNode<E>> getNodesVisited()
	{
		LinkedList<AsearchNode<E>> path = new LinkedList<AsearchNode<E>>();
		for (AsearchNode<E> obj : visited)
		{
			path.add(obj);
		}
		return path;
	}
	
	public LinkedList<E> getNodeObjsVisited()
	{
		LinkedList<E> path = new LinkedList<E>();
		for (AsearchNode<E> obj : visited)
		{
			path.add(obj.getNodeObj());
		}
		return path;
	}
	
	public int getDistanceTravelled()
	{
		return this.distanceTravelled;
	}

	private LinkedList<AsearchNode<E>> visited;
	private E nodeObj;
	private int distanceTravelled;
	
}