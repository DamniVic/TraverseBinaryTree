package com.damnivic;

import java.util.ArrayList;
import java.util.Iterator;

public class IT6 {
	public static final int NUM = 10;
	   ArrayList<Integer> lsta = new ArrayList<Integer>();
	   ArrayList<Integer> lstb = new ArrayList<Integer>();
	   boolean success;
	   public IT6(){
	      success = false;
	      for (int i = 0; i < NUM; i++){
	         lsta.add(i);
	         lstb.add(i);
	      }
	   }
	   ArrayList getB(){
	      while(success != true){
	         setNextB();
	      }
	      return lstb;
	   }
	   void setNextB(){ 
	      boolean flag =true;
	      for (int i=0; i < NUM; i++){
	         int f = getFrequency(i);
	         if(lstb.get(i) != f){
	            lstb.set(i, f);
	            flag = false;
	         }
	      }
	      success = flag;
	   }
	   int getFrequency(int value){
	      int count = 0;
	      for(int i = 0; i < NUM; i++){
	         if(lstb.get(i) == value)
	            count++;
	      }
	      return count;
	   }
	   private static void printGenericIterator(Iterator it){
		   while(it.hasNext()){
			   System.out.print(it.next()+",");
		   }
	   }
	   public static void main(String[] args) {
	      IT6 test = new IT6();
	      ArrayList<Integer> res = test.getB();
	      printGenericIterator(test.lsta.iterator());
	      System.out.println();
	      printGenericIterator(test.lstb.iterator());

	   }
}
