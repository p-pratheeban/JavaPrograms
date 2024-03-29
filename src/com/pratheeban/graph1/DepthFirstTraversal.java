package com.pratheeban.graph1;

import java.util.List;

public class DepthFirstTraversal {
	public static void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
		if (visited[currentVertex] == 1) {
			return;
		}
		visited[currentVertex] = 1;

		List<Integer> list = graph.getAdjacentVertices(currentVertex);
		for (int vertex : list) {
			depthFirstTraversal(graph, visited, vertex);
		}

		System.out.print(currentVertex + "->");
	}
	
	public static void main(String[] args) {
		int N = 8;
		Graph graph = new AdjacencyMatrixGraph(N, Graph.GraphType.DIRECTED);
		graph.addEdge(1, 0);
		graph.addEdge(1, 2);
		graph.addEdge(2, 7);
		graph.addEdge(2, 4);
		graph.addEdge(2, 3);
		graph.addEdge(1, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 3);
		graph.addEdge(3, 4);

		int[] visited = new int[N];

		// This for-loop ensures that all nodes are covered even for an unconnected
		// graph.
		for (int i = 0; i < N; i++) {
			depthFirstTraversal(graph, visited, i);
		}
	}
}
