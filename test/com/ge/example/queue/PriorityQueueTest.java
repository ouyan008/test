
package com.ge.example.queue;

import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {
	
	
	String inValueHigh = "High";
	String inValueHigh_med = "High_Med";
	String inValueMed_low  = "Med_Low";
	String inValueMed = "Med";
	String inValueLow = "Low";
	

	
	@Test
	public void testReorder() {
		
		
		PriorityQueueImpl<String> queue = new PriorityQueueImpl<String>();
		
		
		queue.add(inValueMed_low, 8);
		queue.add(inValueMed, 5);
		queue.add(inValueHigh, 1);
		queue.add(inValueHigh_med, 3);		
		queue.add(inValueLow, 10);
		
		Assert.assertFalse("Queue should not be empty.", queue.isEmpty());
		
		String s = queue.getNext();
		System.out.println(s);
		Assert.assertSame("Expected High priority value first.", inValueHigh, s);
		s = queue.getNext();
		Assert.assertSame("Expected High priority value first.", inValueHigh_med, s);
		s = queue.getNext();
		Assert.assertSame("Expected Med priority value second.", inValueMed, s);
		s = queue.getNext();
		Assert.assertSame("Expected High priority value first.", inValueMed_low, s);
		s = queue.getNext();
		Assert.assertSame("Expected Low priority value third.", inValueLow, s);
	}
	
	@Test
	public void testReorder1() {
		
		
		
		PriorityQueueImpl3<String> queue = new PriorityQueueImpl3<String>();
		
		
//		queue.add(inValueHigh, 1);			
//		queue.add(inValueHigh_med, 3);	
//		queue.add(inValueMed, 5);
//		queue.add(inValueLow, 10);
//		queue.add(inValueMed_low, 8);
		
		
		queue.add(inValueLow, 10);
		queue.add(inValueMed, 5);
		queue.add(inValueHigh, 1);			
		queue.add(inValueHigh_med, 3);	
		
		;
		queue.add(inValueMed_low, 8);
		
		Assert.assertFalse("Queue should not be empty.", queue.isEmpty());
		
		String s ;
		s = queue.getNext();
		System.out.println("s1" + s);
		Assert.assertSame("Expected High priority value first.", inValueHigh, s);
		s = queue.getNext();
		System.out.println("s2" + s);
		Assert.assertSame("Expected High priority value first.", inValueHigh_med, s);
		s = queue.getNext();
		System.out.println("s3" +s);
		Assert.assertSame("Expected Med priority value second.", inValueMed, s);
		s = queue.getNext();
		System.out.println("s4" + s);
		Assert.assertSame("Expected High priority value first.", inValueMed_low, s);
		s = queue.getNext();
		System.out.println("s5" + s);
		Assert.assertSame("Expected Low priority value third.", inValueLow, s);
		
	}
	


}
