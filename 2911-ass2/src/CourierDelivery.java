import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.LinkedList;

/**
 * Courier Delivery Class.
 * 
 * Given a list of Jobs with a "start" point and a "finish" point
 *  from standard input, this class creates a graph, and adds these
 *  points to the graph.
 * This class then performs an A* search on the graph to find 
 *  the minimal spanning path from one "JobNode" to
 *  another that passes through every "JobNode"
 * 
 * TODO: Set limitations
 * 
 * @author	Hayden Charles Smith, z3418003
 * 			Last modified: 19th May 2013
 */

public class CourierDelivery
{
	/**
	 * Main method for program
	 * @param args Arguments from standard input
	 */
	public static void main(String[] args)
	{
		try
	    {			
			graph				= new AdjacencyListGraph<DualPoint>();
			asearch				= new Asearch(graph);
			DualPoint origin	= new CourierDeliveryJobPoint(0, 0, 0, 0);
			Scanner userInput 	= new Scanner(new FileReader(args[0]));
			
			Comparator<SearchNode<DualPoint>> comp = new Comparator<SearchNode<DualPoint>>()
			{
				public int compare(SearchNode<DualPoint> e1, SearchNode<DualPoint> e2)
				{
			    	if (e1.getHeuristicEstimate() > e2.getHeuristicEstimate()) return 1;
			    	if (e1.getHeuristicEstimate() < e2.getHeuristicEstimate()) return -1;
			    	else return 0;
				}
			};
			
			buildGraph(userInput, origin);
			LinkedList<DualPoint> minimalSpanningPathList = asearch.findMinimalSpanningPath(origin, comp); 
			printPathList(minimalSpanningPathList); 
	    }
	    catch (FileNotFoundException e)
	    {
	    	speak("FileNotFoundException: " + e.getMessage());
	    }
		catch (ArrayIndexOutOfBoundsException e)
		{
			speak("Please add a single parameter that is an input file");
		}
	}
	
	/**
	 * Given a Scanner input, this method extracts all of the 
	 *  relative point data for the reaction of JobPoints that
	 *  are then added to the graph
	 * @param userInput Scanner input
	 * @param initialDualPoint Origin point to add to the graph (in 
	 *  case an origin is not given in the input)
	 */
	private static void buildGraph(Scanner userInput, DualPoint initialDualPoint)
	{
		if (initialDualPoint != null)
		{
			graph.addNode(initialDualPoint);
		}
		
		while (userInput.hasNextLine())
		{
			// Split string into components
			String input[] = userInput.nextLine().split(" ");
			
			// Extract integer values from array of components
			int fromX = Integer.parseInt(input[COODINATE_FROM_X]);
			int fromY = Integer.parseInt(input[COODINATE_FROM_Y]);
			int toX =	Integer.parseInt(input[COODINATE_TO_X]);
			int toY = 	Integer.parseInt(input[COODINATE_TO_Y]);
			graph.addNode(new CourierDeliveryJobPoint(fromX, fromY, toX, toY));
		}
		userInput.close();
		
		// Ensure every node has an edge to every other node
		graph.connectAllNodes();
	}
	
	/**
	 * Given a list of DualPoints, print out the number of DualPoints in this path,
	 *  the total distance covered by the DualPoints (internal and external),
	 *  and provide a summary of the movements (or carries) made between or within
	 *  these DualPoints
	 * @param path LinkedList of DualPoint's that constitute the path
	 * @return Single string that contains all necessary text
	 */
	private static void printPathList(LinkedList<DualPoint> path)
	{
		String output = new String();
		int totalDistance = 0;
		for (int i = 0; i < (path.size() - 1); i++)
		{
			DualPoint nodeLeft = path.get(i);
			DualPoint nodeRight = path.get(i + 1);
			
			// Check if "Move"'s START and FINISH are not the same
			if (nodeLeft.getExternalDistanceTo(nodeRight) > 0)
			{
				output = output + "Move from " + nodeLeft.getXFinish() + " " + nodeLeft.getYFinish()
					+ " to " + nodeRight.getXStart() + " " + nodeRight.getYStart() + "\n";
			}
			output = output + "Carry from " + nodeRight.getXStart() + " " + nodeRight.getYStart()
				+ " to " + nodeRight.getXFinish() + " " + nodeRight.getYFinish() + "\n";
			
			// Add both the internal and external distance on
			totalDistance += nodeLeft.getInternalDistance();
			totalDistance += nodeLeft.getExternalDistanceTo(nodeRight);
		}
		totalDistance += path.get(path.size() - 1).getInternalDistance();
		
		output = asearch.getNumNodesExplored() + " nodes explored\n" + output;
		output = "cost = " + totalDistance + "\n" + output;
		speak(output);
	}

	/**
	 * Print a string to standard output
	 * @param printout String to print
	 */
	private static void speak(String printout)
	{
		if (!printout.equals(""))
		{
			System.out.print(printout);
		}
	}
	
	private static AdjacencyListGraph<DualPoint> graph;
	private static Asearch asearch;
	private static final int COODINATE_FROM_X = 1;
	private static final int COODINATE_FROM_Y = 2;
	private static final int COODINATE_TO_X = 4;
	private static final int COODINATE_TO_Y = 5;
	
}
