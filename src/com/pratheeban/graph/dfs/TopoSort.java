package com.pratheeban.graph.dfs;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

import com.pratheeban.graph.Graph;

public class TopoSort {
	public static void topSort(Graph g) {
		Stack<Integer> s = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for(int i=0; i<g.nVerts;i++) {
			if(!visited.contains(i)) {
				topSortUtil(g, s, visited, i);
			}
		}
		while(!s.isEmpty()) {
			g.displayVertex(s.pop());
		}
	}
	
	
	public static void topSortUtil(Graph g, Stack<Integer> s, Set<Integer> visited, Integer v) {
		visited.add(v);
		for(Integer v1:g.getAdjacentVertexs(v)) {
			if(visited.contains(v1)) continue;
			topSortUtil(g, s, visited, v1);
		}
		s.push(v);
	}
	
	public static void main(String[] args) {
		Graph g = Graph.createDirectGraph();
		System.out.println("Topological Sort Oder");//BAEDGCFH
		topSort(g);
		System.out.println();
		PriorityQueue<Integer> p =new PriorityQueue<>();
		p.add(45);
		p.add(34);
		p.add(23);
		while(!p.isEmpty()) {
		System.out.print(p.remove()+"\t");
		}
	}
}
