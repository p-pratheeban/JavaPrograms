package com.pratheeban.linklist;

class ListInsertionSortApp {
	public static void main(String[] args) {
		int size = 10;
		// create array of links
		Link[] linkArray = new Link[size];

		for (int j = 0; j < size; j++) // fill array with links
		{ // random number
			int n = (int) (java.lang.Math.random() * 99);
			Link newLink = new Link(n); // make link
			linkArray[j] = newLink; // put in array
		}
		// display array contents
		System.out.print("Unsorted array: ");
		for (int j = 0; j < size; j++)
			System.out.print(linkArray[j].dData + " ");
		System.out.println("");

		// create new list
		SortedList theSortedList = new SortedList(linkArray);

		for (int j = 0; j < size; j++) // links from list to array
			linkArray[j] = theSortedList.remove();

		// display array contents
		System.out.print("Sorted Array:   ");
		for (int j = 0; j < size; j++)
			System.out.print(linkArray[j].dData + " ");
		System.out.println("");
	} // end main()
} // end class ListInsertionSortApp