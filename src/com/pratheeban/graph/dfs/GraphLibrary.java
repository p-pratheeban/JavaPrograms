package com.pratheeban.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.pratheeban.graph.Graph1;
import com.pratheeban.graph.Node;

public class GraphLibrary {
	static int getNeighbour(int cities[][], int j, int n, List<Integer> visited) {
		for (int i = 0; i < n; i++) {
			if (cities[i][0] == j && !visited.contains(cities[i][1])) {
				return cities[i][1];
			} else if (cities[i][1] == j && !visited.contains(cities[i][0])) {
				return cities[i][0];
			}
		}
		return -1;
	}

	// Complete the roadsAndLibraries function below.
	static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
		int r = cities.length;

		List<Integer> visited = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		long min_cost = 0;
		int con_cities = 0;
		int con_com = 0;
		int ne;
		if (c_lib * n <= (n - 1) * c_road) {
			return c_lib * n;
		} else {
			for (int i = 1; i <= n; i++) {
				if (!visited.contains(i)) {
					s.add(i);
					visited.add(i);
					while (!s.isEmpty()) {

						int c = s.pop();

						while ((ne = getNeighbour(cities, c, r, visited)) != -1 && !visited.contains(ne)) {
							s.push(ne);
							visited.add(ne);
							con_cities++;
						}
						min_cost += con_cities * c_road;
						con_cities = 0;

					}
					con_com++;
				}
			}
			min_cost += con_com * c_lib;
		}
		return min_cost;
	}

	static long roadsAndLibraries1(int n, int c_lib, int c_road, int[][] cities) {
		Graph1 g = buildGraph(cities, n);
		List<Node> l = new ArrayList<>();
		long min_cost = 0;
		int con_cities = 0;
		int con_com = 0;
		if (c_lib * n <= (n - 1) * c_road) {
			return c_lib * n;
		} else {
			for (Node node : g.getNodes()) {
				if (!node.isVisited) {
					doDFS(node, l);
					if (!l.isEmpty())
						con_cities = l.size() - 1;
					l.clear();
					min_cost += con_cities * c_road;
					con_cities = 0;
					con_com++;
				}
			}
		}
		min_cost += con_com * c_lib;
		return min_cost;

	}

	public static Graph1 buildGraph(int cities[][], int n) {
		int roads = cities.length;
		Graph1 g = new Graph1();

		for (int i = 1; i <= n; i++) {
			Node node = new Node("" + i);
			g.addVertex(node);
		}
		for (int i = 0; i < roads; i++) {
			int u = cities[i][0];
			int v = cities[i][1];
			Node uu = g.getNode(new Node("" + u));
			Node vv = g.getNode(new Node("" + v));
			uu.addAjacent(vv);
			vv.addAjacent(uu);
		}
		return g;
	}
	static long roadsAndLibraries2(int n, int c_lib, int c_road, int[][] cities) {
		Map<Integer, List<Integer>> g = buildGraph(cities);
		List<Integer> l = new ArrayList<>();
		long min_cost = 0;
		int con_cities = 0;
		int con_com = 0;
		boolean avisited[] = new boolean[n + 1];
        Arrays.fill(avisited, false);
		if (c_lib * n <= (n - 1) * c_road) {
			return c_lib * n;
		} else {
			for (int i=1;i<=n;i++) {
				if (!avisited[i]) {
					dfs(i, g,avisited,l);
					if (!l.isEmpty())
						con_cities = l.size() - 1;
					l.clear();
					min_cost += con_cities * c_road;
					con_cities = 0;
					con_com++;
				}
			}
		}
		min_cost += con_com * c_lib;
		return min_cost;

	}
	private static void dfs(int node, Map<Integer, List<Integer>> graph, boolean visited[], List<Integer> ccNodes) {
        visited[node] = true;
        ccNodes.add(node);

        List<Integer> nodes = graph.get(node);
        if (nodes != null) {
            for (Integer v : nodes) {
                if (!visited[v]) {
                    dfs(v, graph, visited, ccNodes);
                }
            }
        }
    }
	public static Map<Integer, List<Integer>> buildGraph(int cities[][]) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int j = 0; j < cities.length; j++) {
            int u = cities[j][0];
            int v = cities[j][1];

            List<Integer> nodes = graph.get(u);
            if (nodes == null) {
                nodes = new ArrayList<>();
            }
            nodes.add(v);
            graph.put(u, nodes);

            nodes = graph.get(v);
            if (nodes == null) {
                nodes = new ArrayList<>();
            }
            nodes.add(u);
            graph.put(v, nodes);
        }
        return graph;
	}

	public static void doDFS(Node node, List<Node> list) {
		for (Node n : node.getAdjacent()) {
			if (!n.isVisited) {
				n.isVisited = true;
				list.add(n);
				doDFS(n, list);
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * int n = 3; int c_lib = 2; int c_road = 1; int cities[][] = { { 1, 2 }, { 3, 1
		 * }, { 2, 3 } }; System.out.println(roadsAndLibraries(n, c_lib, c_road,
		 * cities));
		 */

		int n1 = 5;
		int c_lib1 = 6;
		int c_road1 = 1;
		int cities1[][] = { { 1, 2 }, { 1, 3 }, { 1, 4 } };
		System.out.println(roadsAndLibraries(n1, c_lib1, c_road1, cities1));
		System.out.println(roadsAndLibraries1(n1, c_lib1, c_road1, cities1));
		System.out.println(roadsAndLibraries2(n1, c_lib1, c_road1, cities1));

		int n = 9;
		int c_lib = 91;
		int c_road = 84;
		int cities[][] = { { 8, 2 }, { 2, 9 } };
		System.out.println(roadsAndLibraries(n, c_lib, c_road, cities));
		System.out.println(roadsAndLibraries1(n, c_lib, c_road, cities));
		System.out.println(roadsAndLibraries2(n, c_lib, c_road, cities));

	}

}
