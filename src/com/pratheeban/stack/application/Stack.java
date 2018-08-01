package com.pratheeban.stack.application;



//package dataStructures;

public interface Stack
{
   public boolean empty();
   public Object peek();
   public void push(Object theObject);
   public Object pop();
   public boolean isFull();
   public int size();
}
