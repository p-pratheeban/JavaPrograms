package com.pratheeban.stack.application;

import java.util.*;

import com.pratheeban.queue.ArrayQueue;
class Palindrome extends ArrayStack
{
	static String s,c="";
        static ArrayQueue aq=new ArrayQueue();

	public Palindrome()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a String : ");
		s=sc.nextLine();
		filter();
		c=c.toUpperCase();
		System.out.println("c: "+c);
		for(int i=0;i<c.length();i++)
		{
			push((Object)c.charAt(i));
			aq.put((Object)c.charAt(i));
		}
	}
	public void filter()
	{
    	for(int i=0;i<s.length();i++)
    	{
        	char x=s.charAt(i);
    	    if(x>=48&&x<=57 || x>=65&&x<=90 || x>=97&&x<=122)
    	    c+=x;
	    }
	}
	public void palindrome()
	{
    	for(int i=0;i<c.length();i++)
		{
    		if(pop()==aq.getFrontElement())
			    aq.remove();
		    else break;
		}
	}
	public void getResult()
	{
    	if(empty())System.out.println("This word is palindrome");
		else System.out.println("This word is not palindrome");
	}
	
	public static void main(String a[])
	{
		Palindrome p=new Palindrome();
		p.palindrome();
		p.getResult();
	}
}
