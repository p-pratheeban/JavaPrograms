package com.pratheeban.graph.bfs;

import java.util.Stack;

import com.pratheeban.graph.Graph;

class MinimumSpaningTree {

	private Stack<Integer> theStack = new Stack<>();

	public void mst(Graph d) // depth-first search
	{ // begin at vertex 0
		d.vertexList[0].wasVisited = true; // mark it
		theStack.push(0); // push it
		while (!theStack.isEmpty()) // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			int currentVertex = theStack.peek();
			int v = d.getAdjUnvisitedVertex(currentVertex);
			if (v == -1) // if no such vertex,
				theStack.pop(); // pop a new one
			else // if it exists,
			{
				d.vertexList[v].wasVisited = true; // mark it
				d.displayVertex(currentVertex);
				d.displayVertex(v); // display it
				System.out.print(" ");
				theStack.push(v); // push it
				
			}
		} // end while
			// stack is empty, so we’re done
		for (int j = 0; j < d.nVerts; j++) // reset flags
			d.vertexList[j].wasVisited = false;
	} // end dfs

	public Graph createGraph() {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(0, 2); // AC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(0, 4); // AE
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(1, 3); // BD
		theGraph.addEdge(1, 4); // BE
		theGraph.addEdge(2, 3); // CD
		theGraph.addEdge(2, 4); // CE
		theGraph.addEdge(3, 4); // DE
		return theGraph;
	}

	public static void main(String[] args) {
		MinimumSpaningTree d = new MinimumSpaningTree();
		Graph g = d.createGraph();
		System.out.print("Visits: ");
		d.mst(g); // depth-first search
		System.out.println();
	}
} // end class Graph