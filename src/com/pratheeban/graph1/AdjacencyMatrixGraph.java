package com.pratheeban.graph1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {

	private int[][] adjacencyMatrix;
	private GraphType graphType = GraphType.DIRECTED;
	private int numVertices = 0;

	public AdjacencyMatrixGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;
		this.graphType = graphType;

		adjacencyMatrix = new int[numVertices][numVertices];

		for (int i = 0; i < numVertices; i++) {
			for (int j = 0; j < numVertices; j++) {
				adjacencyMatrix[i][j] = 0;
			}
		}
	}

	@Override
	public void addEdge(int v1, int v2) {
		if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}

		adjacencyMatrix[v1][v2] = 1;
		if (graphType == GraphType.UNDIRECTED) {
			adjacencyMatrix[v2][v1] = 1;
		}
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if (v >= numVertices || v < 0) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}

		List<Integer> adjacentVerticesList = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			if (adjacencyMatrix[v][i] == 1) {
				adjacentVerticesList.add(i);
			}
		}

		// Always return the vertices in ascending order.
		Collections.sort(adjacentVerticesList);

		return adjacentVerticesList;
	}

	@Override
	public int getIndegree(int v) {
		if (v < 0 || v >= numVertices) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}
		int indegree = 0;
		for (int i = 0; i < getNumVertices(); i++) {
			if (adjacencyMatrix[i][v] != 0) {
				indegree++;
			}
		}
		return indegree;
	}

	@Override
	public int getNumVertices() {
		return numVertices;
	}
}
