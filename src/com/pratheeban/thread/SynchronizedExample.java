package com.pratheeban.thread;

public class SynchronizedExample {
	public static void main(String[] args) {
		try {
			/*
			 * If two difference instance of MyObject then both threads will be allowed to
			 * call foo()
			 */
			MyObject obj1 = new MyObject();
			MyObject obj2 = new MyObject();
			MyClass thread1 = new MyClass(obj1, "1");
			MyClass thread2 = new MyClass(obj2, "2");

			thread1.start();
			thread2.start();

			Thread.sleep(3000 * 4);
		} catch (InterruptedException exc) {
			System.out.println("Program Interrupted.");
		}
		System.out.println("Program terminating.");

		try {
			/*
			 * If same reference of MyObject then only one thread will be allowed to call
			 * foo()
			 */
			MyObject obj2 = new MyObject();
			MyClass thread1 = new MyClass(obj2, "1");
			MyClass thread2 = new MyClass(obj2, "2");

			thread1.start();
			thread2.start();

			Thread.sleep(3000 * 4);
		} catch (InterruptedException exc) {
			System.out.println("Program Interrupted.");
		}
		System.out.println("Program terminating.");

	}
}
