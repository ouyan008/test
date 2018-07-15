package com.jia.test;

import java.io.IOException;
import java.util.Calendar;

public class TestIKM {

	public static void main(String[] args) {
	
//       int a = 0, b = 0;
//       b = a + 1;
//       System.out.println("a = " + a + "b = " + b );
//       b = a++;
//       System.out.println("a = " + a + "b = " + b );
//       b = ++a;
//       System.out.println("a = " + a + "b = " + b );
//    
//       Calendar cal = Calendar.getInstance();
//       cal.set(2000, Calendar.AUGUST, 30);
//       cal.roll(Calendar.MONTH, 7);
//       System.out.println(""  + cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR));
//       cal.add(Calendar.MONTH, 11);
//       System.out.println(""  + cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR));
//       
//       
//       try {
//    	   throw new IllegalArgumentException();
//    	   
//       }
//         finally {
//        	 System.out.println("ccc");
//         }
		
		
//	meth(args);
		
		int y = 127;
		switch(y) {
		default: System.out.println("129 ");
		case 127:  System.out.println("127 ");
		case 128:  System.out.println("128 ");
		}
		
		long myLong = 500L;
		
		
		
       
}
	
	public static void meth(String[] arg) {
		System.out.println(arg);
		System.out.println(arg[1]);
	}
	
}


interface m {
	public int ss () throws IOException ;
}
