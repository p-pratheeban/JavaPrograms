package com.pratheeban.stack;

class ChangeArrayLength
{
	public static Object[] changeLength1D(Object element[],int siz)
	{
		Object element1[]=new Object[siz];
		for(int i=0;i<siz/2;i++)
		{
			element1[i]=element[i];
		}
		return  element1;
	}
}
	