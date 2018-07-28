package com.pratheeban.graph;

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

	// -------------------------------------------------------------
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
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
		// -------------------------------------------------------------
}
