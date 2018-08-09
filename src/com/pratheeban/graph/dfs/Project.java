package com.pratheeban.graph.dfs;

import java.util.Iterator;
import java.util.Stack;

import com.pratheeban.graph.Graph1;
import com.pratheeban.graph.Node;

public class Project {

	public static Stack<Node> oderProjects(Graph1 g) {
		Stack<Node> projects = new Stack<>();
		for (Node vertex : g.getNodes()) {
			if (!vertex.isVisited) {
				vertex.isVisited = true;
				projects.add(vertex);
				doDFS(vertex, projects);
			}
		}
		return projects;
	}

	public static void doDFS(Node d, Stack<Node> projects) {
		for (Node n : d.getAdjacent()) {
			if (!n.isVisited) {
				n.isVisited = true;
				projects.add(n);
				doDFS(n, projects);
			}
		}
	}

	public static void main(String[] args) {
		Graph1 g = Graph1.buildGraph();
		Stack<Node> projects = oderProjects(g);
		while (!projects.isEmpty()) {
			System.out.print(projects.pop() + "\t");

		}
	}
}
