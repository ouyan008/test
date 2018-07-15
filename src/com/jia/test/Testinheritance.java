package com.jia.test;

import java.lang.reflect.Field;

public class Testinheritance extends MyBase {
	
//	private String name = "winnie";
	
	public static void main(String args[] ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		MyBase myBase = new MyBase();
       
		
		Testinheritance obj = new Testinheritance();
		 System.out.println(myBase.getName() == obj.getName());
//		Class objClass = obj.getClass();
//        Field f = objClass.getSuperclass().getDeclaredField("name");
//        f.setAccessible(true);
//        System.out.println(f.get(obj));
        System.out.println(obj.getName());
        
        
	}
 	

}


class MyBase {
	
	private   String name = new String("quinn");
	
	MyBase() {
		System.out.println("constructure   " + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}