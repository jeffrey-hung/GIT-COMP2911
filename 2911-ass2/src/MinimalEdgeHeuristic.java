import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MinimalEdgeHeuristic implements Heuristic<SearchNode<DualPoint>> {
	
	public MinimalEdgeHeuristic(DirectedGraph<DualPoint> graph)
	{
		this.graph = graph;
	}
	
	public int getEstimate(SearchNode<DualPoint> node)
	{
		int sum = 0;
		
		Comparator<Integer> lowToHigh = new Comparator<Integer>()
		{
			public int compare(Integer a, Integer b)
			{
				return (a - b);
			}
		};
		
		Comparator<Integer> highToLow = new Comparator<Integer>()
		{
			public int compare(Integer a, Integer b)
			{
				return (b - a);
			}
		};
				
		PriorityQueue<Integer> edgeWeights = new PriorityQueue<Integer>(INITIAL_QUEUE_CAPACITY, highToLow);
				
		debug("---------------------------------------------------------------");
		debug(node.toString());
		for (DualPoint dualPoint : this.graph.getNodes())
		{
			debug("\nNode ("+dualPoint+")");
			if (!node.hasVisitedObj(dualPoint))
			{
				debug("--NotVisited");
				ArrayList<DualPoint> neighbours = new ArrayList<DualPoint>(graph.getNeighbours(dualPoint));
				debug("----Neighbours: " + neighbours);
				PriorityQueue<Integer> neighbourEdgeWeights = new PriorityQueue<Integer>(INITIAL_QUEUE_CAPACITY, lowToHigh);
				for (DualPoint neighbour : neighbours)
				{
					if (!node.hasVisitedObj(neighbour) && node.getNodeObj() != neighbour)
					{
						debug("------NotVisited: " + neighbour);
						debug("------Adding: ("+dualPoint.getToX()+", "+dualPoint.getToY()+") --> ("+neighbour.getFromX()+", "+neighbour.getFromY()+") " + dualPoint.getExternalDistanceTo(neighbour));
						
						neighbourEdgeWeights.add(dualPoint.getExternalDistanceTo(neighbour));
					}
				}
				debug("Size: " + neighbourEdgeWeights.size());
				if (neighbourEdgeWeights.size() > 0)
				{
					int o = neighbourEdgeWeights.poll();
					debug("--TakingSmallest " + o);
					edgeWeights.add(o);
				}
			}
		}
		
		edgeWeights.poll(); // Strip the biggest
		
		PriorityQueue<Integer> edgeWeights2 = new PriorityQueue<Integer>(edgeWeights);
		
		debug("Edge Size: " + edgeWeights2.size());
		int i = 0;
		for (int t = edgeWeights2.size(); i < t; i++)
		{
			int oo = edgeWeights2.poll();
			debug("Edge: " + oo);
		}
		
		
				
		for (Integer val : edgeWeights)
		{
			sum += val;
		}
		debug("Estimate: " + sum + "\n");
		return sum;
		
		
		
	}
	
	private void debug(String str)
	{
		//System.out.println(str);
	}
	
	private DirectedGraph<DualPoint> graph;
	private final int INITIAL_QUEUE_CAPACITY = 100;
}