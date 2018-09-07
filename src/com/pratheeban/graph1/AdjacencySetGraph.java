package com.pratheeban.graph1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdjacencySetGraph implements Graph {

	private List<Node> vertexList = new ArrayList<>();
	private GraphType graphType = GraphType.DIRECTED;
	private int numVertices = 0;

	public AdjacencySetGraph(int numVertices, GraphType graphType) {
		this.numVertices = numVertices;
		for (int i = 0; i < numVertices; i++) {
			vertexList.add(new Node(i));
		}
		this.graphType = graphType;
	}

	@Override
	public void addEdge(int v1, int v2) {
		if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
			throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
		}

		vertexList.get(v1).addEdge(v2);
		if (graphType == GraphType.UNDIRECTED) {
			vertexList.get(v2).addEdge(v1);
		}
	}

	@Override
	public List<Integer> getAdjacentVertices(int v) {
		if (v >= numVertices || v < 0) {
			throw new IllegalArgumentException("Vertex number is not valid: " + v);
		}

		return vertexList.get(v).getAdjacentVertices();
	}

	@Override
	public int getIndegree(int v) {
		if (v < 0 || v >= numVertices) {
			throw new IllegalArgumentException("Vertex number is not valid");
		}
		int indegree = 0;
		for (int i = 0; i < numVertices; i++) {
			if (getAdjacentVertices(i).contains(v)) {
				indegree++;
			}
		}
		return indegree;
	}

	@Override
	public int getNumVertices() {
		return numVertices;
	}

	public static class Node {

		private int vertexNumber;
		private Set<Integer> adjacencySet = new HashSet<>();

		public Node(int vertexNumber) {
			this.vertexNumber = vertexNumber;
		}

		public int getVertexNumber() {
			return vertexNumber;
		}

		public void addEdge(int vertexNumber) {
			adjacencySet.add(vertexNumber);
		}

		public List<Integer> getAdjacentVertices() {
			List<Integer> sortedList = new ArrayList<>(adjacencySet);

			Collections.sort(sortedList);

			return sortedList;
		}
	}
}
