package com.jia.test;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double d = 1.0;
		if (d instanceof Number) 
		  d=	d++;
		boolean condition1 = (d ==2) ? true :false;
		if(condition1)
			System.out.println("Perform action1");
		double e = 1.0;
		if ((Double) e instanceof Double | d++ == e++)
			d += d;
		boolean condition2 = (d>2) ? true: false;
		if(condition2)
			System.out.println("Perform action 2");
		boolean condition3 = condition1 ^ condition2;
		if(condition3)
			
			System.out.println("Perform action 3");
		
		Integer before = new Integer(25);
		Integer after = ++before == 26?5: new Integer(10);
		System.out.println(after.intValue()-before.intValue());
		
		StringBuilder sb = new StringBuilder("buffering");
		sb.replace(2, 7 ,"BUFFER");
		sb.delete(2,  4);
		String s = sb.substring(1, 5);
		System.out.println(s);
		

		int x = 0, y = 4, z = 5;
		if (x>0)
			if (y<3)
				System.out.println("One");
			else if (y < 4)
				System.out.println("Two");
			else if ( z >5 )
				System.out.println("Three");
			else
				System.out.println("Four");
		
		System.out.println(args[1] + args[2]);
		
		
	}

}
