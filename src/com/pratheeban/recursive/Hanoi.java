package com.pratheeban.recursive;

public class Hanoi {
	public static void move(int n, char from, char to, char aux) {

		if (n == 1) {
			System.out.println("Move Disk " + n + " " + from + " " + to);
			return;
		}
		move(n - 1, from, aux, to);
		System.out.println("Move Disk " + n + " " + from + " " + to);
		move(n - 1, aux, to, from);
	}

	public static void main(String[] args) {
		move(3, 'S', 'D', 'A');
	}
}
/*
move(3,S,D,A);
	move(2,S,A,D)
		move(1,S,D,A)=>Move Disk 1 S D
		Move Disk 2 S A
		move(1,D,A,S) =>Move Disk 1 D A
	Move Disk 3 S D
	move(2,A,D,S)
		move(1,A,S,D)=>Move Disk 1 A S
		Move Disk 2 A D
		move(1,S,D,A)=>Move Disk 1 S D

*/