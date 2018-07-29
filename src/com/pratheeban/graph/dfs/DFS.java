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

	public void dfsrecursive(Graph g, int v) {
		g.displayVertex(v);
		g.vertexList[v].wasVisited = true;
		int v1;
		while ((v1=g.getAdjUnvisitedVertex(v)) != -1) {
			dfsrecursive(g, v1);
		}
	}

	/*
	 * A----B---C | | D----E
	 */
	public static void main(String[] args) {
		DFS d = new DFS();
		Graph g = Graph.createGraph();
		System.out.print("Visits: ");
		d.dfs(g); // depth-first search
		System.out.println();
		System.out.print("Visits: ");
		d.dfsrecursive(g, 0); // depth-first search
		g.reset();
	}
} // end class Graph