package com.pratheeban.stack.application;

import java.util.*;
//import java.lang.*;
public class InToPost
{
	ArrayStack theStack=new ArrayStack();
	String input ="";// "1+2*4/8-7+6/3";
	String output="";
	
	public InToPost()
	{
		System.out.println("Enter the equation :");
		Scanner in=new Scanner(System.in);
		input=input+in.next();
	}

	void convert()
	{
		for (int j = 0; j < input.length(); j++)
		{
			char ch = input.charAt(j);
			switch (ch)
			{
				case '+': 
				case '-':gotOper(ch, 1); 
						break; 
				case '*': 
				case '/':gotOper(ch, 2);
						break; 
				case '(':theStack.push(ch); 
						break;
				case ')':gotParen(ch);
						break;
				default: output = output + ch;
						break;
			}
		}
		while (!theStack.empty())
		{
			output = output + theStack.pop();
		}
		System.out.println("\n\nInput is " + input );
		System.out.println("Postfix is " + output );
	}


	public void gotOper(char opCurrent, int precCurrentOp)
	{
		while(!theStack.empty())
		{
			char opStackTop = String.valueOf(theStack.pop()).charAt(0);
			if (opStackTop == '(')
			{
				theStack.push(opStackTop);
				break;
			}
			else
			{
				int precStackTop;
				if (opStackTop == '+' || opStackTop == '-')
					precStackTop = 1;
				else
					precStackTop = 2;
				if (precStackTop < precCurrentOp)
				{ 
					theStack.push(opStackTop); 
					break;
				}
				else 
					output = output + opStackTop; 
			}
		}
		theStack.push(opCurrent);
	}

	public void gotParen(char ch)
	{ 
		while (!theStack.empty())
		{
			char chx = String.valueOf(theStack.pop()).charAt(0);
			if (chx == '(') 
				break; 
			else
				output = output + chx; 
		}
	}
	
	void findValue()
	{
		theStack=new ArrayStack();
		for (int j = 0; j < output.length(); j++)
		{
			char ch = output.charAt(j);
			switch (ch)
			{
				case '+': 
				case '-':
				case '*': 
				case '/':calculate(ch);
						break; 
				default: theStack.push(ch);
						break;
			}
		}
		System.out.println("The value of the entered equation is "+theStack.pop());
	}
	void calculate(char ch)
	{
		double temp=Double.parseDouble(String.valueOf(theStack.pop()));
		double StactTopVal=Double.parseDouble(String.valueOf(theStack.pop()));
		switch (ch)
		{
			case '+': StactTopVal=StactTopVal+temp;break; 
			case '-': StactTopVal=StactTopVal-temp;break; 
			case '*': StactTopVal=StactTopVal*temp;break; 
			case '/': StactTopVal=StactTopVal/temp;break;
		}
		theStack.push(StactTopVal);
	}
	public static void main(String[] args)
	{
		InToPost theTrans = new InToPost();
		theTrans.convert(); 
		theTrans.findValue();
	}
}
