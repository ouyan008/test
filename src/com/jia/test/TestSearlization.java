package com.jia.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class TestSearlization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B b =  new B();
		
		Date date = new Date();
	    
		System.out.println(new Date());
		System.out.println(LocalTime.now());
		System.out.println(LocalDate.now());
		
		try (OutputStream os = new FileOutputStream("C:/Users/ouyan/Desktop/y.txt"); ObjectOutputStream oos = new ObjectOutputStream(os) ) {
			
			oos.writeObject(b);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    try (InputStream is = new FileInputStream("C:/Users/ouyan/Desktop/y.txt"); ObjectInputStream iis = new ObjectInputStream(is)) {
	    	
	     B bb;
		try {
			bb = (B) iis.readObject();
			System.out.println("b:= " + bb.a);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
	    	
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


class A  {
	
    int a = 1;
	
	A() {
		System.out.println("a = " + a);
	}
	
}

class B extends A implements Serializable {
	
	
	
}