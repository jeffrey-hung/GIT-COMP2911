/*
import java.util.LinkedList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.lang.StringBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class Asearch {

	public Asearch(Graph<DualPoint> graph)
	{
		this.graph = graph;
	}
	
	public String findPath(DualPoint initialPoint, Comparator<AsearchNode> comp)
	{
		// Establish path to take
		LinkedList<AsearchNode> path = new LinkedList<AsearchNode>();
		StringBuffer result = new StringBuffer();
		PriorityQueue<AsearchNode> priorityQueue = new PriorityQueue<AsearchNode>(INITIAL_QUEUE_CAPACITY, comp);
		
		if (graph.getNumVertices() > 0)
		{
			AsearchNode current = new AsearchNode(initialPoint, 0);
			priorityQueue.add(current);
			
			boolean visitedAll = false;
			
			ArrayList<DualPoint> neighbours = null;
			
			while (!priorityQueue.isEmpty() && !visitedAll)
			{
				current = priorityQueue.poll();
				debug("Current: " + current.getNodeObj().toString());
				
				current.addVisited(current);
				debug("Current (Visited): " + current.getNodesVisited().toString());
				neighbours = graph.getNeighbours(current.getNodeObj());
			    for(DualPoint currentNeighbour : neighbours)
			    {
			    	debug("Neighbour: "+currentNeighbour+" (not visited: "+(!current.hasVisited(currentNeighbour))+")");
			    	if (!current.hasVisited(currentNeighbour))
			    	{
			    		int distanceDifference = current.getNodeObj().getExternalDistanceTo(currentNeighbour);
			    		debug("-- External Distance ("+current+" --> "+currentNeighbour+"): " + distanceDifference);
			    		
			    		int travelled = (current.getExternalDistanceTravelled() + distanceDifference);
			    		debug("-- Cumul Distance ("+current+" --> "+currentNeighbour+"): " + current.getExternalDistanceTravelled());
			    		debug("-- Total Distance ("+current+" --> "+currentNeighbour+"): " + travelled);
						AsearchNode nodeToAdd = new AsearchNode(currentNeighbour, travelled);
			    		
			    		for(AsearchNode alreadyVisited : current.getNodesVisited())
			    		{
			    			nodeToAdd.addVisited(alreadyVisited);
			    		}
			    		priorityQueue.add(nodeToAdd);
			    		printPriorityQueue(priorityQueue);
			    	}
			    }
			    if (current.getNumNodesVisited() >= this.graph.getNumVertices())
				{
					visitedAll = true;
				}
			}
			
			if(current.getNumNodesVisited() == this.graph.getNumVertices()) {
				path = current.getNodeObjsVisited();
				
				//debug("Final (Visited): " + current.getNodesVisited().toString());
				result.append(current.getNumNodesVisited() + " nodes explored\n");
				result.append("cost = " + current.getTotalDistanceTravelled() + "\n");
				for (int i = 0; i < (path.size() - 1); i++)
				{
					DualPoint nodeLeft = path.get(i).getNodeObj();
					DualPoint nodeRight = path.get(i + 1).getNodeObj();
					result.append("Move from " + nodeLeft.getToX() + " " + nodeLeft.getToY() + " to " + nodeRight.getFromX() + " " + nodeRight.getFromY() + "\n");
					result.append("Carry from " + nodeRight.getFromX() + " " + nodeRight.getFromY() + " to " + nodeRight.getToX() + " " + nodeRight.getToY() + "\n");
				}
			}			 
		}
		return result.toString();		
	}
	
	private void debug(String s)
	{
		//System.out.println(s);
	}
	
	private void printPriorityQueue(PriorityQueue q)
	{
		PriorityQueue<AsearchNode> q2 = new PriorityQueue<AsearchNode>(q);
		while (q2.size() > 0)
		{
			debug("=Queue: " + q2.poll().toString());
		}
	}
		
	private Graph<DualPoint> graph;
	private static final int INITIAL_QUEUE_CAPACITY = 100;

}
*/