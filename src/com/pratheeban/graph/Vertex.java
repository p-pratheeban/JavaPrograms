package com.pratheeban.graph;

public class Vertex {
	public char label; // label (e.g. ‘A’)
	public boolean wasVisited;
	public int id;

	public Vertex(char lab) // constructor
	{
		label = lab;
		wasVisited = false;
	}
	public Vertex(char lab, int id) // constructor
	{
		label = lab;
		this.id = id;
	}
} // end class Vertex
