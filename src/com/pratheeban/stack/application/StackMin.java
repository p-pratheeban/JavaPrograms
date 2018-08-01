package com.pratheeban.stack.application;

import java.util.ArrayList;
import java.util.List;

class GenStack<T> {
	private List<T> stack;
	int top;

	public GenStack() {
		stack = new ArrayList<>();
		top = -1;
	}

	public void push(T elem) {
		stack.add(++top, elem);
	}

	public T pop() {
		T ele = stack.remove(top--);
		return ele;
	}

	public T peek() {
		return stack.get(top);
	}
	public boolean isEmpty() {
		return top==-1;
	}
}

class NodeMin {
	public int min;
	public int val;

	NodeMin(int val, int min) {
		this.min = min;
		this.val = val;
	}
}

public class StackMin extends GenStack<NodeMin> {

	public void push(int val) {
		int min = Math.min(getMin(), val);

		NodeMin node = new NodeMin(val, min);
		push(node);
	}
	
	public int getMin() {
		if (this.isEmpty()) {
    		return Integer.MAX_VALUE;
    	} else {
		return peek().min;
    	}
	}

	public static void main(String[] args) {
		StackMin stack = new StackMin();
		StackMin2 stack2 = new StackMin2();

		int[] array = { 2, 1, 3, 1 };
		for (int value : array) {
			stack.push(value);
			stack2.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < array.length; i++) {
			System.out.println("Popped " + stack.pop().val +"\t"+stack2.pop());
			System.out.println("New min is " + stack.getMin()+"\t"+stack2.min());
		}
	}
}
class StackMin2 extends GenStack<Integer> {
	GenStack<Integer> s2;
	
	public StackMin2() {
		s2 = new GenStack<Integer>();		
	}
	
	public void push(int value){
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();			
		}
		return value;
	}
	
	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}

