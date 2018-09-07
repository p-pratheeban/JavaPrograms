package com.pratheeban.graph1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTraversal {
	public static void breadthFirstTraversal(Graph graph, int[] visited, int currentVertex) {

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(currentVertex);

		while (!queue.isEmpty()) {
			int vertex = queue.remove();

			if (visited[vertex] == 1) {
				continue;
			}

			System.out.print(vertex + "->");
			visited[vertex] = 1;

			List<Integer> list = graph.getAdjacentVertices(vertex);
			for (int v : list) {
				if (visited[v] != 1) {
					queue.add(v);
				}
			}
		}
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
			breadthFirstTraversal(graph, visited, i);
		}
	}
}
