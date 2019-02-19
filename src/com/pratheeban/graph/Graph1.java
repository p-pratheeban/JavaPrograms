 package com.pratheeban.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph1 {

	private List<Node> vertex;

	public Graph1() {
		vertex = new ArrayList<>();
	}

	public void addVertex(Node x) {
		vertex.add(x);
	}

	public List<Node> getNodes() {
		return vertex;
	}

	public Node getNode(Node x) {

		for (Node v : vertex) {
			if (x.getVertex().equals(v.getVertex()))
				return v;
		}
		return null;

	}
	
	

	public static Graph1 createNewGraph() {
		Graph1 g = new Graph1();

		Node A = new Node("a");
		Node B = new Node("b");
		Node C = new Node("c");
		Node D = new Node("d");

		A.addAjacent(B);
		A.addAjacent(C);
		A.addAjacent(D);
		Node E = new Node("e");

		D.addAjacent(E);
		Node F = new Node("f");

		E.addAjacent(F);

		g.addVertex(A);
		g.addVertex(B);
		g.addVertex(C);
		g.addVertex(D);
		g.addVertex(E);
		g.addVertex(F);

		return g;
	}

	public static Graph1 buildGraph() {
		Graph1 g = new Graph1();

		Node A = new Node("a");
		Node B = new Node("b");
		Node C = new Node("c");
		Node D = new Node("d");
		Node E = new Node("e");
		Node F = new Node("f");
		Node G = new Node("g");
		Node H = new Node("h");
		A.addAjacent(E);
		B.addAjacent(A);
		B.addAjacent(E);
		B.addAjacent(H);
		C.addAjacent(A);
		D.addAjacent(G);
		F.addAjacent(C);
		F.addAjacent(B);
		F.addAjacent(A);
		

		g.addVertex(A);
		g.addVertex(B);
		g.addVertex(C);
		g.addVertex(D);
		g.addVertex(E);
		g.addVertex(F);
		g.addVertex(G);
		g.addVertex(H);

		return g;
	}
}
