package com.pratheeban.linklist;

class Link {
	public int iData; // data item
	public double dData; // data item
	public long lData; // data item

	public Link next; // next link in list
	// -------------------------------------------------------------

	public Link(int id, double dd) // constructor
	{
		iData = id; // initialize data
		dData = dd; // ('next' is automatically
	} // set to null)
	// -------------------------------------------------------------
	

	public Link(long dd) // constructor
	{
		lData = dd; // ('next' is automatically
	} // set to null)
	// -------------------------------------------------------------

	public void displayLink() // display ourself
	{
		System.out.print("{" + iData + ", " + dData + "} ");
	}
}
