package com.pratheeban.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NearestClone {
	static class Node {
		int vertex;
		long color;
		boolean visited;
		List<Node> adjacent;

		public Node(int v, long c) {
			vertex = v;
			color = c;
			adjacent = new ArrayList<>();
		}

		public void addAjacent(Node x) {
			adjacent.add(x);
		}

		public List<Node> getAdjacents() {
			return adjacent;
		}

	}

	static class Graph {
		List<Node> vertexes;

		public Graph() {
			vertexes = new ArrayList<>();

		}

		public void addVertex(Node x) {
			vertexes.add(x);
		}

		public List<Node> getVertexes() {
			return vertexes;
		}

		public Node getVertex(int x) {
			for (Node l : vertexes) {
				if (l.vertex == x) {
					return l;
				}
			}
			return null;
		}

		public Node getVertex1(int x) {
			for (Node l : vertexes) {
				if (l.color == x) {
					return l;
				}
			}
			return null;
		}

	}

	static Graph buildGraph(int graphNodes, long[] ids, int[] graphFrom, int[] graphTo) {
		Graph g = new Graph();
		for (int i = 1; i <= graphNodes; i++) {
			Node x = new Node(i, ids[i - 1]);
			g.addVertex(x);
		}
		for (int i = 0; i < graphFrom.length; i++) {
			Node u = g.getVertex(graphFrom[i]);
			Node v = g.getVertex(graphTo[i]);
			u.addAjacent(v);
			v.addAjacent(u);
		}
		return g;

	}

	static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
		Graph g = buildGraph(graphNodes, ids, graphFrom, graphTo);
		// solve here
		int dist = 0;
		Node start = g.getVertex1(val);
		Queue<Node> q = new LinkedList<>();
		start.visited = true;
		q.add(start);
		while (!q.isEmpty()) {
			Node node = q.remove();
			if(node==null) {
				dist -= 1;
				continue;
			}
			dist += 1;
			for (Node n : node.getAdjacents()) {
				if (!n.visited) {
					n.visited = true;
					q.add(n);
					if (n.color == val) {
						return dist;
					}
				}

			}
			q.add(null);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] graphFrom = { 1, 1, 4 };
		int[] graphTo = { 2, 3, 2 };
		long[] ids = { 1, 2, 1, 1 };

		int d = findShortest(4, graphFrom, graphTo, ids, 1);
		System.out.println(d);

		int[] graphFrom1 = { 1, 1, 4 };
		int[] graphTo1 = { 2, 3, 4, 5 };
		long[] ids1 = { 1, 2, 3, 4 };
		int d1 = findShortest(4, graphFrom1, graphTo1, ids1, 2);
		System.out.println(d1);

		int[] graphFrom2 = { 1, 1, 2, 3 };
		int[] graphTo2 = { 2, 3, 4 ,5};
		long[] ids2 = { 1, 2, 3, 3, 2 };
		int d2 = findShortest(5, graphFrom2, graphTo2, ids2, 2);
		System.out.println(d2);
	}
}
