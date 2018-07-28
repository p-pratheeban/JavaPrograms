package com.pratheeban.graph.dfs;

import java.util.Stack;

import com.pratheeban.graph.Graph;

class DFS {

	private Stack<Integer> theStack = new Stack<>();

	public void dfs(Graph d) // depth-first search
	{ // begin at vertex 0
		d.vertexList[0].wasVisited = true; // mark it
		d.displayVertex(0); // display it
		theStack.push(0); // push it
		while (!theStack.isEmpty()) // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			int v = d.getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) // if no such vertex,
				theStack.pop(); // pop a new one
			else // if it exists,
			{
				d.vertexList[v].wasVisited = true; // mark it
				d.displayVertex(v); // display it
				theStack.push(v); // push it
			}
		} // end while
			// stack is empty, so we’re done
		d.reset();

	} // end dfs

	static void dfsrecursive(Graph g, Integer v) {
		g.displayVertex(v);
		g.vertexList[v].wasVisited = true;
		while (g.getAdjUnvisitedVertex(v) != -1) {
			dfsrecursive(g, g.getAdjUnvisitedVertex(v));
		}
	}

	public Graph createGraph() {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start for dfs)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3DFS
		theGraph.addVertex('E'); // 4
		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(3, 4); // DE
		return theGraph;
	}

	/*
	 * A----B---C | | D----E
	 */
	public static void main(String[] args) {
		DFS d = new DFS();
		Graph g = d.createGraph();
		System.out.print("Visits: ");
		d.dfs(g); // depth-first search
		System.out.println();
		System.out.print("Visits: ");
		d.dfsrecursive(g, 0); // depth-first search
		g.reset();
	}
} // end class Graph