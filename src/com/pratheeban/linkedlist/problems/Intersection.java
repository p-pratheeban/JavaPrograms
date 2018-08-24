package com.pratheeban.linkedlist.problems;

import com.pratheeban.linkedlist.ListNode;

public class Intersection {
	public static class Result {
		public ListNode tail;
		public int size;

		public Result(ListNode tail, int size) {
			this.tail = tail;
			this.size = size;
		}
	}

	public static Result getTailAndSize(ListNode list) {
		if (list == null)
			return null;

		int size = 1;
		ListNode current = list;
		while (current.next != null) {
			size++;
			current = current.next;
		}
		return new Result(current, size);
	}

	public static ListNode getKthNode(ListNode head, int k) {
		ListNode current = head;
		while (k > 0 && current != null) {
			current = current.next;
			k--;
		}
		return current;
	}

	public static ListNode findIntersection(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null)
			return null;

		/* Get tail and sizes. */
		Result result1 = getTailAndSize(list1);
		Result result2 = getTailAndSize(list2);

		/* If different tail nodes, then there's no intersection. */
		if (result1.tail != result2.tail) {
			return null;
		}

		/* Set pointers to the start of each linked list. */
		ListNode shorter = result1.size < result2.size ? list1 : list2;
		ListNode longer = result1.size < result2.size ? list2 : list1;

		/*
		 * Advance the pointer for the longer linked list by the difference in lengths.
		 */
		longer = getKthNode(longer, Math.abs(result1.size - result2.size));

		/* Move both pointers until you have a collision. */
		while (shorter != longer) {
			shorter = shorter.next;
			longer = longer.next;
		}

		/* Return either one. */
		return longer;
	}
	// Create a pointer that iterates through a list. When it's at the end
	// of the list, have it jump to the beginning of the other list. Create
	// 2 of these pointers, pointing to 2 different list heads. The pointers  
	// will collide at the merge point after 1 or 2 passes.

	//  Time Complexity: O(n + m)
	// Space Complexity: O(1)
	int FindMergeNode(ListNode headA, ListNode headB) {
		ListNode currentA = headA;
		ListNode currentB = headB;

	    //Do till the two nodes are the same
	    while(currentA != currentB){
	        //If you reached the end of one list start at the beginning of the other one
	        //currentA
	        if(currentA.next == null){
	            currentA = headB;
	        }else{
	            currentA = currentA.next;
	        }
	        //currentB
	        if(currentB.next == null){
	            currentB = headA;
	        }else{
	            currentB = currentB.next;
	        }
	    }
	    return currentB.data;
	}

}
