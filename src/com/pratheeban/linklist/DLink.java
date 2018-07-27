package com.pratheeban.linklist;

class DLink {
	public long dData; // data item
	public DLink next; // next link in list
	public DLink previous; // previous link in list
	// -------------------------------------------------------------

	public DLink(long d) // constructor
	{
		dData = d;
	}

	// -------------------------------------------------------------
	public void displayLink() // display this link
	{
		System.out.print(dData + " ");
	}
	// -------------------------------------------------------------
}
