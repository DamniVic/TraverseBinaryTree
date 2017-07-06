package com.damnivic;

import java.awt.SystemColor;

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
	public static int bc=1;
	
	public static void main(String[] args)
	{
		String str1=new String("grdegg");
		System.out.println(str1.toString());
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
		System.out.println();
		Integer a=new Integer(28);
		Integer b=new Integer(28);
		System.out.println(a==b);
		System.out.println(a.equals(b));
		value c=new value();
		value d=new value();
		c.i=d.i=23;
		System.out.println(c==d);
		System.out.println(c.equals(d));
		System.out.println(bc);
		{
			int io=1;
		}
		{
			int io=1;
		}
		String str= null;
		System.out.println(str);
		int num = 0;
		double begin=System.currentTimeMillis();
		System.out.println(begin);
		for(i=0;i<10000;i++){
//			num +=i;
		}
		double end=System.currentTimeMillis();
		System.out.println(end);
		System.out.println(num);
		System.out.println(end-begin);
		int songIndex=2;
        songIndex=songIndex++*3;
        songIndex+=1;
        System.out.println("songIndex:"+songIndex);
        System.out.println("songIndex:"+songIndex);
	} 
	
	static class value{
		int i;
		value(){bc++;}
	}
}
