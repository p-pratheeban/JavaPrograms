package com.pratheeban.graph.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import com.pratheeban.graph.Graph;

class BFS {

	public void bfs(Graph d) // depth-first search
	{ // begin at vertex 0
		Queue<Integer> theQueue = new LinkedList<>();
		d.vertexList[0].wasVisited = true; // mark it
		d.displayVertex(0); // display it
		theQueue.add(0); // insert at tail
		int v2;

		while (!theQueue.isEmpty()) // until queue empty,
		{
			int v1 = theQueue.remove(); // remove vertex at head
			// until it has no unvisited neighbors
			while ((v2 = d.getAdjUnvisitedVertex(v1)) != -1) { // get one,
				d.vertexList[v2].wasVisited = true; // mark it
				d.displayVertex(v2); // display it
				theQueue.add(v2); // insert it
			} // end while
		} // end while(queue not empty)
		d.reset();

	} // end bfs

	public void bfs1(Graph g) {
		Queue<Integer> q1 = new LinkedList<>();
		Set<Integer> s = new HashSet<>();
		q1.add(0);
		s.add(0);
		while (!q1.isEmpty()) {
			int v1 = q1.poll();
			g.displayVertex(v1);
			for (Integer v : g.getAdjacentVertexs(v1)) {
				if (!s.contains(v)) {
					s.add(v);
					q1.add(v);
				}
			}
		}
	}

	/*
	 * A----B---C | D----E
	 */
	public static void main(String[] args) {
		BFS d = new BFS();
		Graph g = Graph.createGraph();
		System.out.print("Visits: ");
		d.bfs(g); // depth-first search
		System.out.println();
		System.out.print("Visits: ");
		d.bfs1(g); // depth-first search
		System.out.println();

	}
} // end class Graph