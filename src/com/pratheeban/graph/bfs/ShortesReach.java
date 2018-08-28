package com.pratheeban.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortesReach {
	/** Edge weight **/
	private static int EDGE_DISTANCE;

	/** Track distance to 'start' node **/
	public int[] distance;
	/**
	 * Graph where index is 0-indexed node ID and each element is the set of
	 * neighboring nodes.
	 **/
	public List<HashSet<Integer>> graph;
	/** Starting node number for BFS, default Java initialization is to node 0 **/
	public int start;

	public ShortesReach(int n, int edgeWeight) {
		this.EDGE_DISTANCE = edgeWeight;

		this.distance = new int[n];
		Arrays.fill(distance, -1);

		this.graph = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < n; i++) {
			this.graph.add(new HashSet<Integer>());
		}
	}
	
	public void buildGraph(int arr[][]) {
		for(int i=0;i<arr.length;i++) {
			int u = arr[i][0]-1;
			int v = arr[i][1]-1;
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
	}

	public void shortestReach(int s) {

		this.start = s;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		distance[start] = 0;

		// BFS from start
		while (queue.size() > 0) {
			int u = queue.remove();
			// for each unvisited neighbor of the current node
			for (int v : graph.get(u)) {
				// Add unvisited neighboring nodes to queue to check its neighbors at next level
				// of the search, set distance
				if (distance[v] == -1) {
					queue.add(v);
					distance[v] = distance[u] + EDGE_DISTANCE;
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}
	public static void main(String[] args) {
		int arr[][] = {{1,2},{1,5},{2,3},{3,4}};
		ShortesReach s = new ShortesReach(6,6);
		s.buildGraph(arr);
		s.shortestReach(0);
		
	}
}
