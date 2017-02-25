package com.damnivic;

public class Test {
	public static void change(String str)
	{
		str="545";
	}
	public static boolean foo(char c)
	{
		System.out.print(c);
		return true;
	}
	public static void main(String[] args)
	{
		String str1=new String("grdegg");
		change(str1.toString());
		System.out.println(str1);
		String myStr = (String) null; // null can be type cast to String
		Integer myItr = (Integer) null; // it can also be type casted to Integer
		Double myDbl = (Double) null; // yes it's possible, no error
		System.out.println(myStr+myItr+myDbl);
		int i=0;
		for(foo('A');foo('B')&&i<2;foo('C'))
		{
			i++;
			foo('D');
		}
	} 
}
