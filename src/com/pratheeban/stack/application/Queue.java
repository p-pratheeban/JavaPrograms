package com.pratheeban.stack.application;

public interface Queue
{
   public boolean isEmpty();
   public Object getFrontElement();
   public Object getRearElement();
   public void put(Object theObject);
   public Object remove();
}
