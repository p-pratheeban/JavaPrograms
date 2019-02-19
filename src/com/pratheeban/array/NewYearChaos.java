package com.pratheeban.array;

import java.util.Arrays;

public class NewYearChaos {
	
	static void minimumBribes(int[] q) {

		int bribe = 0;
		int n = q.length;
		boolean chaotic = false;
		for (int i = 0; i < n; i++) {
			if (q[i] - (i + 1) > 2) {
				chaotic = true;
				break;
			}
			for (int j = Math.max(0, q[i] - 2); j < i; j++)
				if (q[j] > q[i])
					bribe++;
		}
		if (chaotic)
			System.out.println("Too chaotic");
		else
			System.out.println(bribe);
	}
	
	static void minimumBribes1(int[] A) 
	{
	    int n = A.length;
	    int cnt = 0;
	    for(int i = n - 1; i >= 0; i--)
	    {
	        if(A[i] != (i + 1))
	        {
	            if(((i - 1) >= 0) && A[i - 1] == (i + 1))
	            {
	                cnt++;
	                A[i-1]=A[i];
	                A[i]=i+1;
	            }
	            else if(((i - 2) >= 0) && A[i - 2] == (i + 1))
	            {
	                cnt += 2;
	                A[i - 2] = A[i - 1];
	                A[i - 1] = A[i];
	                A[i] = i + 1;
	            }
	            else
	            {
	    			System.out.println("Too chaotic");
	                break;
	            }
	        }      
	    }
	    System.out.println(cnt);
	}

	public static void main(String[] args) {
		int[] q = { 2, 1, 5, 3, 4 };
		minimumBribes(q);
		int[] q1 = { 2, 5, 1, 3, 4 };
		minimumBribes(q1);
		minimumBribes1(q);
		System.out.println(Arrays.toString(q));

	}
}
