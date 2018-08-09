package com.pratheeban.number;

/**
 * Check whether given number is prime or not
 * 
 * @author Pratheepan
 *
 */
class PrimeNumber {
	/*
	 * isPrime(n) that accepts non integer number and return true if number is
	 * prime otherwise return false
	 */
	public boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public void printMessage(int n) {
		if (isPrime(n)) {
			System.out.println(n + " is a prime Number");
		} else {
			System.out.println(n + " is not a prime Number");
		}
	}

	public static void main(String args[]) {

		PrimeNumber primeNumber = new PrimeNumber();
		primeNumber.printMessage(6);
		primeNumber.printMessage(13);
	}
}
