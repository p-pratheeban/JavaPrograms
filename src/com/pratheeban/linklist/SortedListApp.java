package com.pratheeban.linklist;

class SortedListApp {
	public static void main(String[] args) { // create new list
		SortedList theSortedList = new SortedList();
		theSortedList.insert(20); // insert 2 items
		theSortedList.insert(40);

		theSortedList.displayList(); // display list

		theSortedList.insert(10); // insert 3 more items
		theSortedList.insert(30);
		theSortedList.insert(50);

		theSortedList.displayList(); // display list

		theSortedList.remove(); // remove an item

		theSortedList.displayList(); // display list
	} // end main()
} // end class SortedListApp
