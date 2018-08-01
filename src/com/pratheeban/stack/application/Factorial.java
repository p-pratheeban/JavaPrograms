package com.pratheeban.stack.application;

import java.util.*;
class Factorial extends ArrayStack
{
    int n;
    long fact=1;
    int c;
    public Factorial()
    {
        Scanner sc=new Scanner(System.in); 
        System.out.print("Enter a number = ");  
        n=sc.nextInt();
        c=n;
    }
    public void findFactorial()
    {
        while(n>0)
        {
            push((Object)n);
            n--;
        }
        while(!empty())
        {
            long x=Long.parseLong(String.valueOf(pop()));
            fact=fact*x;
        }
    }
    public void printResult()
    {
        System.out.println(c+" Factorial = "+fact);   
    }
    public static void main(String args[])
    {
        Factorial f=new Factorial();
        f.findFactorial();
        f.printResult();
        
    }
}   