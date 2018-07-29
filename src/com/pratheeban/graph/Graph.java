package com.pratheeban.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private final int MAX_VERTS = 20;
	public Vertex vertexList[]; // array of vertices
	private int adjMat[][]; // adjacency matrix
	public int nVerts; // current number of vertices
	// -------------------------------------------------------------

	public Graph() // constructor
	{
		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++) // set adjacency
			for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
				adjMat[j][k] = 0;
	} // end constructor
		// -------------------------------------------------------------

	public void addVertex(char lab) // argument is label
	{
		vertexList[nVerts++] = new Vertex(lab);
	}
	public void addVertex(char lab, int id) // argument is label
	{
		vertexList[nVerts++] = new Vertex(lab,id);
	}

	// -------------------------------------------------------------
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void addDirectedEdge(int start, int end) {
		adjMat[start][end] = 1;
	}

	// -------------------------------------------------------------
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void reset() {
		for (int j = 0; j < nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
	}

	// returns an unvisited vertex adjacent to v
	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j; // return first such vertex
		return -1; // no such vertices
	} // end getAdjUnvisitedVertex()

	public List<Integer> getAdjacentVertexs(int v) {
		List<Integer> neighbors = new ArrayList<>();
		for (int i = 0; i < nVerts; i++) {
			if (adjMat[v][i] == 1) {
				neighbors.add(i);
			}
		}
		return neighbors;
	}

	public static Graph createGraph() {
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
	
	public static Graph createDirectGraph() {
		Graph theGraph = new Graph();
		theGraph.addVertex('A',0); // 0
		theGraph.addVertex('B',1); // 1
		theGraph.addVertex('C',2); // 2
		theGraph.addVertex('D',3); // 3
		theGraph.addVertex('E',4); // 4
		theGraph.addVertex('F',5); // 5
		theGraph.addVertex('G',6); // 6
		theGraph.addVertex('H',7); // 7

		theGraph.addDirectedEdge(0, 3); // AD
		theGraph.addDirectedEdge(0, 4); // AE
		theGraph.addDirectedEdge(1, 4); // BE
		theGraph.addDirectedEdge(2, 5); // CF
		theGraph.addDirectedEdge(3, 6); // DG
		theGraph.addDirectedEdge(4, 6); // EG
		theGraph.addDirectedEdge(5, 7); // FH
		theGraph.addDirectedEdge(6, 7); // GH
		
		return theGraph;
	}

	// -------------------------------------------------------------
}
