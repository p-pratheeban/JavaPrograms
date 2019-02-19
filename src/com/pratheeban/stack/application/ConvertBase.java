package com.pratheeban.stack.application;

import java.util.*;

class ConvertBase extends ArrayStack {
	int n;
	int b;

	public ConvertBase() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the decimal number : ");
		n = sc.nextInt();
		System.out.print("Enter the base number : ");
		b = sc.nextInt();
	}

	public void convertBase() {
		while (n > 0) {
			Object ele;
			ele = n % b;
			if (ele.equals(10))
				ele = 'A';
			else if (ele.equals(11))
				ele = 'B';
			else if (ele.equals(12))
				ele = 'C';
			else if (ele.equals(13))
				ele = 'D';
			else if (ele.equals(14))
				ele = 'E';
			else if (ele.equals(15))
				ele = 'F';
			else
				ele = ele;
			System.out.println(ele);
			push(ele);
			n = n / b;
		}
	}

	public void printOut() {
		System.out.println("Base " + b + " Formate ");
		while (!empty())
			System.out.print(pop());
	}

	public static void main(String args[]) {
		ConvertBase cb = new ConvertBase();
		cb.convertBase();
		cb.printOut();
		System.out.println();
	}
}