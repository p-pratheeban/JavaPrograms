package com.pratheeban.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.pratheeban.graph.Graph1;
import com.pratheeban.graph.Node;

public class PathBtwNode {

	public static void search(Graph1 g, Node start, Node end) {
		Queue<Node> q = new LinkedList<>();
		start.isVisited = true;
		q.add(start);
		Node u = null;
		while (!q.isEmpty()) {
			u = q.remove();
			System.out.print(u.getVertex() + "\t");
			if (u == end) {
				System.out.println("\nThe path is found between " + start.getVertex() + " and " + end.getVertex());
				break;
			}
			for (Node s : u.getAdjacent()) {
				if (!s.isVisited) {
					s.isVisited = true;
					q.add(s);
				}
			}

		}
		if (u != end) {
			System.out.println("\nThe path is not found between " + start.getVertex() + " and " + end.getVertex());

		}

	}

	public static void search1(Graph1 g, Node start, Node end) {
		Stack<Node> s = new Stack<>();
		start.isVisited = true;
		s.add(start);
		Node u = null;
		while (!s.isEmpty()) {
			u = s.pop();
			System.out.print(u.getVertex() + "\t");
			if (u == end) {
				System.out.println("\nThe path is found between " + start.getVertex() + " and " + end.getVertex());
				break;
			}
			for (Node v : u.getAdjacent()) {
				if (!v.isVisited) {
					v.isVisited = true;
					s.add(v);
				}
			}

		}
		if (u != end) {
			System.out.println("\nThe path is not found between " + start.getVertex() + " and " + end.getVertex());

		}

	}

	public static void main(String[] args) {
		Graph1 g = Graph1.createNewGraph();
		search(g, g.getNode(new Node("a")), g.getNode(new Node("e")));
		search(g, g.getNode(new Node("c")), g.getNode(new Node("e")));
		
		Graph1 g1 = Graph1.createNewGraph();
		search1(g1, g1.getNode(new Node("a")), g1.getNode(new Node("e")));
		search1(g1, g1.getNode(new Node("c")), g1.getNode(new Node("e")));

	}
}
