package com.pratheeban.graph;

import java.util.LinkedList;
import java.util.List;

public class Node {
	private List<Node> adjacent;
	private String vertex;
	public boolean isVisited;

	public Node(String vertex) {
		this.vertex = vertex;
		adjacent = new LinkedList<>();
	}

	public void addAjacent(Node x) {
		adjacent.add(x);
	}

	public List<Node> getAdjacent() {
		return adjacent;
	}

	public String getVertex() {
		return vertex;
	}
	
	public String toString() {
		return vertex;
	}
}
