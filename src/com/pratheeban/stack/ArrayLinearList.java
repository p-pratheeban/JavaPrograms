package com.pratheeban.stack;

class ArrayLinearList implements LinearList
{
    protected Object[] element;
    protected int size;
    ArrayLinearList(int initialCapacity)
    {
        if(initialCapacity<1)
        throw new IllegalArgumentException("initial capacity must be >=1");
        element=new Object[initialCapacity];
    }
    public ArrayLinearList()
    {
        this(10);
    }
    public boolean isEmpty()
    {
        return(size==0);
    }
    public int size()
    {
        return size;
    }
    void checkIndex(int index)
    {
        if (index < 0 || index >= size)
        throw new IndexOutOfBoundsException("index = " + index + "  size =" + size);
    }
    public Object get(int index)
    {
        checkIndex(index);
        return element[index];
    }
    public int indexOf(Object theElement)
    {
        for (int i = 0; i < size; i++)
            if (element[i].equals(theElement))
                return i;
        return -1;
    }    
    public Object remove(int index)
    {
        checkIndex(index);
        Object removedElement = element[index];
        for (int i = index + 1; i < size; i++)
            element[i-1] = element[i];
        element[--size] = null;   
        return removedElement;
    }
    public void add(int index, Object theElement)
    {
        if (index < 0 || index > size)
        throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);
        if (size == element.length)
        //element = ChangeArrayLength.changeLength1D(element, 2*size);
            element = changeLength1D(element, 2*size);
        for (int i = size - 1; i >= index; i--)
            element[i + 1] = element[i];
        element[index] = theElement;
        size++;
    }
    public Object[] changeLength1D(Object element[],int siz)
    {
        Object element1[]=new Object[siz];
        for(int i=0;i<siz/2;i++)
        {
            element1[i]=element[i];
        }
        return  element1;
    }
       
}
