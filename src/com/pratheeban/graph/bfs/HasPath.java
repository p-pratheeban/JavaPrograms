package com.pratheeban.graph.bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Creating an undirected graph. Finding path from source to destination in
 * graph using DFS and BFS
 * 
 * source : node we are currently at or starting with destination : node that we
 * want to visit
 * 
 *
 */
public class HasPath {

	// HashMap will store graph information
	private Map<Integer, Node> nodeLookup = new HashMap<>();

	// First requirement is Node class
	public static class Node {

		private final int id;
		List<Node> adjacentNodes = new LinkedList<>();

		private Node(int id) {
			this.id = id;
		}

		@Override
		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(id + " AdjacentNodes => ");
			Iterator<Node> iterator = adjacentNodes.iterator();
			while (iterator.hasNext()) {
				sb.append(iterator.next().id);
				if (iterator.hasNext()) {
					sb.append(",");
				}
			}
			sb.append(" || ");

			return sb.toString();
		}
	}

	// get node from HashMap
	private Node getNode(int id) {
		return nodeLookup.get(id);
	}

	// Add Edge : make source and destination adjacent & vice Versa
	public void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);

		// Adding edge : creating adjacent relation both sides
		s.adjacentNodes.add(d);
		d.adjacentNodes.add(s);
	}

	// DFS traversal
	public boolean hasPathBFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		return hasPathBFS(s, d);
	}

	// source : node we are currently at or starting with
	private boolean hasPathBFS(Node source, Node destination) {
		// Reached at source again : found cycle
		Queue<Node> nextToVisit = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		// Add to visited list before going to visit
		nextToVisit.add(source);

		// Visit adjacent nodes
		while (!nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();
			System.out.print(node.id + " ");

			if (node.id == destination.id) {
				return true;
			}
			if (visited.contains(node.id))
				continue;
			visited.add(node.id);
			nextToVisit.addAll(node.adjacentNodes);
		}

		return false;
	}

	// Create Graph : nodes and edges
	private void createGraph() {

		// Create graph Nodes
		this.nodeLookup.put(1, new Node(1));
		this.nodeLookup.put(3, new Node(3));
		this.nodeLookup.put(6, new Node(6));
		this.nodeLookup.put(8, new Node(8));
		this.nodeLookup.put(11, new Node(11));
		this.nodeLookup.put(13, new Node(13));
		this.nodeLookup.put(19, new Node(19));
		this.nodeLookup.put(7, new Node(7));
		this.nodeLookup.put(21, new Node(21));

		// Add all graph edges
		this.addEdge(1, 3);
		this.addEdge(3, 6);
		this.addEdge(3, 11);
		this.addEdge(3, 19);
		this.addEdge(6, 8);
		this.addEdge(8, 13);
		this.addEdge(11, 13);
		this.addEdge(13, 7);
		this.addEdge(7, 19);
		this.addEdge(7, 21);

		// Creating disconnected graph
		this.nodeLookup.put(22, new Node(22));
		this.nodeLookup.put(23, new Node(23));
		this.addEdge(22, 23);
	}

	public static void main(String[] args) {

		HasPath graphExample = new HasPath();
		// Creating graph shown in example
		graphExample.createGraph();

		System.out.println("Printing Graph");
		System.out.println(graphExample.nodeLookup);

		// Traversing with DFS
		boolean hasPathDFS = graphExample.hasPathBFS(3, 21);
		System.out.println(hasPathDFS ? "Path Exist" : "Path does not exist.");

	}

}