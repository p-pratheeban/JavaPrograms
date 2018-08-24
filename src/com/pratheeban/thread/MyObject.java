package com.pratheeban.thread;

public class MyObject {
	public synchronized void foo(String name) {
		try {
			System.out.println("Thread " + name + ".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".foo(): ending");
		} catch (InterruptedException exc) {
			System.out.println("Thread " + name + ": interrupted.");
		}
	}

	/*
	 * The static methods synchronize on the class lock. The two threads could not
	 * simultaneously execute synchronize static methods on the same class
	 */

	public static synchronized void bar(String name) {
		try {
			System.out.println("Thread " + name + ".bar(): starting");
			Thread.sleep(3000);
			System.out.println("Thread " + name + ".bar(): ending");
		} catch (InterruptedException exc) {
			System.out.println("Thread " + name + ": interrupted.");
		}
	}

	/*
	 * Like synchronize a method only one thread per instance of MyObject can
	 * execute the code within the synchronized block. That means if Thread1 and
	 * Thread2 have the same instance of MyObject, only one will be allowed to
	 * execute the code block at a time
	 */
	public void foo1(String name) {
		synchronized (this) {
			try {
				System.out.println("Thread " + name + ".foo(): starting");
				Thread.sleep(3000);
				System.out.println("Thread " + name + ".foo(): ending");
			} catch (InterruptedException exc) {
				System.out.println("Thread " + name + ": interrupted.");
			}
		}
	}
}
